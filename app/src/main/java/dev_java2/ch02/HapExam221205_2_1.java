package dev_java2.ch02;

import java.util.Scanner;

public class HapExam221205_2_1 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int user_end = s.nextInt();
    int sum = 0;
    for (int i = 1; i <= user_end; i++) {
      if (i % 2 == 1) {
        sum += i;
      }
    }
    System.out.println(sum);
    s.close();
    System.out.println("===========");

    int i = 1;
    while (i <= user_end) {
      if (i % 2 == 1) {
        sum = i + 1;
      }
    }
    System.out.println(sum);
  }
}
