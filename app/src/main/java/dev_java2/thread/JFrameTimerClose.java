package dev_java2.thread;

import javax.swing.JFrame;

public class JFrameTimerClose extends JFrame {
    public JFrameTimerClose() {
        super("JFrame Test 5초 후 창닫기");
        this.setSize(500, 500);
        this.setVisible(true);
        // 5초 대기
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        setVisible(false);
    }

    public static void main(String[] args) {
        new JFrameTimerClose(); // 생성자 호출
    }

}
