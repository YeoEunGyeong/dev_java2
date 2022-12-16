package dev_java2.array;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonArray1_copy implements ActionListener {
    // 선언부
    //////////// AccountSample action = new AccountSample(this);
    JFrame jf = new JFrame(); // setSize(400, 300); << 가로세로크기 지정 // setVisible(true); << 윈도우 창 활성화
    JPanel jp_center = new JPanel();
    JTextArea jta_display = new JTextArea(10, 20);
    JScrollPane jsp_display = new JScrollPane(jta_display);
    JTextField jtf_input = new JTextField();
    JPanel jp_east = new JPanel();
    // 원본과 다르게 배열로 생성
    JButton jbtns[] = new JButton[4];
    String jbtns_label[] = { "새게임", "정답", "지우기", "종료" };

    // 생성자
    public ButtonArray1_copy() {
        System.out.println("디폴트 생성자 호출");
        // 이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스를 매핑
        jtf_input.addActionListener(this);
        initDisplay();
    }

    // 화면
    public void initDisplay() {
        System.out.println("화면 호출");
        // 윈도우창 오른쪽 상단 끝에 x버튼 누르면 종료 후 가상머신과 연결 끊기
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp_center.setLayout(new BorderLayout());
        jp_center.add("Center", jsp_display);
        jp_center.add("South", jtf_input);
        jp_east.setLayout(new GridLayout(4, 1, 2, 2)); // 버튼 레이아웃을 설정
        for (int i = 0; i < jbtns.length; i++) {
            jbtns[i] = new JButton(jbtns_label[i]);
            jbtns[i].addActionListener(this);
            jp_east.add(jbtns[i]);
        }
        // jbtns[0].setBackground(new Color(0, 0, 0)); // 버튼 배경 색상
        // jbtns[0].setForeground(new Color(0, 0, 0)); // 버튼 글씨 색상
        // jbtns[1].setBackground(new Color(0, 0, 0));
        // jbtns[1].setForeground(new Color(0, 0, 0));
        // jbtns[2].setBackground(new Color(0, 0, 0));
        // jbtns[2].setForeground(new Color(0, 0, 0));
        // jbtns[3].setBackground(new Color(0, 0, 0));
        // jbtns[3].setForeground(new Color(0, 0, 0));
        jp_center.setBackground(Color.LIGHT_GRAY); // 배경 색상 설정
        // jp_center.setForeground(null); // 글짜 색상 설정
        jf.add("Center", jp_center);
        jf.add("East", jp_east);
        jf.setSize(400, 300);
        jf.setVisible(true);
    }

    
    // 메인 메소드
    public static void main(String[] args) {
        new ButtonArray1_copy();
    }

    @Override // << 콜백 메소드
    public void actionPerformed(ActionEvent e) {
        // e.getSource는 이벤트가 감지되는 컴포넌트(JTextField)의 주소 번지 반환
        Object obj = e.getSource();
        // 새게임 할 거야?
        if (jbtns[0] == obj) { // 주소 번지를 비교하기 때문에 == 사용
            jta_display.append("♪♪새게임을 시작♪♪\n");
        }
        // 정답 볼래?
        else if (jbtns[1] == obj) {
            jta_display.append("정답은 ~\n");
        }
        // 화면 지워줘
        else if (jbtns[2] == obj) {
            jta_display.setText("");
        }
        // 그만할래
        else if (jbtns[3] == obj) {
            // jf.dispose(); 창을 하나씩 따로 닫고 싶을 때 사용
            System.exit(0); // 모든 창을 한 번에 바로 닫음
        }
        // JTextField에서 엔터친 거야?
        else if (jtf_input == obj) {
            // 사용자가 텍스트 필드에 입력한 문자열을 읽어옴
            String input = jtf_input.getText();
            // jta_display.append(input + "\n");
            /////////////// action.account2();
            jtf_input.setText(""); // 문자 입력 후 입력창 비우기
        }
    }
}