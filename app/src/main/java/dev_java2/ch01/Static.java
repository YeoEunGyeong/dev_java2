package dev_java2.ch01;

public class Static {
  static {
    System.out.println("Static 호출");
  }

  // main 스레드
  // main은 entry point
  // main 개발자가 호출하는 메소드가 아님, 시스템이 자동으로 호출 < 콜백 메소드
  // main 메소드에 코딩하는 것 좋지 않음
  // main 메소드에 작성한 코드는 재사용성이 없음
  // 클래스 안에 메인 main 메소드 없어도 됨 ; 실행은 불가
  public static void main(String[] args) { // 메인보다 static 우선 순위가 높다
    System.out.println("Main 호출");
  }
}
