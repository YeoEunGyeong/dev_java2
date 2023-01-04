package dev_java2.basic3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import dev_java2.util.DBConnectionMgr;

public class ZipCodeSerachView extends JFrame implements ItemListener {
    // 선언
    // 사용자가 선택한 zdo
    String zdo = null;
    // 사용자가 선택한 sigu
    String sigu = null;
    // 사용자가 선택한 dong
    String dong = null;
    // DB에서 가져온 zdos[]
    String[] zdos = null;
    // DB에서 가져온 sigus[]
    String[] sigus = null;
    // DB에서 가져온 dongs[]
    String[] dongs = null;

    // 중분류(sigu), 소분류(dong)
    String totals[] = { "전체" };
    JPanel jp_north = new JPanel();
    JComboBox jcb_zdo = null;
    JComboBox jcb_sigu = null;
    JComboBox jcb_dong = null;
    DBConnectionMgr dbMgr = new DBConnectionMgr();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 생성
    public ZipCodeSerachView() {
        zdos = getZDOList();
        jcb_zdo = new JComboBox(zdos);
        jcb_zdo.addItemListener(this);
        jcb_sigu = new JComboBox(totals);
        jcb_sigu.addItemListener(this);
        jcb_dong = new JComboBox(totals);
        jcb_dong.addItemListener(this);
    }

    // 대분류 정보 초기화에 필요한 DB조회 구현
    public String[] getZDOList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '전체' zdo FROM dual   ");
        sql.append("UNION ALL                     ");
        sql.append("SELECT zdo                    ");
        sql.append("FROM (                        ");
        sql.append("     SELECT distinct(zdo) zdo ");
        sql.append("     FROM zipcode_t           ");
        sql.append("     ORDER BY zdo asc)        ");
        try {
            // con의 주소 번지 확인되면 오라클서버와 연결 통로 확보됨
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            Vector<String> v = new Vector<>();
            // 오라클에서 생성된 테이블의 커서 디폴트 위치는 항상 isTOP
            while (rs.next()) {
                String zdo = rs.getString("zdo");
                v.add(zdo);
            }
            zdos = new String[v.size()];
            v.copyInto(zdos);
        } catch (SQLException se) {
            System.out.println(se.toString()); // getMessage();
            System.out.println(sql.toString());
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            // 사용한 자원 반납 ; 생성된 역순으로 할 것
            // 생략해도 언젠간 반납 이루어지지만 명시적으로 반납 처리 권장
            // 오라클 서버에서 커넥션을 강제로 시키기 때문에 반납! 처리! 권장!
            try {
                dbMgr.freeConnection(con, pstmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return zdos;
    } // end getZDOList

    // 화면
    public void initDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp_north.add(jcb_zdo);
        jp_north.add(jcb_sigu);
        jp_north.add(jcb_dong);
        this.add("North", jp_north);
        this.setSize(630, 400);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        ZipCodeSerachView zcsv = new ZipCodeSerachView();
        zcsv.initDisplay();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Object obj = ie.getSource(); // 이벤트 감지되는 소스 가져오기
        if (obj == jcb_zdo) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("선택한 ZDO : " + zdos[jcb_zdo.getSelectedIndex()]);
                zdo = zdos[jcb_zdo.getSelectedIndex()];
                sigus = getSiguList(zdo);
                // 대분류 결정이 되었을 때 sigus 초기화 해 줘야함
                // 기존에 디폴트로 전체 상수값을 넣어두었기 때문에 이것 삭제
                jcb_sigu.removeAllItems();
                // 새로운 DB서버에서 읽어온 값으로 아이템 추가(초기화)
                for (int i = 0; i < sigus.length; i++) {
                    jcb_sigu.addItem(sigus[i]);
                }
            }
        } // end jcb_zdo
    }// end itemStateChanged

    public String[] getSiguList(String zdo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '전체' sigu FROM dual    ");
        sql.append("UNION ALL                       ");
        sql.append("SELECT sigu                     ");
        sql.append("FROM (                          ");
        sql.append("     SELECT distinct(sigu) sigu ");
        sql.append("     FROM zipcode_t             ");
        sql.append("     WHERE zdo =?               ");
        sql.append("     ORDER BY sigu asc)         ");
        try {
            // con의 주소 번지 확인되면 오라클서버와 연결 통로 확보됨
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, zdo); // =? 자리에 들어가는 값
            rs = pstmt.executeQuery();
            Vector<String> v = new Vector<>(); // CopyInto() 사용 위해 넣은 코드
            // 오라클에서 생성된 테이블의 커서 디폴트 위치는 항상 isTOP
            while (rs.next()) {
                String sigu = rs.getString("sigu");
                v.add(sigu);
            }
            sigus = new String[v.size()]; // sigu 콤보 박스에 들어갈 배열 생성
            v.copyInto(sigus); // Vector에 있는 값 복사
        } catch (SQLException se) {
            System.out.println(se.toString()); // getMessage();
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 사용한 자원 반납 ; 생성된 역순으로 할 것
            // 생략해도 언젠간 반납 이루어지지만 명시적으로 반납 처리 권장
            // 오라클 서버에서 커넥션을 강제로 시키기 때문에 반납! 처리! 권장!
            try {
                dbMgr.freeConnection(con, pstmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sigus;
    }
}
