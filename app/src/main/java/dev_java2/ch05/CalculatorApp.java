package dev_java2.ch05;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;

public class CalculatorApp extends JFrame implements ActionListener {
    // 선언
    static int i; // 연산자 값을 넣기 위한 변수 2개 선언
    static int j;
    JTextField jtf_display = new JTextField(10);
    JPanel jp_center = new JPanel();
    JButton jbtn_clear = new JButton("C");
    JButton jbtn_equal = new JButton("=");
    JButton jbtn_one = new JButton("1");
    JButton jbtn_two = new JButton("2");
    JButton jbtn_plus = new JButton("+");
    JButton jbtn_minus = new JButton("-");
    JButton jbtn_mult = new JButton("*");
    JButton jbtn_div = new JButton("/");
    Font f = new Font("Paryrus", Font.BOLD, 32);

    /*
     * double account(String cal) {
     * double tot = 0;
     * if ("+".equals(cal)) {
     * tot = i + j;
     * } else if ("-".equals(cal)) {
     * tot = i - j;
     * } else if ("*".equals(cal)) {
     * tot = i * j;
     * } else if ("/".equals(cal)) {
     * tot = i / (double) j;
     * }
     * return tot;
     * }
     */

    // 생성
    public CalculatorApp() {
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        jbtn_one.setForeground(Color.GRAY);
        jbtn_two.setForeground(Color.MAGENTA);
        jbtn_one.setFont(f);
        jbtn_two.setFont(f);
        jp_center.setBackground(Color.DARK_GRAY);
        jp_center.setLayout(new GridLayout(2, 6, 2, 2));
        jp_center.add(jbtn_plus);
        jp_center.add(jbtn_minus);
        jp_center.add(jbtn_mult);
        jp_center.add(jbtn_div);
        jp_center.add(jbtn_equal);
        jp_center.add(jbtn_clear);
        jp_center.add(jbtn_one);
        jp_center.add(jbtn_two);
        jbtn_plus.addActionListener(this);
        jbtn_minus.addActionListener(this);
        jbtn_mult.addActionListener(this);
        jbtn_div.addActionListener(this);
        jbtn_equal.addActionListener(this);
        jbtn_clear.addActionListener(this);
        jbtn_one.addActionListener(this);
        jbtn_two.addActionListener(this);
        jtf_display.setEditable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add("North", jtf_display);
        this.add("Center", jp_center);
        this.setTitle("내가 만든 쿠키~~~!");
        this.setSize(500, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (jbtn_plus == obj) {
            System.out.println();
        } else if (jbtn_minus == obj) {
            System.out.println();
        } else if (jbtn_mult == obj) {
            System.out.println();
        } else if (jbtn_div == obj) {
            System.out.println();
        } else if (jbtn_equal == obj) {
            System.out.println();
        } else if (jbtn_clear == obj) {
            System.out.println();
        } else if (jbtn_one == obj) {
            System.out.println();
        } else if (jbtn_two == obj) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
