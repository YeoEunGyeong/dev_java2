package dev_java2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionMgr {
    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String _URL = "jdbc:oracle:thin:@192.168.10.85:1521:orcl11";
    public static String _USER = "scott";
    public static String _PW = "tiger";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (ClassNotFoundException ce) {
            System.out.println("드라이버 클래스 XXXXxxx");
        } catch (Exception e) { // 멀티 블럭 작성 시 더 넓은 클래스가 뒤에 와야함
            System.out.println("커넥션 실패");
        }
        return con;
    }

    // 사용한 자원 반납(INSERT, UPDATE, DELETE)
    // 반납 코드는 명시적으로 사용하는 것을 원칙
    // 반납하는 순서는 생성된 역순으로 진행
    public void freeConnection(Connection con, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void freeConnection(Connection con, PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    // 사용한 자원 반납(SELECT)
    public void freeConnection(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) {
        DBConnectionMgr dbMgr = new DBConnectionMgr();
        Connection con = dbMgr.getConnection();
        System.out.println("con : " + con);
    }
}

/*
 * JDBC API 이용하여 DB연동
 * 1 각 제조사가 제공하는 드라이버 클래스 로딩
 *   Class.forName(드라이버 클래스 풀네임); 
 * 2 물리적으로 떨어져있는 오라클 서버와 연결 통로 확보
 *   Connection con = DriverManger.getConnection(URL,"scott","tiger");
 *   // Connection은 인터페이스 ; 오른쪽에 구현체 클래스 와야함
 * 3 DML문(;데이터 조작어)을 자바에서 오라클 서버로 전달해 줄 인터페이스 생성 ; Statement(정적 쿼리문),
 * PrepareStatement(동적 쿼리문)
 * 4 SELECT문의 경우 오라클 서버에서 제공하는 커서를 지원하는 ResultSet 인터페이스 활용하여
 * 테이블에 제공되는 커서 조작하여 해당 로우에 데이터 존재 시 Cursor-open-fetch 과정을 통해
 * 오라클 서버로부터 데이터 꺼내 List<DeptVO>에 담음
 * 주의! INSERT, UPDATE, DELETE는 커서 필요 없음(commit, rollback), return값은 int
 * ; 요청 시 executeUpdate(INSERT, UPDATE, DELETE문)
 * SELECT일 때 ResultSet rs = excuteQuery("SELECT * FROM dept");
 * 오라클에서 제공되는 커서 조작 인터페이스를 리턴 타입으로 제공 받아 조회 결과 Collection에 담을 수 있음
 * List<DeptVO> = deptList = new ArrayList<>();
 * DeptVO dVO = null;
 * while(rs.next()){
 * dVO = new DeptVO();
 * 
 * deptList.add(VO)
 * }
 * 
 * 사용한 자원을 반납하는 경우 역순으로 닫아주면 됨
 * SELECT
 * ; ResultSet 먼저 닫음 > Statement / PreparedStatement 닫음 > Connection 닫음
 * 닫지 않으면 자동으로 닫아지기는 하지만 명시적으로 닫아주면
 * 닫는 시간을 앞당길 수 있어 프로젝트에서는 코드 작성 필요
 * 
 * INSERT, UPDATE, DELETE
 * ; 두 번째, 세 번째만 닫으면 됨 (리턴 타입이 커서가 필요없기 때문)
 */