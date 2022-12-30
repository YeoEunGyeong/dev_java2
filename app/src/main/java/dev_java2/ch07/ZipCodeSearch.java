package dev_java2.ch07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dev_java2.util.DBConnectionMgr;

public class ZipCodeSearch {
    Connection con = null; // 인터페이스
    PreparedStatement pstmt = null; // 인터페이스
    ResultSet rs = null; // 인터페이스
    DBConnectionMgr dbMgr = new DBConnectionMgr();

    public Integer[] getZipcode(String dong) {
        System.out.println("getZipecode 호출 완 " + dong);
        Integer[] zipcodes = null;
        // List<Integer> imsi = new ArrayList<>();
        Vector<Integer> imsi = new Vector<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT");
        sql.append(" zipcode");
        sql.append(" FROM zipcode_t");
        sql.append(" WHERE dong LIKE ?||'%'");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dong);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("zipcode"));
                int code = rs.getInt("zipcode");
                imsi.add(code);
            }
            zipcodes = new Integer[imsi.size()];
            imsi.copyInto(zipcodes); // Vector에서만 사용한 메서드
            for (int c : zipcodes) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 라인 번호 출력, 이력 출력
        } finally { // 사용 자원 반납
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return zipcodes;
    }

    /*
     * public List<Integer> getZipcode(String dong) {
     * }
     */
    public static void main(String[] args) {
        ZipCodeSearch zcs = new ZipCodeSearch();
        zcs.getZipcode("역삼");
    }
}
