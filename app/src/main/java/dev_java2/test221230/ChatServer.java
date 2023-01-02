package dev_java2.test221230;

import java.net.ServerSocket;
import java.net.Socket;
// 단일 상속만 되니까 인터페이스 지원
// 인터페이스를 통해 스레드 구현 방법

public class ChatServer implements Runnable {
    // 메인 스레드
    public static void main(String[] args) {
        System.out.println("메인 start");
        ChatServer cs = new ChatServer();
        Thread th = new Thread(cs);
        th.start();
        System.out.println("메인 end");
    }

    @Override
    public void run() {
        System.out.println("run say Ho~~~");
        int port = 3000;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            // 대기 상태 ; 시간이 가다가 ChatClient에서 new Socket("서버IP", port)
            // 대기 풀림
            System.out.println("서버 소켓 Oooo 클라이언트 소켓 접속 대기 Ooooo");
            while (true) {
                // 아래 코드가 진행되는 시점 ?? ; new Socket("192.168.10.85", 3000)
                Socket client = server.accept();
                System.out.println("클라이언트 : " + client.getInetAddress());
                // 말하기 ; ObjectOutputStream -> writeObject(); 네트워크 전송 일어남(패킷)
                // 듣기 ; ObjectInputStream -> readObject();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
