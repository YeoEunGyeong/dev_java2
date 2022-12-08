package dev_java2.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameView implements ActionListener {
  // 선언부
  // JFrame jf = null;
  JFrame jf = new JFrame(); // 이른 인스턴스화
  JTextField jtf_input = new JTextField(5); // 생성자 파라미터는 int
  // 남쪽에 붙임
  JTextArea jta_display = new JTextArea(10, 20); // 생성자 파라미터는 int 2개
  JScrollPane jsp_display = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  // 중앙에 붙임

  // 생성자
  public RandomGameView() {
    System.out.println("디폴트 생성자 호출 성공");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    System.out.println("initDisplay 호출");
    jtf_input.requestFocus();
    jtf_input.addActionListener(this);
    jta_display.setEditable(false); // 주석 처리 시 커서로 선택 가능
    jf.add("South", jtf_input);
    jf.add("Center", jsp_display);
    jf.setSize(300, 350);
    jf.setVisible(true);

  }
  // UI API를 활용하여 공부
  // 1 초기화를 활용 가능
  // 2 생성자 역할에 대해 알게 됨
  // 3 사용자 정의 메소드를 많이 만들어 볼 수 있음
  // 4 파라미터와 리턴 타입에 대해 확실
  // 5 전역 변수와 지역 변수를 구분하여 코딩을 전개 가능
  // 6 클래스를 나누는 조건을 갖게 됨
  // 7 이벤트 처리를 사전학습 할 수 있음
  // 8 익명 클래스를 활용 가능 ; 익명 함수, arrow function 등 신문법을 공부하는데 도움

  // 메인 메소드
  public static void main(String[] args) {
    // 선언부 없이 생성자만 호출 가능 ; 인스턴스변수를 재사용할 일이 없다면 괜찮아
    new RandomGameView();
    // new RandomGameView(); // 복제본 생성 ; 서로 다른 객체
    // new RandomGameView(); // 복제본2 생성
    // 타입은 동일 그러나, 다른 객체 ?
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 엔터의 주소 번지를 가져옴
    // System.out.println(e.getSource()); //@abcd1234
    Object obj = e.getSource();
    if (jtf_input == obj) { // if-if 매번 조건 검사, if-else if
      System.out.println("사용자가 입력한 값은" + jtf_input.getText());
      jta_display.append(jtf_input.getText() + "\n");
      jtf_input.setText(""); // 지우기는 더블퀘테이션으로 대체
    }
  }
}