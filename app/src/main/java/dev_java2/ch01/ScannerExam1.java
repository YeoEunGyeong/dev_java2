package dev_java2.ch01;
// 클래스의 구성요소 2가지 ; 명사 + 동사

// 함수형 프로그래밍 처리 방법, 람다식 지원, 일급 함수, 일급 객체
// 필드 + 메소드 ; 클래스 정의
// 클래스를 인스턴스화 하면 
// 클래스를 인스턴스화 하는 이유는 변수를 선언하기 위함
// 인스턴스화.메소드명();
// 인스턴스화.메소드명(int i);
// 인스턴스화.메소드명(int i, double d, ~);
// 인스턴스화.전역변수(원시형, 참조형, ~);

import java.util.Scanner; // java.lang 폴더가 아닌 다른 폴더에 있는 파일을 컴파일 하려면 import 필요

public class ScannerExam1 {
  public static void main(String[] args) {
    // 생성자, 메소드는 파라미터의 갯수 혹은 타입은 반드시 지켜져야함
    Scanner scanner = new Scanner(System.in); // 생성부의 파라미터 자리는 시스템의 입력장치정보
    System.out.println("0부터 9사이의 숫자를 입력");
    String user = scanner.nextLine();
    scanner.close();
    // wrapper
    int i_user = Integer.parseInt(user);
    // 원시형 타입은 변수와 메소드를 가질 수 없음
    // 원시형 타입은 호출 시 값이 출력되기 때문에 변수와 메소드 선언 불가
    // 원시형 변수는 직접 참조 방식이므로 값이 호출 ; 간접 참조 방식으로 사용 불가

    // 참조형 타입은 간접 참조 방식이므로 변수와 메소드 선언 가능
    // System.out.println("사용자가 입력한 숫자는" + user + "입니다");
    System.out.println(user + 1);
    System.out.println(i_user + 1);
  }
}
