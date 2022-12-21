package dev_java2.ch05;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;

public class CalculatorApp extends JFrame {
    // 선언
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
    Font f = new Font("Paryrus", Font.BOLD,32);
    
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
        jp_center.setLayout(new GridLayout(2,6,2,2));
        jp_center.add(jbtn_plus);
        jp_center.add(jbtn_minus);
        jp_center.add(jbtn_mult);
        jp_center.add(jbtn_div);
        jp_center.add(jbtn_equal);
        jp_center.add(jbtn_clear);
        jp_center.add(jbtn_one);
        jp_center.add(jbtn_two);
        jtf_display.setEditable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add("North", jtf_display);
        this.add("Center", jp_center);
        this.setTitle("내가 만든 쿠키~~~!");
        this.setSize(500, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }

}
