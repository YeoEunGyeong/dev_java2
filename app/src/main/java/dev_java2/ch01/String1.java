package dev_java2.ch01;

public class String1 {
  // string을 초기화 하는 방법 두 가지 검색
  public static void main(String[] args) {
    String s1 = "안녕";
    String s2 = "안녕";
    String s3 = new String("안녕");
    String s4 = new String("안녕");
    // insert here
    // **1 s1과 s2의 주소 번지는 동일? 참 혹은 거짓 선택
    // string 클래스는 new를 사용하지 않고 객체를 생성하면 이미 같은 값이 존재할 때 기존에 값을 참조
    // ;; 참조형 변수는 new를 사용하므로 무조건 새로운 객체 생성

    // **2 s3와 s4의 주소 번지는 동일?
    // **3 s3가 가르키는 문자열이 s4와 같은 지 비교하는 방법 // 구글링

    // 주소 번지가 가르키는 값을 비교하려면 equals 메소드 검색
    // 주소 번지를 비교할 수 있는 것은 참조형 타입인 경우만 가능
    // 원시형 변수는 주소번지를 비교 불가

    System.out.println(s1 == s2); // **1
    System.out.println(s3 == s4); // **2
    System.out.println(s3.equals(s4)); // **3

  }
}
