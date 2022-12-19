package dev_java2.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DeptTable7 extends JFrame implements ActionListener {
    // 선언
    // 파라미터의 this DeptTable7이고, main에서 호출된 생성자
    // 현재 메모리에 로딩 중인 객체를 가르킴
    // this를 넘겨야 하는 이유 ??
    // ; JTabel7Dialog에서 부서 번호, 부서명, 지역 입력 후 저장 누르면
    // Vector<String[]> 추가하고 추가된 로우를 포함하는 Vector가 부모창에
    // 새로 리플래시(재사용 되어야함);부모 클래스에서) 구현 되어야 하기 때문에 호출해야 함
    JTable7Dialog jtd7 = new JTable7Dialog(this);
    String header[] = { "부서 번호", "부서명", "지역" };
    String datas[][] = new String[0][3];
    // String[][] depts = {{ "10", "개발", "서울" }, { "20", "인사", "속초" }, { "30", "영업",
    // "강릉" }};
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_north = new JPanel();
    JButton jbtn_check = new JButton("조회");
    JButton jbtn_input = new JButton("입력");
    JButton jbtn_corre = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");
    JButton jbtn_detail = new JButton("상세보기");
    static Vector<String[]> vdata = new Vector<>(); // vdata.size() = 0;
    JTextField jtf = new JTextField();
    String[] oneRow = null;

    // 생성
    public DeptTable7() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        jp_north.add(jbtn_check);
        jp_north.add(jbtn_input);
        jp_north.add(jbtn_corre);
        jp_north.add(jbtn_del);
        jp_north.add(jbtn_detail);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn_check.addActionListener(this); // 버튼 클릭 시 서브창 띄우는 이벤트 생성
        jbtn_input.addActionListener(this);
        jbtn_corre.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_detail.addActionListener(this);
        this.add("North", jp_north);
        this.add("Center", jsp_dept);
        this.setTitle("부서 관리 시스템 ver.1.0");
        this.setSize(500, 400);
        this.setVisible(true);
    }

    // 새로고침 ; Vector에 담긴 String[] 출력
    // 입력, 수정 화면에서 저장 버튼 누르면 Vector에 String[] 추가
    // 그 다이얼로그 화면은 닫히고 부모창은 새로고침
    // 다이얼로그창에서 부모 클래스의 refreshData 메소드 호출
    // 그렇기 때문에 인스턴스화 할 때 파라미터에 this 넘겨 사용할 수 있도록 해야 함
    public void refreshData() { // 입력, 수정, 삭제 성공 시 화면을 새로고침할 메소드
        System.out.println("refreshData 호출");
        // 입력, 수정 전에 조회된 정보는 삭제
        while (dtm_dept.getRowCount() > 0) {
            dtm_dept.removeRow(0);
        }

        if (DeptTable7.vdata.size() <= 0) {
            JOptionPane.showMessageDialog(this, "조회 결과가 없!", "INFO", JOptionPane.WARNING_MESSAGE);
            return; // refreshData() 탈출
        }
        System.out.println("DeptTable7 !!" + vdata.size());

        // 벡터의 크기만큼 반복하면서 dtm_dept 데이터셋에 String[] 추가
        for (int i = 0; i < vdata.size(); i++) {
            String[] oneRow = vdata.get(i);
            dtm_dept.addRow(oneRow);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        // 조회 ??
        if (obj == jbtn_check) {
            refreshData();
        }
        // 입력 버튼 ??
        else if (obj == jbtn_input) {
            jtd7.set("입력", true, null);
        }
        // 수정 ??
        else if (obj == jbtn_corre) {
            // 어떤 로우 수정 ??
            // JTable 목록에서 선택한 로우의 index 값 가져옴
            int index = jtb_dept.getSelectedRow();
            // 데이셋객체로 벡터를 사용 중이니 벡터에서 꺼낸 값을 String[] 초기화
            // 테이블의 양식 폼인 JTabele 이벤트로 얻어옴
            String[] oneRow = vdata.get(index);
            jtd7.set("수정", true, oneRow);
        }
        // 상세보기 ??
        else if (obj == jbtn_detail) {
        }
    }

    public static void main(String[] args) {
        new DeptTable7();
    }
}
