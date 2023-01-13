package dev_java2.ch08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class KiwiPanel3 extends JPanel implements ActionListener {
    String header[] = { "부서 번호", "부서명", "지역" };
    // String datas[][] = new String[0][3];
    String datas[][] = {
            { "10", "개발", "서울" },
            { "20", "인사", "속초" },
            { "30", "영업", "강릉" } };
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    // JTable 헤더 글자 크기 변경
    JTableHeader jth = jtb_dept.getTableHeader();
    KiwiApp kiwiApp = null;

    public KiwiPanel3() {
        initDisplay();
    }

    public KiwiPanel3(KiwiApp kiwiApp) {
        this();
        this.kiwiApp = kiwiApp;
    }

    public void changeFontSize() {
        jth.setFont(KiwiPanel1.f);
        jtb_dept.setFont(KiwiPanel1.f);
    }

    public void initDisplay() {
        if (KiwiPanel1.isSize) {
            changeFontSize();
        }
        // JPanel은 디폴트 레이아웃 FlowLayout
        // JDialog, JFrame은 디폴트 레이아웃 BorderLayout
        this.setLayout(new BorderLayout());
        this.add("Center", jsp_dept);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
