package dev_java2.network1;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeClientView extends JFrame {
    // 선언
    JLabel jlb_timer = new JLabel("현재 시간", JLabel.CENTER);
    Font f = new Font("바탕체", Font.BOLD, 28);

    // 생성
    TimeClientView() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        Thread th = new TimeClient(jlb_timer);
        th.start();
        jlb_timer.setFont(f);
        this.add("Center", jlb_timer);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        new TimeClientView();
    }
}
