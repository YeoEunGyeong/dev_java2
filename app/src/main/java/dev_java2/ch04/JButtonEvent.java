package dev_java2.ch04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonEvent implements ActionListener {
    JButtonUI jui = null;

    public JButtonEvent(JButtonUI jButtonUI) {
        this.jui = jButtonUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jui.jbtn_south) {
            System.out.println(jui.jbtn_south.getText() + "버튼클릭");
        }
    }
}
