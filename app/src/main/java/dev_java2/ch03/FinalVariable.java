package dev_java2.ch03;

public class FinalVariable {
  static void methodA() {
    final double PIE = 3.14; // 변수 선언 시 타입 앞에 final을 붙이면 값의 변경이 불가
    // PIE = 5.13; << 오류
    System.out.println(PIE);
  }

  public static void main(String[] args) {
    FinalVariable.methodA();
  }
}