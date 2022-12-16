package dev_java2.ch02;

public class Fibonacci1 {
  void action() {
    int a1 = 1;
    int a2 = 1;
    int a3 = 0;
    System.out.print(a1 + " " + a2 + " "); // print로 출력 시 행바꿈이 아니라 옆으로 열거
    for (int i = 0; i < 8; i++) {
      a3 = a2 + a1;
      System.out.print(a3 + " ");
      a1 = a2; // 두 번째 수를 세 번째 수로 바꿈
      a2 = a3; // 현재의 수를 첫 번째 수로 바꿈
    }
  }

  public static void main(String[] args) {
    // insert here ; action 메소드 호출
    Fibonacci1 fibonacci1 = new Fibonacci1();
    fibonacci1.action();
  }
}
