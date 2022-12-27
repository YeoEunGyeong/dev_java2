package dev_java2.network3;

import javax.swing.JFrame;

public class KiwiServer extends JFrame implements Runnable {
    // 선언

    // 생성
    public KiwiServer() {
        System.out.println("KiwiServer 디폴트 생성자 호출");
    }

    public void initDisplay() {
        this.setTitle("KIWITALK");
        this.setSize(500, 600);
        this.setVisible(true);
    }

    // 메인
    public static void main(String[] args) {
        KiwiServer ks = new KiwiServer();
        ks.initDisplay();
        Thread th = new Thread(ks);
        th.start();
    }

    @Override
    public void run() {
        System.out.println("run 호출저");
        // 경합이 벌어지는 일
        // 지연(대기) 필요한 일
        // 일반 메소드로 처리할 때와 다른 점
        // 1 늦게라도 실행(보장) ; 일반 메소드는 어플리케이션이 종료되면 보장 XXXX
        // 2 개별적으로 동작 가능
    }
}
