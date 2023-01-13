package dev_java2.ch08;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiwiApp extends JFrame implements ActionListener {
    String imgPath = "D:\\vscode_java\\dev_java2\\images\\kiwiapp\\";
    Image img[] = null;
    ImageIcon imgs[] = new ImageIcon[3];
    String imgNames[] = { "admin2.png", "delay.png", "broken2.png" };
    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JButton jbtn1 = new JButton();
    JButton jbtn2 = new JButton();
    JButton jbtn3 = new JButton();
    JButton imgButton[] = { jbtn1, jbtn2, jbtn3 };
    Container conn = this.getContentPane(); // JFrame에서만 주입 가능
    // JPanle에서는 생성 불가
    // 생성자 파라미터를 통해 넘겨서 사용해야 함
    KiwiPanel1 kPanel1 = null;
    KiwiPanel2 kPanel2 = null;
    KiwiPanel3 kPanel3 = null;

    public KiwiApp() {
    }

    public void initDisplay() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        jbtn3.addActionListener(this);
        jp_center.setBackground(Color.BLUE);
        jp_south.setLayout(new GridLayout(1, 3));
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = new ImageIcon(imgPath + imgNames[i]);
            imgButton[i].setIcon(imgs[i]);
            imgButton[i].setBorderPainted(false); // 버튼 테두리 선 페인팅 없앰
            imgButton[i].setFocusPainted(false); // 버튼 누르면 보이는 선 Xxx
            imgButton[i].setContentAreaFilled(false);
            jp_south.add(imgButton[i]);
        }
        jp_south.add(jbtn1);
        jp_south.add(jbtn2);
        jp_south.add(jbtn3);
        this.add("Center", jp_center);
        this.add("South", jp_south);
        this.setSize(400, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        KiwiApp kApp = new KiwiApp();
        KiwiPanel1 kP1 = new KiwiPanel1();
        kApp.initDisplay();
        kP1.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        // 첫째 버튼 눌렀어 ??
        if (obj == jbtn1) {
            System.out.println("첫째");
            if (kPanel2 != null) {
                conn.remove(kPanel2.jta);
                conn.remove(kPanel2.jtf);
                conn.remove(kPanel2);
            }
            if (kPanel3 != null) {
                conn.remove(kPanel3.jsp_dept);
                conn.remove(kPanel3);
            }
            kPanel1 = new KiwiPanel1(); // 생성자 안에서 initDisplay() 호출
            this.add("Center", kPanel1);
            conn.revalidate();
        } else if (obj == jbtn2) { // 둘째 ??
            System.out.println("둘째");
            if (kPanel1 != null) {
                conn.remove(kPanel1.jbtn1);
                conn.remove(kPanel1.jbtn2);
                conn.remove(kPanel1.jbtn3);
                conn.remove(kPanel1);
            }
            if (kPanel2 != null) {
                conn.remove(kPanel2.jta);
                conn.remove(kPanel2.jtf);
                conn.remove(kPanel2);
            }
            kPanel2 = new KiwiPanel2(this); // 생성자 안에서 initDisplay() 호출
            this.add("Center", kPanel2);
            conn.revalidate();
        } else if (obj == jbtn3) { // 셋째 ??
            System.out.println("셋째");
            if (kPanel1 != null) {
                conn.remove(kPanel1.jbtn1);
                conn.remove(kPanel1.jbtn2);
                conn.remove(kPanel1.jbtn3);
                // conn.remove(kPanel1);
            }
            if (kPanel2 != null) {
                conn.remove(kPanel2.jta);
                conn.remove(kPanel2.jtf);
                // conn.remove(kPanel2);
            }
            kPanel3 = new KiwiPanel3(this); // 생성자 안에서 initDisplay() 호출
            this.add("Center", kPanel3);
            conn.revalidate();
        }
    }
}
