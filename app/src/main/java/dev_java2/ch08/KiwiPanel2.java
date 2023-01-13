package dev_java2.ch08;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class KiwiPanel2 extends JPanel implements ActionListener {
    JTextArea jta = new JTextArea("");
    JTextField jtf = new JTextField("");
    KiwiApp kiwiApp = null;

    public KiwiPanel2() {
        initDisplay();
    }

    public KiwiPanel2(KiwiApp kiwiApp) {
        this(); // 16열 자기 자신 디폴트 생성자 호출
        this.kiwiApp = kiwiApp;
    }

    public void changeFontSize() {
        jta.setFont(KiwiPanel1.f);
        jtf.setFont(KiwiPanel1.f);
    }

    public void initDisplay() {
        if (KiwiPanel1.isSize) {
            changeFontSize();
        }
        this.setLayout(new BorderLayout());
        this.add("Center", jta);
        this.add("South", jtf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new KiwiPanel2();
    }
}
