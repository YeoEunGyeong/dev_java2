package dev_java2.ch03;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons1 {
  public static void main(String[] args) {
    JFrame jtf = new JFrame();
    JButton jbtn_north = new JButton("북쪽");
    JButton jbtn_west = new JButton("서쪽");
    JButton jbtn_center = new JButton("중앙");
    jtf.add("North", jbtn_north);
    jtf.add("West", jbtn_west);
    jtf.add("Center", jbtn_center);
    jtf.setSize(400, 300);
    ;
    jtf.setVisible(true);
  }

}
