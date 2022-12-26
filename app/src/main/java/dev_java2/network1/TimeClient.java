package dev_java2.network1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    JLabel jlb_timer = null;

    public TimeClient() {

    }

    public TimeClient(JLabel jlb_timer) {
        this.jlb_timer = jlb_timer;
    }

    @Override
    public void run() {
        // 서버로부터 읽어온 시간 정보 담기
        String timeMsg = null;
        try {
            // 아래가 실행되자마자 TimeServer의 ServerSocket이 accept() 호출
            // 클라이언트 소켓 정보를 서버가 취득
            socket = new Socket("192.168.10.86", 3401);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            while (true) {
                try {
                    while ((timeMsg = (String) ois.readObject()) != null) {
                        System.out.println(timeMsg);
                        jlb_timer.setText(timeMsg);
                    } // inner while
                    sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } // end of outter while
        } catch (IOException ie) {
            System.out.println("타임 서버에 접속 불가");
        } finally {
            try {
                oos.close();
                ois.close();
                socket.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    public static void main(String[] args) {
        // 선언부와 생성부 이름 다를 수 있음 ; 다형성 구현이 가능
        // 자바에서는 new 다음에 오는 이름으로 객체가 생성
        Thread th = new TimeClient();
        th.start(); // run() 호출
    }
}

/*
 * TimeServer에서 제공하는 현재 시간 정보 읽어오는 클래스 구현
 * 스레드를 상속 받은 이유는 1초마다 읽어와야 하기 때문
 * sleep(1000) 호출해야 함 ; 그러기 때문에 나는 스레드여야 함
 * 1초마다 계속 읽어와야 하니까 무한 루프 돌림
 * 
 * 
 */