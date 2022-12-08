package dev_java2.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameDemo implements ActionListener {
  // 선언부
  // JFrame jf = null;
  JFrame jf = new JFrame(); // 이른 인스턴스화
  JButton jbtn_north = new JButton("북쪽"); // 생성자 파라미터는 String
  JButton jbtn_west = new JButton("서쪽");
  JButton jbtn_south = new JButton("남쪽");
  JButton jbtn_east = new JButton("동쪽");
  JButton jbtn_center = new JButton("중앙");

  // 생성자 
  public RandomGameDemo() {
    System.out.println("디폴트 생성자 호출 성공");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    System.out.println("initDisplay 호출");
    jbtn_south.addActionListener(this);
    jbtn_north.addActionListener(this);
    jbtn_west.addActionListener(this);
    jbtn_east.addActionListener(this);
    jbtn_center.addActionListener(this);
    jf.add("North", jbtn_north);
    jf.add("South", jbtn_south);
    jf.add("West", jbtn_west);
    jf.add("East", jbtn_east);
    jf.add("Center", jbtn_center);
    jf.setSize(250, 300);
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
    new RandomGameDemo();
    // new RandomGameDemo(); // 복제본 생성 ; 서로 다른 객체
    // new RandomGameDemo(); // 복제본2 생성
    // 타입은 동일 그러나, 다른 객체 ?
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 눌린 버튼의 문자열 읽어옴
    System.out.println(e.getActionCommand()); //
    // 눌린 버튼의 주소 번지를 가져옴
    System.out.println(e.getSource()); // @abcd1234
    String label = e.getActionCommand(); // 11-15열에 선언한 동, 서, 남, 북, 중앙
    if ("중앙".equals(label)) { // if-if 매번 조건 검사, if-else if
      System.out.println("중앙 버튼 클릭");
    } else if ("서쪽".equals(label)) {
      System.out.println("서쪽 버튼 클릭");
    } else if ("남쪽".equals(label)) {
      System.out.println("남쪽 버튼 클릭");
    } else if ("동쪽".equals(label)) {
      System.out.println("동쪽 버튼 클릭");
    } else if ("북쪽".equals(label)) {
      System.out.println("북쪽 버튼 클릭");
    }
  }
}