package dev_java2.ch03;

import java.util.Arrays;

public class Array3 {
  public static void main(String[] args) {
    int i[] = { 1, 2, 3 };
    int j[];
    j = i; // 주소 번지가 동일하게 설정
    System.out.println(j[1]);
    int k[];
    k = new int[2]; // 생성까지만 되고 초기화 값이 없기 때문에 호출 시 0
    // insert here
    j = k; // 에러가 발생하지 않도록 10열 코드 작성
    System.out.println(Arrays.toString(j));
    System.out.println(j.length);
    // .length 명사형 ; 배열의 길이
    // 뒤에 ()있으면 동사형 ; 문자의 길이

    String s1 = "안녕";
    String s2 = s1;
  }

}
