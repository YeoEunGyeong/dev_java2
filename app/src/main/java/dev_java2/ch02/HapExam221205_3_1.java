package dev_java2.ch02;

public class HapExam221205_3_1 { // 1에서 100까지 5의 배수 "fizz",
  // 7의 배수 "buzz"
  // 35의 배수 "fizzbuzz"
  // 나머지 값은 숫자로 출력

  public static void main(String[] args) {
    for (int i = 1; i < 101; i++) {
      if (i % 35 == 0)
        System.out.println("fizzbuzz");
      else if (i % 5 == 0)
        System.out.println("fizz");
      else if (i % 7 == 0)
        System.out.println("buzz");
      else
        System.out.println(i);
    }
  }
}
