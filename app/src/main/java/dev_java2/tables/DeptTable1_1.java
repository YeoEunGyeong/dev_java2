package dev_java2.tables;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class DeptTable1_1 extends JFrame { // DeptTable is a JFrame
    // 선언
    String header[] = { "부서 번호", "부서명", "지역" };
    String datas[][] = new String[1][3];
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);

    // 생성
    public DeptTable1_1() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        this.setTitle("부서 관리 시스템 ver.1.0");
        this.setSize(500, 400);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        new DeptTable1_1();
    }
}
