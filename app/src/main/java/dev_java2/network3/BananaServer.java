package dev_java2.network3;

import javax.swing.JFrame;

public class BananaServer extends JFrame {
    // 생성
    BananaServer() {
        initDisplay();
    }

    BananaServer(String title) {
        super(title);
        initDisplay(title);
        /*
         * this(title); ; 자기 자신을 호출하는 것이므로 에러 this = BananaServer
         */
    }

    public void initDisplay() {
        // this.setTitle("BANANATALK");
        this.setSize(500, 600);
        this.setVisible(true);
    }

    public void initDisplay(String title) {
        this.setSize(500, 600);
        this.setVisible(true);
    }

    // 메인
    // this는 클래스 쪼개기 즉, 화면과 로직의 분리 또는 하나의 클래스를 여러 개의 클래스로 나누어(분업)
    // 처리할 때만 필요로 함 ; this(), this("HI") 실무에서 사용할 일 Xxxx
    public static void main(String[] args) {
        // 생성자 호출
        // new BananaServer();
        // 생성자 파라미터에는 this 말고도 다른 타입을 사용 가능 ; String
        new BananaServer("생성자 파라미터로 제목을 결정(초기화)");
    }

}
/*
 * 관전 포인트
 * initDisplay를 메인 메소드에서 호출하는 것과 생성자 안에서 호출하는 것 가능
 * 그렇다면 둘의 차이점 ??
 * 작업지시서
 * Kiwi 메인 메소드에서 initDisplay 호출
 * Banana 생성자에서 initDisplay 호출
 */
