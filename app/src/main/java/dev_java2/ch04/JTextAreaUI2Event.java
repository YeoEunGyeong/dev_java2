package dev_java2.ch04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI2Event implements ActionListener {
    JTextAreaUI2 jui2 = null;

    public JTextAreaUI2Event(JTextAreaUI2 jui2) {
        this.jui2 = jui2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (jui2.jtf == obj) { // JTextField에 엔터친 거야 ?
            // JTextField에 입력한 문자열 받기
            String input = jui2.jtf.getText();
            jui2.getTextArea().append("JTextUI 원본 : " + input + "\n");
            // jui2.jtaUILogic.account(input);
            jui2.jtf.setText("");
        }
    }

}
