package dev_java2.ch03;

import java.util.Scanner;

public class Test1 {

  public void count() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("문자열을 입력해 주세요 : ");
      String str = sc.nextLine();
      if (str == "exit") {
        break;
      } else {
        System.out.println(str.length() + "글자입니다");
      }
    }
  }

  public static void main(String[] args) {

  }
}
