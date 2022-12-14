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

public class ButtonArray1 implements ActionListener {
    // 선언부
    JFrame jf = new JFrame(); // setSize(400, 300); << 가로세로크기 지정 // setVisible(true); << 윈도우 창 활성화
    JPanel jp_center = new JPanel();
    JTextArea jta_display = new JTextArea(10, 20);
    JScrollPane jsp_display = new JScrollPane(jta_display);
    JTextField jtf_input = new JTextField();
    JPanel jp_east = new JPanel();
    JButton jbtn_new = new JButton("새게임");
    JButton jbtn_dap = new JButton("정답");
    JButton jbtn_clear = new JButton("지우기");
    JButton jbtn_exit = new JButton("종료");

    // 생성자
    public ButtonArray1() {
        System.out.println("디폴트 생성자 호출");
        // 이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스를 매핑
        jtf_input.addActionListener(this);
        jbtn_new.addActionListener(this); // 버튼이 눌릴 때 이벤트를 주는 코드 작성
        jbtn_dap.addActionListener(this);
        jbtn_clear.addActionListener(this);
        jbtn_exit.addActionListener(this);
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
        // jbtn_new.setBackground(new Color(0, 0, 0)); // 버튼 배경 색상
        // jbtn_new.setForeground(new Color(0, 0, 0)); // 버튼 글씨 색상
        // jbtn_dap.setBackground(new Color(0, 0, 0));
        // jbtn_dap.setForeground(new Color(0, 0, 0));
        // jbtn_clear.setBackground(new Color(0, 0, 0));
        // jbtn_clear.setForeground(new Color(0, 0, 0));
        // jbtn_exit.setBackground(new Color(0, 0, 0));
        // jbtn_exit.setForeground(new Color(0, 0, 0));
        jp_east.setLayout(new GridLayout(4, 1, 2, 2)); // 버튼 레이아웃을 설정
        jp_east.add(jbtn_new);
        jp_east.add(jbtn_dap);
        jp_east.add(jbtn_clear);
        jp_east.add(jbtn_exit);
        jp_center.setBackground(Color.LIGHT_GRAY); // 배경 색상 설정
        // jp_center.setForeground(null);
        jf.add("Center", jp_center);
        jf.add("East", jp_east);
        jf.setSize(400, 300);
        jf.setVisible(true);
    }

    // 메인 메소드
    public static void main(String[] args) {
        new ButtonArray1();
    }

    @Override // << 콜백 메소드
    public void actionPerformed(ActionEvent e) {
        // e.getSource는 이벤트가 감지되는 컴포넌트(JTextField)의 주소 번지 반환
        Object obj = e.getSource();
        // 새게임 할 거야?
        if (jbtn_new == obj) { // 주소 번지를 비교하기 때문에 == 사용
            jta_display.append("♪♪새게임을 시작♪♪\n");
        }

        // 정답 볼래?
        else if (jbtn_dap == obj) {
            jta_display.append("정답은 ~\n");
        }

        // 화면 지워줘
        else if (jbtn_clear == obj) {
            jta_display.setText("");
        }

        // 그만할래
        else if (jbtn_exit == obj) {
            // jf.dispose(); 창을 하나씩 따로 닫고 싶을 때 사용
            System.exit(0); // 모든 창을 한 번에 바로 닫음
        }

        // JTextField에서 엔터친 거야?
        else if (jtf_input == obj) {
            // 사용자가 텍스트 필드에 입력한 문자열을 읽어옴
            String input = jtf_input.getText();
            jta_display.append(input + "\n");
            jtf_input.setText(""); // 문자 입력 후 입력창 비우기
        }
    }
}
