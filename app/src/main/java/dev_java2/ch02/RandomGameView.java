package dev_java2.ch02;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class RandomGameView {
  // 선언부
  JPanel jp_east = new JPanel();
  JButton jbtn_new = new JButton("새게임");
  JButton jbtn_dap = new JButton("정답");
  JButton jbtn_clear = new JButton("지우기");
  JButton jbtn_exit = new JButton("종료");
  // 생성자 ; 파라미터가 없는 생성자를 디폴트 생성자라 칭함, 생략 가능
  RandomGameView(){ // 그러나 화면을 그리는 메소드를 호출하기 위해 선언함
    initDisplay(); // 내 안에 있는 메소드이므로 인스턴스화 없이도 호출 가능
  }
  // 화면 그리기 구현
  public void initDisplay(){
    jp_east.setLayout(new GridLayout(4,1));
    jp_east.add(jbtn_new);
    jp_east.add(jbtn_dap);
    jp_east.add(jbtn_clear);
    jp_east.add(jbtn_exit);
    jf_game.add("East",jp_east);
    jf_game.setSize(450, 400);
    jf_game.setVisible(true);
  }
  // 메인 메소드
  
  
  public static void main(String[] args) {
    // 생성자 호출 ; 디폴트 생성자 호출
    new RandomGameView();    
  }
}
