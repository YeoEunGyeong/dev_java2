package dev_java2.ch01;

// java.lang 폴더에 없는 클래스는 모두 import문을 작성
import javax.swing.JFrame;

public class LoginView {
  public static void main(String[] args) {
    // 윈도우 운영체제 안에서 창을 만들어서 띄울 때 사용하는 클래스
    JFrame jf_login = new JFrame();
    // insert here
    int width = 300; // 로그인 창의 가로 길이를 담은 변수 선언
    int height = 200; // 세로 길이를 담은 변수 선언
    jf_login.setTitle("로그인 화면 Ver1.0"); // 내가 만든 창의 타이틀바에 문자열 생성
    jf_login.setSize(width, height); // 가로와 세로 크기를 정해 주는 메소드
    Retrun1 r1 = new Retrun1();
    jf_login.setVisible(r1.isView1()); // 내가 만든 창을 화면에 활성화 또는 비활성화
  }
}
