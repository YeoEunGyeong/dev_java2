package dev_java2.ch02;

import java.util.Random;
import java.util.Scanner;

public class Nansu1 {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner s = new Scanner(System.in);
    int com = r.nextInt(10); // 0.0~10.0
    System.out.println("채번한 숫자는 ==>"+ com);
    int my = -1;
    while(true){
      System.out.println("0부터 9사이의 정수를 입력");
      my = s.nextInt();
      System.out.println("사용자가 입력한 값"+ my);
      if(com == my){ // 정답인 경우
        System.out.println("축하합니다");
        s.close();
        break;
      }
      else if(com > my){ // 채번한 숫자(ex;8)가 사용자가 입력한 값(ex;4)보다 큰 경우?
      System.out.println("높여라");
      }
      else if(com < my){
      System.out.println("낮춰라");
      }
      else if(my == 10){ // 10 입력 시 빠져나감
        s.close();
        System.exit(0);
      }
    }
  }
}
