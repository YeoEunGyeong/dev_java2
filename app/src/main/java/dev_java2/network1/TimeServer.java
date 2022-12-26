package dev_java2.network1;

import java.io.IOException;
import java.io.ObjectInputStream; // 듣기
import java.io.ObjectOutputStream; // 말하기
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

// 서버를 기동하고 클라이언트가 접속하기를 기다림 ; 기다리면 스레드
public class TimeServer extends Thread {
    // 선언
    // 객체 직렬화가 가능하고 듣기 쓰기 가능한 I/O 관련 클래스 선언
    ObjectOutputStream oos = null; // 소켓이 있어야만 객체 생성 가능 ; 말하기
    ObjectInputStream ois = null; // 소켓이 있어야만 객체 생성 가능 ; 듣기
    Socket client = null; // 전변의 위치
    // run 메소드 재정의 ; 스레드에서 해야 할 일 처리
    // 반드시 선언부가 일치해야 함 ; 부모가 가진 메소드
    // TimeServer is a Thread 관게가 성립하니까 상속 처리 가능
    // 생성자

    TimeServer() {
    }

    // 아래 생성자가 필요한 이유는 서버 소켓에 접속해 온 클라이언 소켓을 run 메소드 안에서 사용해야 함 ; 전변으로 치환
    TimeServer(Socket client) {
        this.client = client;
    }

    // 스레드 구현 메소드에서 서버 소켓에 접속해 온 client 소켓을 가지고
    // 말하기와 듣기에 필요한 oos, ois 객체 생성 필요
    // I/O도 지연과 데드락 상태에 빠질 수 있으므로 반드시 예외처리 필요
    @Override
    public void run() {
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            while (true) {
                oos.writeObject(getTimeMessage());
                try {
                    sleep(1000);
                } catch (InterruptedException ie) {
                }
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        // 서버소켓 생성시 파라미터로 포트번호가 필요함
        int port = 3401;
        // 동시에 여러사람이 접속을 시도함

        ServerSocket server = null;
        Socket client = null; // 여기에 들어오는 소켓은 서버소켓에 접속해온 클라이언트 소켓(주소값)
        try {
            server = new ServerSocket(port);
        } catch (IOException ie) {
            System.out.println("Cnat't bind port" + port);
            ie.printStackTrace(); // 에러메세지를 라인번호와 함께 출력
            try {
                server.close();
            } catch (Exception e) {
                System.exit(0);
            }
        } // end of try catch
        System.out.println("Timeserver started successfullt...");
        while (true) {
            try {
                // 클라이언트가 접속해오기를 기다리다가 접속(new Sorket("192.168.10.86",3401))을 해오면
                // 아래 메소드가 클라이언트 소켓정보를 취득
                client = server.accept();
                System.out.println(client.getInetAddress()); // 클라이언트의 네트쿼크 정보
                System.out.println("New Client connected...");
                // 스레드 개입이 필요 - 1초동안 sleep(1000) 호출하고 현재 시,분,초 정보를 출력함
                // 스레드를 동작시킴 - 스레드의 추상메소드 run을 호출해야 함
                // 주의 : run을 직접 호출하는게 아니라 start() 호출하면 JVM이 순서를 따져서 출발을 시켜줌
                TimeServer ts = new TimeServer(client); // client를 넘기는 이유는 run()에서 사용하고 싶어서
                ts.start(); // run() 호출됨
                System.out.println("New TimeServer Thread Started...");
            } catch (Exception e) {
            }
        }
    }

    public String getTimeMessage() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        return (hour < 10 ? "0" + hour : "" + hour) + ":" +
                (min < 10 ? "0" + min : "" + min) +
                (sec < 10 ? "0" + sec : "" + sec);
        // return "12:05:45";
    }
}
