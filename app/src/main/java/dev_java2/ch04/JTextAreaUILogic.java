package dev_java2.ch04;

import javax.swing.JTextArea;

// 메모리 StackOverFlow 발생 ; 서버 중지됨
public class JTextAreaUILogic {
    // 여기서 직접 인스턴스화하면 복제본 생성 ; 복제본에 출력되기 때문에 망~
    JTextAreaUI jtaUI = null;

    public JTextAreaUILogic(JTextAreaUI jTextAreaUI) {
        // 생성자 안에서 JTextAreaUI의 JTextArea 원본과 전변을 초기화해 주어야 함
        this.jtaUI = jTextAreaUI; // 이해 ? Xxxxxxxxx
    }

    public void account(String input) {
        System.out.println("account 호출 성공");
        // JTextAreaUI 클래스에 정의된 주소 번지 사용하고 싶음 어떡하지?
        // insert here
        jtaUI.jta.append("UILogic : " + input + "\n");
    }

}
