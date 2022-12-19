package dev_java2.ch05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Button1 extends JFrame {
    // 선언
    // 구현해 놓은 기능을 넘겨 받아 이벤트 처리 필요
    // 그러기 위해서 Button1 = this(자기 자신);하나의 인스턴스화 된 자기 자신 사용
    Button1Event bevent = new Button1Event(this); // 상속, 추상 클래스 중심, 인터페이스 중심 코딩 전개

    JButton jbtn_enter = null; // 선언만! 생성자 호출 안 됨 // 북쪽 배치
    JButton jbtn_corre = new JButton("수정"); // 선언 및 생성! 생성자 호출까지 일어남 // 남쪽
    // 생성

    Button1() {
        System.out.println("Button1 디폴트 생성자 호출" + jbtn_enter);
        // 생성자 안에서 버튼 객체 생성 시 뭐가 다른 점 ?? ;시점에 따라 NullPointerException 발생 가능

        initDisplay(); // new Button1() 호출 시 자동으로 호출 일어남
        System.out.println("initDisplay 호출 후" + jbtn_enter == null);
        jbtn_enter = new JButton("입력");
        System.out.println("입력 버튼 생성 후!!! " + jbtn_enter == null);
    }

    // 화면
    public void initDisplay() {
        jbtn_corre.addActionListener(bevent); // this 사용 Xxxxx
        System.out.println("initDisplay 호출 성공");
        JButton jbtn_del = new JButton("삭제"); // 동쪽
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (jbtn_enter != null) {
            this.add("North", jbtn_enter);
        }
        // this.add("North", jbtn_enter);
        this.add("South", jbtn_corre);
        this.add("East", jbtn_del);
        this.setSize(400, 300);
        this.setVisible(true);
    }

}

// ActionListener의 구현체 클래스 ; 이벤트 핸들러 클래스
// 인터페이스는 추상 메소드만 가짐
class Button1Event implements ActionListener { // Button1 필요
    Button1 button1 = null; // 주석 처리 시 컴파일 에러

    public Button1Event(Button1 button1) {
        this.button1 = button1; // this 46열 인스턴스화의 button1 가르킴
        // 48열 주석 처리 시 문법 에러
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        // 너 수정 버튼 눌렀어 ??
        if (obj == button1.jbtn_corre) {
            System.out.println("수정 클릭");
        }
    }
}

public class Button1Main { // Button1 필요
    public static void main(String[] args) {
        Button1 b1 = new Button1();
    }
}
