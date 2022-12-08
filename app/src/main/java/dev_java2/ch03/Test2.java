package dev_java2.ch03;

public class Test2 {
  public static void main(String[] args) {
    for (int i = 1; i <= 20; i++) {
      switch (i % 5) {
        case 0:
          System.out.println("5의 배수입니다");
          break;
        default:
          System.out.println("5의 배수가 아닙니다");
          break;

      }
    }

  }
}
