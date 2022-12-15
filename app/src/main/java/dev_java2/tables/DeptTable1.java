package dev_java2.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
// 어떤 클래스를 상속 받을 때는 extends 예약어 사용
// A is a B 관계면 상속으로 처리
// 소나타는 자동차이다 Ooooooo 자동차는 소나타이다 Xxxxxx
// 부모 클래스가 가진 변수와 메소드 사용 가능 ; 자손 클래스가 더 많이 누릴 수 있음
public class DeptTable1 extends JFrame{ // DeptTable is a JFrame
    // 선언
    String header[] = {"부서 번호", "부서명", "지역"};
    String datas[][] = new String[1][3];
    // this는 사용되는 클래스 영역에서 선언된 클래스를 가르킴
    // 그러면 여기서 this는 DeptTable1
    // 그런데, DefaultTableModel은 자바에서 제공되는 클래스 ; 생성자도 지정되어 있음
    // 생성자는 메소드 오버로딩 규칙을 따름 ; 파라미터의 갯수나 타입 달라야함
    // 제공되는 생성자에 없기 때문에 사용 Xxxxxx 결국, 컴파일 에러(문법 에러) 발생!!
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
    JTable jtb_dept = new JTable(dtm_dept); 
    JScrollPane jsp_dept = new JScrollPane(jtb_dept
    , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_north = new JPanel();
    JButton jbtn_check = new JButton("조회");
    JButton jbtn_input = new JButton("입력");
    JButton jbtn_corre = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");




    // 생성
    public DeptTable1(){
        initDisplay();
    }
    // 화면
    public void initDisplay(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp_north.add(jbtn_check);
        jp_north.add(jbtn_input);
        jp_north.add(jbtn_corre);
        jp_north.add(jbtn_del);
        this.add("North",jp_north);
        this.add("Center",jsp_dept);
        this.setTitle("부서 관리 시스템 ver.1.0");
        this.setSize(500, 400);
        this.setVisible(true);
    }
    
    // 메인
    public static void main(String[] args) {
        new DeptTable1();
    }
}
