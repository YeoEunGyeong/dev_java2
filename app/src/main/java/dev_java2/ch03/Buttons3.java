package dev_java2.ch03;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons3 {
  JFrame jtf = new JFrame();
  JButton jbtns[] = new JButton[3];
  String jbtn_label[] = new String[] { "북쪽", "서쪽", "중앙" };
  String jbtn_loc[] = new String[] { "North", "West", "Center" };

  public void initDisplay() {
    for (int i = 0; i < jbtns.length; i++) {
      jbtns[i] = new JButton(jbtn_label[i]);
      jtf.add(jbtn_loc[i], jbtns[i]);
    }
    jtf.setSize(400, 300);
    jtf.setVisible(true);
  }

  public static void main(String[] args) {
    Buttons3 b2 = new Buttons3();
    b2.initDisplay();
  }

}
