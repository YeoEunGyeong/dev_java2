package dev_java2.ch02;

import java.util.Scanner;

public class HapExam221205_2_2 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int user_end = s.nextInt();
    int tot = 0;
    int cnt = 1; //
    for (; cnt <= user_end; cnt = cnt + 1) { // for문 안에서 초기화 생략 가능, 11열에 초기화식 필요
      if (cnt % 2 == 1) {
        tot = tot + cnt;
      }
    }
    System.out.println("tot :" + tot + ", cnt :" + cnt);
    s.close();
    System.out.println("===========");

    while (cnt <= user_end) {
      if (cnt % 2 == 1) {
        tot = cnt + 1;
      }
    }
    System.out.println("tot :" + tot + ", cnt :" + cnt);
    s.close();
  }
}
