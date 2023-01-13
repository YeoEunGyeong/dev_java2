package dev_java2.ch08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KiwiPanel1 extends JPanel implements ActionListener {
    JButton jbtn1 = new JButton("배경화면");
    JButton jbtn2 = new JButton("글꼴");
    JButton jbtn3 = new JButton("글자크기");
    // static으로 해야 하는 이유 ; 패널1에서 결정된 설정이 패널2,3에도 반영되어야 함
    static Font f = null;
    static boolean isSize = false;

    public KiwiPanel1() {
        initDisplay();
    }

    public void initDisplay() {
        jbtn3.addActionListener(this);
        this.setLayout(null);
        jbtn1.setBounds(140, 80, 100, 30);
        jbtn2.setBounds(140, 150, 100, 30);
        jbtn3.setBounds(140, 220, 100, 30);
        this.add(jbtn1);
        this.add(jbtn2);
        this.add(jbtn3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn3) {
            if (!isSize) {
                f = new Font("굴림체", Font.BOLD, 15);
                jbtn1.setFont(f);
                jbtn2.setFont(f);
                jbtn3.setFont(f);
                isSize = true;
            } else {
                f = new Font("굴림체", Font.PLAIN, 12);
                jbtn1.setFont(f);
                jbtn2.setFont(f);
                jbtn3.setFont(f);
                isSize = false;
            }
        }
    }

    public static void main(String[] args) {
        KiwiPanel1 kPanel1 = new KiwiPanel1();
        kPanel1.initDisplay();
    }
}

/*
 * 생성자 안에 initDisplay() 호출하는 것과 그렇지 않은 점의 차이 ??
 * ; 위치의 문제
 * 화면 정의서의 요구 사항에 따라 다른 선택이 됨
 */