package dev_java2.ch04;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI implements ActionListener {
    // 선언부 ; 이른 인스턴스화를 하는 위치
    // 전변의 scope
    JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this); // 인터페이스는 반드시 구현체 클래스가 필요
    // 선언부와 생성부의 타입이 다름 ; 다향성이 가능 >> 폴리모피즘 ; 재사용성 높이고 결합도 낮춤
    // 인터페이스는 단독으로 인스턴스화를 할 수 없음
    // ActionListerner al = new ActionListerner ; 사용할 수 없는 코드
    JFrame jf = new JFrame();
    JTextArea jta = new JTextArea(10, 20);
    JTextField jtf = new JTextField(10);

    public JTextAreaUI() { // 디폴트 생성자 선언
        // 디폴트 생성자는 생략 가능 ; JVM이 대신 해 줌
        // 생성자도 메소드처럼 호출 가능 ;; 인스턴스화 할 때
        // return이 없음
        initDisplay();
    }

    public void initDisplay() { // 메소드
        // 화면 처리부 ; Event 필요
        // 이벤트 소스와 이벤트 핸들러 클래스 매핑하기(매칭)
        jtf.addActionListener(this); // this = 이벤트 핸들러 클래스 주소 번지가 필요
        // 멀티라인 작성 가능한 콤포넌트 배경색 설정
        jta.setBackground(Color.cyan);
        // JFrame은 디폴트 레이아웃이 BorderLayout 이라서 동서남북 중앙 배치 가능
        jf.add("Center", jta); // JTextArea 중앙 배치
        jf.add("South", jtf); // 남쪽에 JTextFiled 배치
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우창 x버튼 클릭 시 자원회수
        jf.setSize(400, 300); // 윈도우창 가로 세로 크기 설정
        jf.setVisible(true); // 화면을 출력
    }

    public static void main(String[] args) { // 가장 먼저 호출 ; entry point
        new JTextAreaUI(); // 생성자 호출되고 그 안에서 화면 그리는 메소드 호출
    }

    // annotation ; 문법 제약을 갖음, 선언부가 일치해야 함
    @Override
    public void actionPerformed(ActionEvent e) { // actionPerformed ; 콜백 메소드 << ActionListener에 선언만 되어있음 (); 추상 메소드
        // 추상 메소드에서는 (); 선언만 되어있는데 세미클론으로 끝남
        // 추상 메소드의 파라미터를 통해서 감지된 컴포넌트의 주소 번지를 얻어오는
        // getSource 메소드의 소유주
        Object obj = e.getSource();
        if (jtf == obj) { // JTextField에 엔터 친 거야?
            // JTextField에 입력한 문자열 받기
            String input = jtf.getText();
            jta.append("JTextAreaUI 원본 : " + input + "\n");
            jtaUILogic.account(input);
            jtf.setText("");
        }
    }
}