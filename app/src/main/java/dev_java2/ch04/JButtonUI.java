package dev_java2.ch04;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonUI {
    // 선언부
    JFrame jf = new JFrame();
    JButton jbtn_south = new JButton("전송"); // ============4
    JButtonEvent jbtnEvent = new JButtonEvent(this); // ===========5
    // 생성자 ===========2

    public JButtonUI() {
        initDisplay();
    }

    // 화면처리부 ===========1
    public void initDisplay() {
        // 이벤트 소스와 이벤트 핸들러 매핑시 this를 쓸 수 있는 건
        // 오직 내 안에 actionPerformed가 구현되어 있을 때 뿐임
        jbtn_south.addActionListener(jbtnEvent); // =========== 6 ()괄호추가
        // 윈도우창 x버튼 클릭시 자원반납 - 어플 정상 종료
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add("South", jbtn_south);
        jf.setSize(300, 200);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JButtonUI(); // =========3
    }
}
