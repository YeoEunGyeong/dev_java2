package dev_java2.ch02;

import java.util.Random;
import java.util.Scanner;

public class Nansu1 {

  public static void main(String[] args) {
    // 랜덤하게 채번하는 메소드를 제공하는 클래스 선언 및 생성
    Random r = new Random(); // new 다음에 오는 이름의 객체가 로딩 ; 생성자 호출도 가능
    // 참조형의 선언문은 생성자를 호출하지 않음 ,초기화를 하지 않은 선언은 생성자를 호출하지 않음
    // 생성자 이름 = new 이름()
    // Scanner 클래스를 사용하면 입력 장치로 입력된 정보를 받아올 수 있음 - 듣기
    // 생성자의 파라미터에 입력 장치에 대한 코드가 필요 ;; System.in
    // System ; 내가 사용하는 컴퓨터 장치
    // 뒤에 변수 in을 붙이면 입력 장치를 나타냄
    Scanner s = new Scanner(System.in);
    // nextInt 메소드는 Scanner 클래스가 소유주
    int com = r.nextInt(10); // 0~10
    System.out.println("채번한 숫자는 ==>"+ com);
    int my = -1;
    // 회차를 카운트하는 변수 선언
    // 어느 시점에서 카운트를 증가할 것인가 ? ; 힌트를 줄 때 증가
    int cnt = 1;
    boolean isOk = true; // 변수를 설정하여 아래로 값을 넘겼기 때문에 빠져나오는 코드를 설정 가능 
    while(isOk){ // while(true) << true를 주었기 때문에 무한루프에 빠지는 코드
      // 사용자에게 입력받아야 하는 유요한 값의 범위를 출력
      System.out.println("0부터 9사이의 정수를 입력");
      // Scanner 클래스가 소유한 nextInt 메소드 호출
      // nextInt()의 반환형은 int
      my = s.nextInt();
      if(cnt == 5){
        System.out.println("5번 기회를 모두 사용");
        System.exit(0); // 파라미터에 0을 주면 자바가상머신과 연결 끊어짐 ; 종료 << 할당 스레드 반환
      }
      System.out.println("사용자가 입력한 값"+ my);
      // 컴퓨터가 채번한 값과 사용자(my)가 입력한 값이 같은가?
      if(com == my){ // 정답인 경우 ; 변수가 가리키는 값이 같은지 비교 << 원시형 변수 ; 직접 접근 방식
        System.out.println("축하합니다");
        System.out.println(cnt);
        s.close(); // 사용한 Scanner의 주소 번지는 반드시 닫아줌 ; 위변조의 위험
        break;
      }
      else if(com > my){ // 채번한 숫자(ex;8)가 사용자가 입력한 값(ex;4)보다 큰 경우?
      System.out.println("높여라");
      System.out.println(cnt++);
      }
      else if(com < my){
      System.out.println("낮춰라");
      System.out.println(cnt++);
      }
      else if(my == 10){ // 10 입력 시 빠져나감
        s.close();
        System.exit(0);
      }
    }
  }
}
