package dev_java2.ch02;

public class ForExam1 {
  public static void main(String[] args) {
    // int i = 0; 배열식에서 사용
    for (int i = 1; i <= 3; i++) { // int i 생략 가능 ; 생략 시 5열 선언 필요
      // for문 안에서 선언된 변수는 for문 안에서만 사용
      System.out.println(i);
    } // end of for
    int i = 0;
    while (i <= 3) {
      System.out.println(i); // 증감식이 없을 시 무한루트에 빠짐
      // while문 사용 시 조건식에 사용된 변수의 증감식이 있는지 반드시 확인
      i++;
    }
  }

}
