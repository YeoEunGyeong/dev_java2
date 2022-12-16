package dev_java2.ch02;

public class HapExam221205_1 { // 1부터 10까지의 합의 값 ?

  public static void main(String[] args) {
    // 합을 담을 변수 선언
    int sum = 0; // 초기값을 0으로 잡는 이유는 답에 영향을 끼치기 때문
    for (int i = 1; i <= 10; i++) {
      sum += i; // sum = sum + i
    }
    System.out.println(sum);
  }
}
