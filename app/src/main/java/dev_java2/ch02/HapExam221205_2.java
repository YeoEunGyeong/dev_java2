package dev_java2.ch02;

public class HapExam221205_2 { // 1부터 10까지의 2의 배수의 총 합 값 ?

  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      // 2의 배수의 값이 나오는 식 필요
      if (i % 2 == 0) { // if (i % 2 == 1) 홀수의 값 식
        sum += i;
      }
    }
    System.out.println(sum);
  }
}
