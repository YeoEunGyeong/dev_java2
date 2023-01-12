package dev_java2.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;

import dev_java2.util.DBConnectionMgr;

// 클래스 설계에 있어서 DAO 패턴의 사용은 필수
// 특히나 MyBatis와 같은 ORM솔루션 제공되면서 더 강조됨
// JDBC API > iBatis(Apache) > MyBatis(Google) > JPA(Hibernate) ; 쿼리문 없음(추상적, 조인 ?)
public class ChatDao {
    Connection con = null; // 인터페이스 - 이종간의 만나는 부분(연계, 연동)
    CallableStatement cstmt = null;
    DBConnectionMgr dbMgr = new DBConnectionMgr("nabi", "123");

    public String login(String mem_id, String mem_pw) {
        String mem_name = null;
        try {
            con = dbMgr.getConnection();
            cstmt = con.prepareCall("{call proc_login(?,?,?)}");
            cstmt.setString(1, mem_id);
            cstmt.setString(2, mem_pw);
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            cstmt.executeUpdate();
            mem_name = cstmt.getString(3);
            // System.out.println(mem_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mem_name; // "회원가입한 너 이름"
    }

    public static void main(String[] args) {
        ChatDao cd = new ChatDao();
        String r_name = cd.login("kiwi", "123");
        System.out.println(r_name);
    }
}
