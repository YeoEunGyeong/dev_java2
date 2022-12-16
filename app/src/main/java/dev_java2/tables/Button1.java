package dev_java2.tables;

import javax.swing.JButton;
// 버튼 3개를 객체 배열로 변경
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button1 extends JFrame {
    // 선언
    String jbtn_label[] = { "입력", "수정", "삭제" };
    JPanel jp_north = new JPanel();
    JPanel jp_south = new JPanel();
    JButton jbtn_enter = new JButton("입력");
    JButton jbtn_corre = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");
    JButton[] jbtns = new JButton[3]; // >>22열
    // 생성

    public Button1() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        for (int i = 0; i < jbtns.length; i++) {
            jbtns[i] = new JButton(jbtn_label[i]);
            jp_south.add(jbtns[i]);
        }
        jp_north.add(jbtn_enter);
        jp_north.add(jbtn_corre);
        jp_north.add(jbtn_del);
        this.add("North", jp_north);
        this.add("South", jp_south);
        this.setSize(400, 500);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        new Button1();
    }
}
