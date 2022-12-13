package dev_java2.addressbook;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

public class AddressBook implements ActionListener {
    // 선언
    // 이미지 경로 선언
    String imgPath = "D:\\vscode_java\\dev_java2\\images\\address\\";
    // 툴바 및 타이틀 이미지 설정
    ImageIcon titlIcon = new ImageIcon(imgPath + "memo.png");
    JToolBar jtb = new JToolBar();
    JFrame jf_addr = new JFrame();
    // 메뉴바 구성
    JMenuBar jmb = new JMenuBar();
    JMenu jm_file = new JMenu("File");
    JMenuItem jmi_db = new JMenuItem("DB 연동 확인");
    JMenuItem jmi_all = new JMenuItem("전체 조회");
    JSeparator js_exit = new JSeparator(); // 메뉴 아이템 분리
    JMenuItem jmi_exit = new JMenuItem("종료");
    JMenu jm_edit = new JMenu("Edit");
    JMenuItem jmi_enter = new JMenuItem("입력");
    JMenuItem jmi_corre = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JMenuItem jmi_detail = new JMenuItem("상세보기");

    JButton jbtn_del = new JButton();
    JButton jbtn_enter = new JButton();
    JButton jbtn_corre = new JButton();
    JButton jbtn_detail = new JButton();
    // BorderLayout 중앙에 테이블(주소록 목록) 추가
    // JTable header에 들어갈 문자열 선언
    String[] header = { "번호", "이름", "HP" };
    // JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요
    String[][] datas = new String[3][3];
    // JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스 선언 (27열)
    // 보여지는 실제 데이터는 DefaultTableModel 클래스를 통해 제어 해야 함을 의미
    DefaultTableModel dtm_addr = new DefaultTableModel(datas, header);
    JTable jtb_addr = new JTable(dtm_addr);
    // DefaultTableModel의 로우수가 많아지는 경우 스크롤바 추가
    // JScrollpane은 스크롤바를 품고 있는 일종의 속지
    // 첫 번째 파라미터는 양식을 가진 JTable이고 두 번째는 수직 스크롤바 정책, 세 번째는 수평 스크롤바 정책
    JScrollPane jsp_addr = new JScrollPane(jtb_addr, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JTextField jtf_input = new JTextField();
    AddressDialog aDialog = new AddressDialog();

    // 생성
    public AddressBook() {
        initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jmi_all) { // 전체 조회
            String members[][] = {
                    { "1", "김태연", "010-1111-2222" }, { "2", "유지민", "010-3333-4444" }, { "3", "김민정", "010-5555-6666" }
            };
            // 이미 테이블에 조회된 정보가 있는 경우, 모두 삭제하고 새롭게 출력
            while (dtm_addr.getRowCount() > 0) {
                dtm_addr.removeRow(0);
            }
            for (int i = 0; i < members.length; i++) {
                Vector<String> oneRow = new Vector<>();
                oneRow.add(members[i][0]); // 번호
                oneRow.add(members[i][1]); // 이름
                oneRow.add(members[i][2]); // HP
                dtm_addr.addRow(oneRow);
            }
            // 익명 클래스 문법 사용 ; 자바 람다식, 자바스크립트 Arrow Function 문법과 유사, 코틀린 문법
            jsp_addr.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    JScrollBar jsb = (JScrollBar) e.getSource();
                    jsb.setValue(jsb.getMaximum());
                }
            });
        } else if (obj == jbtn_enter) { // 너 입력 버튼 누른 거 ?
            aDialog.setDialog(jmi_enter.getText(), true);
        } else if (obj == jbtn_corre) {
            aDialog.setDialog(jmi_corre.getText(), true);
        } else if (obj == jbtn_detail) {
            aDialog.setDialog(jmi_detail.getText(), true);
        } else if (obj == jmi_exit) { // 메뉴바 file 종료 버튼 클릭 시 종료
            System.exit(0); // 한 번에 모든 창 종료
            // jf_addr.dispose(); 창 하나씩 따로 종료시키고 싶을 때 사용
        }
    }

    // 화면
    public void initDisplay() {
        jm_file.setMnemonic('F'); // 단축어 생성
        jm_edit.setMnemonic('E');
        jbtn_enter.setIcon(new ImageIcon(imgPath + "new.gif"));
        jbtn_enter.setToolTipText("입력");
        jbtn_corre.setIcon(new ImageIcon(imgPath + "update.gif"));
        jbtn_corre.setToolTipText("수정");
        jbtn_del.setIcon(new ImageIcon(imgPath + "delete.gif"));
        jbtn_del.setToolTipText("삭제");
        jbtn_detail.setIcon(new ImageIcon(imgPath + "detail.gif"));
        jbtn_detail.setToolTipText("상세보기");

        jmi_all.addActionListener(this);
        jbtn_del.addActionListener(this); // 이벤트 소스와 이벤트 핸들러 클래스 매칭
        jbtn_enter.addActionListener(this);
        jbtn_corre.addActionListener(this);
        jbtn_detail.addActionListener(this);
        jmi_exit.addActionListener(this);
        jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 종료
        // JPanel은 FlowLayout이 기본값인데 사용자 정의 크기와 위치를 위해 레이아웃 뭉갠다
        // jp_north.setLayout(new FlowLayout(FlowLayout.LEFT)); // 일렬로 배치하는 레이아웃 ; 왼쪽으로
        // 설정
        // jp_north.setLayout(null);
        // jbtn_all.setBounds(20, 120, 120, 30);
        // jp_north.add(jbtn_all);
        jf_addr.add("North", jtb); // 판넬을 최초에 하나만
        jtb.add(jbtn_enter);
        jtb.add(jbtn_corre);
        jtb.add(jbtn_del);
        jtb.add(jbtn_detail);
        jf_addr.add("Center", jsp_addr);
        jmb.add(jm_file);
        jm_file.add(jmi_db);
        jm_file.add(jmi_all);
        jm_file.add(js_exit);
        jm_file.add(jmi_exit);
        jmb.add(jm_edit);
        jm_edit.add(jmi_enter);
        jm_edit.add(jmi_corre);
        jm_edit.add(jmi_del);
        jm_edit.add(jmi_detail);
        jf_addr.setJMenuBar(jmb);
        jf_addr.setIconImage(titlIcon.getImage());
        jf_addr.setTitle("주소록 ver1,0");
        jf_addr.setSize(500, 450);
        jf_addr.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        // 스윙 스킨 입히기
        JFrame.setDefaultLookAndFeelDecorated(true);
        new AddressBook();
    }
}