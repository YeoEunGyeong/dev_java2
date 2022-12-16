package dev_java2.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

// ActionListener ; 인터페이스 ; 단독으로 인스턴스화 불가, 구현체 클래스 필요
// 추상 메소드를 선언하고 있음
// ActionListener al = new DeptTable1_2(); 선언부와 생성부가 다를 수 있음 ; 이럴 때만 다형성 가능
// 선언부와 생성부가 다르다 ?? 동일한 메소드를 호출했는데 다른 기능이 처리 ??
// 추상 클래스도 구현체 클래스가 필요
// Duck myDuck = new WoodDuck(); myDuck.fly()
// Duck herDuck = new RubberDuck(); herDuck.fly()
// Duck himDuck = new MallardDuck(); himDuck.fly()

public class DeptTable1_2 extends JFrame implements ActionListener { // DeptTable is a JFrame
    // 선언
    String header[] = { "부서 번호", "부서명", "지역" };
    String datas[][] = new String[0][3];
    String[][] depts = {
            { "10", "개발", "서울" }, { "20", "인사", "속초" }, { "30", "영업", "강릉" }
    };
    // this는 사용되는 클래스 영역에서 선언된 클래스를 가르킴
    // 그러면 여기서 this는 DeptTable1
    // 그런데, DefaultTableModel은 자바에서 제공되는 클래스 ; 생성자도 지정되어 있음
    // 생성자는 메소드 오버로딩 규칙을 따름 ; 파라미터의 갯수나 타입 달라야함
    // 제공되는 생성자에 없기 때문에 사용 Xxxxxx 결국, 컴파일 에러(문법 에러) 발생!!
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_north = new JPanel();
    JButton jbtn_check = new JButton("조회");
    JButton jbtn_input = new JButton("입력");
    JButton jbtn_corre = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");

    // 생성
    public DeptTable1_2() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp_north.add(jbtn_check);
        jp_north.add(jbtn_input);
        jp_north.add(jbtn_corre);
        jp_north.add(jbtn_del);
        jbtn_check.addActionListener(this);
        jbtn_del.addActionListener(this);
        this.add("North", jp_north);
        this.add("Center", jsp_dept);
        this.setTitle("부서 관리 시스템 ver.1.0");
        this.setSize(500, 400);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        new DeptTable1_2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_del) {
            int index = jtb_dept.getSelectedRow();
            System.out.println(index);
            Integer deptno = Integer.parseInt((String) dtm_dept.getValueAt(index, 0));
            System.out.println(deptno);
        }
        if (obj == jbtn_check) { // 너 조회 눌렀어 ??
            for (int x = 0; x < depts.length; x++) {
                Vector<String> oneRow = new Vector<>();
                oneRow.add(depts[x][0]); // 부서 번호
                oneRow.add(depts[x][1]); // 부서명
                oneRow.add(depts[x][2]); // 지역
                dtm_dept.addRow(oneRow);
            }
            for (int i = 0; i < depts.length; i++) {
                for (int j = 0; j < depts[i].length; j++) {
                    // System.out.print(depts[i][j] + " "); // 3개 출력하고 줄바꿈
                    // dtm_dept.setValueAt("Xxxxxx", i, j)); // set = write ; 정보를 추가 입력
                    // System.out.println(dtm_dept.getValueAt(i, j)); // ??? get = read ; 정보를 읽어오는 것
                } // end of inner for
                System.out.println();
            } // end of outter for
              // DefaultTableModel에 데이터 초기화
        } // end of 조회
    }
}
