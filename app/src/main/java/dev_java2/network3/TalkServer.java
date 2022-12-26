package dev_java2.network3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//선언과 생성을 분리하는 코딩 전개
//자바는 단일상속만 가능함
//자바는 단일상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리가능함(구현체클래스)
// 상속 받거나 implements하면 부모 클래스나 인터페이스가 정의하고 있는 메소드를 
// 재정의 할 수 있음(Overriding ; 선언부 완전히 일치) 
// 인터페이스는 오로지 추상 메소드만 갖음 ; Runnable도 인터페이스이기에 추상 메소드 가짐
// Runnable - run 메소드(추상 메소드)
public class TalkServer extends JFrame implements Runnable, ActionListener {
    // 선언부
    // 클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
    TalkServerThread tst = null;
    // 동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도 느림
    List<TalkServerThread> globalList = null;
    ServerSocket server = null;
    Socket socket = null;
    JTextArea jta_log = new JTextArea(10, 30);
    JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton jbtn_log = new JButton("로그 저장");

    // 생성자
    public TalkServer() {
        // initDisplay();//시점문제- 스케쥴링
    }

    // 화면그리기
    public void initDisplay() {
        jbtn_log.addActionListener(this);
        this.add("North", jbtn_log);
        this.add("Center", jsp_log);
        this.setSize(500, 400);
        this.setVisible(true);
    }

    // 스레드가 두 개이므로 화면 요청과 start() 순서를 바꾸더라도 각자 처리가 되기 때문에 화면 호출 가능
    public static void main(String[] args) { // 메인 스레드 ; entry point
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        // 내 안에 run 메소드가 재정의(오버라이드)됨
        Thread th = new Thread(ts); // 스레드 생성 시 파라미터로 TalkServer 객체 넘김
        // 스레드 풀(Pool ;스레드가 모여 있는 곳)에 있는 스레드 중에서 우선 순위 따져 차례대로 입장
        th.start();// 52번 호출됨 - 지연발생함 - 클라이언트가 접속할때까지 기다림...
    }

    // 서버소켓과 클라이언트 소켓을 연결
    @Override
    public void run() { // 선언부와 일치해야 함 (Overrideing)
        // 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
        // Vector는 멀티 스레드 안전 ; 서버에 동시 접속자 수가 여러명이여도 Okay
        // 그래서 벡터 안에는 클라이언트를 관리하는 스레드 추가해야 함
        // 그 스레드는 메시지를 듣고 들은 내용을 그대로 클라이언트측에 내보냄
        // 200#토마토#오늘스터디? ; StringTokenizer st = new StringTokenizer("", "#");
        // st.nextToken(): ; String 200 담김
        // st.nextToken(): ; String 토마토 // nickName
        // st.nextToken(): ; String 오늘스터디? // message
        globalList = new Vector<>();// 멀티스레드안전해서 ArrayList대신 사용함
        boolean isStop = false;
        // try - catch ; 네트워크는 항상 장애 발생 가능성 ;; 예외 처리
        // try - catch 사이에는 예외가 발생할 가능성이 있는 코드 작성
        // 콜백 함수 ?? 시스템에서 필요할 때 대신 호출해 주는 메소드
        // run() 언제 호출 ?? ; 스레드 인스턴스 변수. start(); 요청 시 호출
        // 왜 이렇게 처리 ?? 여러 스레드가 존재하고 경합이 벌어지기 때문에 우선 순위를 따짐
        // 어떻게 호출 ??
        // 왜 반드시 run메소드를 재정의해야 함 ??
        try {
            server = new ServerSocket(3000);// 서버포트번호 설정하기
            jta_log.append("Server Ready.........\n");// 대기 탐 - 멈춤 - wait
            while (!isStop) { // 언제 while문 안으로 진입 ?? ; new Socket(ip서버의 port);
                socket = server.accept();
                jta_log.append("client info:" + socket + "\n");
                jta_log.append("client info:" + socket.getInetAddress() + "\n");
                TalkServerThread tst = new TalkServerThread(this);
                tst.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//////////////////////// [[ end of run ]] /////////////////////////

    @Override
    public void actionPerformed(ActionEvent e) {
        // 로그를 파일로 저장하기

    }
}

/*
 * 채팅 서버 구축
 * 클라이언트측에서 접속하면 접속해온 정보를 서버측 화면에서 볼 수 있음 (JFrame을 상속 ; 로그 남김)
 * 자바는 단일 상속만 가능 ; 이런 단점을 인터페이스로 지원 >> 다중 인터페이스 구현체는 가능함
 * 
 * 스레드 구현 방법
 * 1 Thread 상속
 * 2 Runnable 인터페이스를 implements
 * 3 현재 TalkServer는 JFrame을 상속받고 있어서 Runnable을 implements함
 */