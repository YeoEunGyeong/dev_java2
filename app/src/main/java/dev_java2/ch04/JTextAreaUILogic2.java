package dev_java2.ch04;

import javax.swing.JTextArea;

public class JTextAreaUILogic2 {
    JTextAreaUI2 jtaUI = null;

    public JTextAreaUILogic2(JTextAreaUI2 jTextAreaUI2) {
        this.jtaUI = jTextAreaUI2;
    }

    public void account(String input) {
        System.out.println("account 호출 성공");
        // JTextAreaUI 클래스에 정의된 주소 번지 사용하고 싶음 어떡하지?
        // insert here
        jtaUI.jta.append("UILogic : " + input + "\n");
    }

}
