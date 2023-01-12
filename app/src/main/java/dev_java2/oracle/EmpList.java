package dev_java2.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev_java2.util.DBConnectionMgr;
// 모든 RDBMS에서 제공되는 타입이 아니라 오라클에서만 제공되는 타입 ; sys_refcursor
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

public class EmpList {
    Connection con = null;
    CallableStatement cstmt = null;
    OracleCallableStatement ocstmt = null;
    DBConnectionMgr dbMgr = new DBConnectionMgr();
    ResultSet rs = null; // 오라클 커서 조작하는데 필요한 추상 메서드

    public List<Map<String, Object>> getEmpList() {
        List<Map<String, Object>> list = new ArrayList<>();
        // insert here ; 소스 어디에 붙여 ?? API 보고 실습 코드 적용
        try {
            con = dbMgr.getConnection("scott", "tiger");
            cstmt = con.prepareCall("{call my_proc(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            // 굳이 추가로 제공되는 클래스로 치환되는 것은 ResultSet 주입 받는 메서드 호출 필요
            // CallableStatement에서는 getCursor() 지원하지 않기 때문에 형전환
            ocstmt = (OracleCallableStatement) cstmt;
            rs = ocstmt.getCursor(1);
            Map<String, Object> rmap = null; // 게으른 인스턴스화
            while (rs.next()) {
                rmap = new HashMap<>();
                rmap.put("empno", rs.getInt(1));
                rmap.put("deptno", rs.getInt(2));
                rmap.put("ename", rs.getString(3));
                // list에 map 추가
                // list에 튜플 추가
                // map에는 컬럼 추가
                list.add(rmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 프로시저 안에서는 여러가지의 DML문을 한 번 서버에 접속한 상태에서 한 번에 처리 가능
    // commit, rollback 가능
    // 자바로 꺼내서 처리하지 않고 프로시저 내부에서 비지니스 로직(업무 포함 프로세스)
    // 처리 가능 ; 변수 활용과 제어문 사용
    // 프로시저 내붕서 자바의 힘을 빌리지 않고 처리할 수 있는 프로세스들이 있음 ; 시스템 부하 줄임
    public static void main(String[] args) {
        EmpList eList = new EmpList();
        List<Map<String, Object>> list = eList.getEmpList();
        System.out.println(list);
    }
}
