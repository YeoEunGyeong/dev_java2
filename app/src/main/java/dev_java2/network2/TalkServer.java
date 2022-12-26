package dev_java2.network2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// 자바는 단일 상속만 가능
// 자바는 단일 상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리 가능(구현체 클래스)
// 선언과 생성 분리하여 전개
public class TalkServer extends JFrame implements Runnable, ActionListener {
    // 선언
    // 클라이언트측에서 new Socket 하면 그 소켓 정보를 받아 스레드로 넘김
    TalkServerThread tst = null;
    // 동시에 여러명이 접속하는 상황 List - Vector<>(); // 멀티 스레드 안전, 속도 느림
    List<TalkServerThread> globalList = null;
    ServerSocket server = null;
    Socket socket = null;
    JTextArea jta_log = new JTextArea(10, 30);
    JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton jbtn_log = new JButton("로그저장");

    // 생성
    public TalkServer() {
        // initDisplay(); << 시점 문제 발생함
    }

    // 화면
    public void initDisplay() {
        jbtn_log.addActionListener(this);
        this.add("North", jbtn_log);
        this.add("Center", jsp_log);
        this.setSize(500, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // 스레드를 출발시키면 지연이 발생하기 때문에 화면 먼저 실행
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        Thread th = new Thread(ts);
        th.start(); // 54열 run() 호출 ; 지연 발생 // 클라이언트가 접속할 때까지 기다림
    }

    // 서버 소켓과 클라이언트 소켓 연결 진행
    @Override
    public void run() {
        // 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
        globalList = new Vector<>(); // 멀티 스레드 안전해서 ArrayList 대신 사용
        boolean isStop = false;
        try {
            server = new ServerSocket(3401); // 서버 포트 번호
            jta_log.append("Server Ready...\n"); // 오히려 좋아! 가만히 있어!
            while (!isStop) {
                socket = server.accept();
                jta_log.append("client info:" + socket + "\n");
                jta_log.append("client info:" + socket.getInetAddress() + "\n");
                TalkServerThread tst = new TalkServerThread(this);
                tst.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end run

    @Override
    public void actionPerformed(ActionEvent e) {
        // 로그를 파일로 저장

    }
}
