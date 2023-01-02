package dev_java2.test221230;

import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    public void client() {
        int port = 3000;
        String serverIP = "192.168.10.85";
        // java.net / java.io 인터넷 회선 장애 문제 발생 원인
        // io 생성 시 소켓을 통해 인스턴스화 하니까 의존관계 있음
        // 이런 패키지에는 반드시 예외 처리 (Thread ; 인터셉트 당할 수 있음)
        // Object마다 lockflag값이 있어서 스레드가 점유하면 잠금 처리(다른 스레드 사용 불가)
        // 데드락 상태에 빠질 수 있음(안에서 잠금으로 다른 스레드 사용 불가하게 됨)
        // 한정된 자원을 여러 사람이 이용하기 위해 제공되는 클래스가 Thread
        // Thread.sleep() / join / yield / intercept etc...
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            Socket socket = new Socket(serverIP, port);
        } catch (Exception e) {
            // 에러 메시지에 대한 history 기억하고 라인 번호와 함께 이력 출력해 줌
            // 디버깅 시 필수!!
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient cc = new ChatClient();
        cc.client();
    }
}