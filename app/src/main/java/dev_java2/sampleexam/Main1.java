package dev_java2.sampleexam;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main1 {
    JFrame jf = new JFrame();
    Sub1 sub1 = new Sub1(this); // this = main1 // 현재 생성되지 않았기 때문에 오류
    // 디폴트 생성자 안에서 화면을 그리는 initDisplay 호출
    // 이 메소드는 화면을 그리는 메소드
    // 화면이 두 개 열림 ?? ok??

    public Main1() {
        initDisplay();
    }

    public void initDisplay() {
        System.out.println("initDisplay 호출");
        jf.setTitle("Main1");
        jf.setSize(400, 450);
        jf.setVisible(true);
    }

    public void refresh() { // sub창의 입력 눌렀을 때 refresh 호출창이 호출되면 ok
        System.out.println("refresh() : 나 호출됨!!");
        JOptionPane.showMessageDialog(jf, "새로고침");
    }

    public static void main(String[] args) {
        new Main1();
        /*
         * Main1 m1 = new Main1();
         * // 그러나 호출이 불가
         * new Main1(); // 인스턴스화 -> 메모리에 상주 ; 변수나 메소드를 사용할 수 있는 상태
         * new Main1().initDisplay();
         */ // Main1 메소드를 3번 호출하기 때문에 화면 3개 출력
    }
}

/*
 * 디폴트 생성자는 생략 가능
 * 파라미터가 있는 생성자는 생략 불가
 * 파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자도 생략 불가
 * 인스턴스화 할 때 생성부의 이름으로 객체가 생성
 * 이때, 파라미터 자리에 인자를 추가할 수 있음 ; 여러 개의 생성자를 선언할 수 있음을 뜻
 * ; 메소드 오버로딩 룰
 * ; 파라미터의 갯수가 다르거나 타입이 달라야함
 */