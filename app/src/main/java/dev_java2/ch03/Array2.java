package dev_java2.ch03;
// 배열의 장애
// 같은 타입만 담을 수 있음
// 중간에 끼워넣기 불가
// 원소의 갯수 고정 ; 변경 불가

import java.util.Arrays;

public class Array2 {
  // 이른 인스턴스화
  int i[] = new int[3];
  int j[] = new int[]{1, 2, 3};
  int x[] = {1, 2, 3};

  // 변수 - 원시 배열 - 객체 배열 - 자료 구조(List, Map) - 쿠키와 세션

  public static void main(String[] args) {
    Array2 a2 = new Array2();
    System.out.println(a2.x.toString()); // 한 객체를 모두 표기 원할 시 사용하는 명령문
    System.out.println(Arrays.toString(a2.i)); 
    System.out.println(Arrays.toString(a2.j));
    System.out.println(Arrays.toString(a2.x));
    for(int a = 0; a < a2.j.length; a++){
      System.out.println(a2.j[a]);

    }
    for(int y : a2.x){
      System.out.println(y);

    }
  } // end of main
}
