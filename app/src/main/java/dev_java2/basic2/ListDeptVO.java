package dev_java2.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev_java2.tables.DeptVO;
import dev_java2.util.DBConnectionMgr;

public class ListDeptVO {
    DBConnectionMgr dbMgr = new DBConnectionMgr();
    Connection con = null; // 오라클 서버와 연결 통로 확보
    PreparedStatement pstmt = null; // 자바에서 오라클 서버로 DML 전달
    ResultSet rs = null; // 커서를 조작하는 함수

    public List<DeptVO> getEmpList() {
        List<DeptVO> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT                         ");
        sql.append("       empno, ename, dname     ");
        sql.append("  FROM emp, dept               ");
        sql.append(" WHERE emp.deptno = dept.deptno");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            list = new ArrayList<>(); // list.size(); //0 아무것도 추가 X
            DeptVO dVO = null;
            while (rs.next()) {
                // 마지막 파라미터만 null이 아닌 이유는 테이블을 두 가지 가져다 쓰고 있기 때문에 DeptVO 안에는 empno, ename 없어 초기화 불가
                dVO = new DeptVO(0, null, rs.getString("dmame")); // 디폴트 생성자 0, null, null
                /*
                System.out.println(rs.getInt("empno") + ", " + rs.getString("ename") + ", " + rs.getString("dname"));
                */
                list.add(dVO); // 0부터 차례대로 추가
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } //end ListDeptVO

    public static void main(String[] args) {
        ListDeptVO listDeptVO = new ListDeptVO();
        List<DeptVO> list = null;
        list = listDeptVO.getEmpList();
        System.out.println("list : " + list);
        for (DeptVO rdVO : list) {
            // System.out.println(rdVO); // while문 타지 않으면 null
            System.out.println(rdVO.getDeptno() + ", " + rdVO.getDname() + ", " +rdVO.getLoc());
        }
    } //end main
}