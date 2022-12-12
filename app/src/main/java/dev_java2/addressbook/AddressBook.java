package dev_java2.addressbook;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook implements ActionListener {
    // 선언
    JFrame jf_addr = new JFrame();
    // JPanel jp_center = new JPanel();
    // JPanel jp_north = new JPanel();
    JButton jbtn_check = new JButton("조회");
    JButton jbtn_enter = new JButton("입력");
    JButton jbtn_corre = new JButton("수정");
    JButton jbtn_detail = new JButton("상세보기");
    AddressDialog aDialog = new AddressDialog();

    // 생성
    public AddressBook() {
        jbtn_enter.addActionListener(this);
        initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_enter) { // 너 입력 버튼 누른 거 ?
            aDialog.jdg.setVisible(true);
        }
    }

    // 화면
    public void initDisplay() {
        jbtn_enter.addActionListener(this);
        jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_addr.add("North", jbtn_enter);
        jf_addr.setTitle("주소록 ver1,0");
        jf_addr.setSize(500, 450);
        jf_addr.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        new AddressBook();
    }

}
