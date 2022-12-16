package dev_java2.tables;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button2 extends JFrame {
    // 선언
    String jbtn_label[] = { "입력", "수정", "삭제" };
    JPanel jp_north = new JPanel();
    JPanel jp_south = new JPanel();
    JButton jbtn_enter = new JButton(jbtn_label[0]);
    JButton jbtn_corre = new JButton(jbtn_label[0]);
    JButton jbtn_del = new JButton(jbtn_label[0]);
    Vector<JButton> vbtns = new Vector<>(jbtn_label.length);
    JButton[] jbtns = { jbtn_enter, jbtn_corre, jbtn_del }; // 반복문을 돌리기 위한 선언 ; index가 필요

    // 생성
    public Button2() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        for (int i = 0; i < vbtns.size(); i++) {
            vbtns.add(jbtns[i]);
            jp_north.add(vbtns.get(i));
            // System.out.println(jbtns[i]);
        }
        this.setSize(400, 500);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        new Button2();
    }
}
