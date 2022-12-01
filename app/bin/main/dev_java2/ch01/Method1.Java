package dev_java2.ch01;

public class method1{
  // 파라미터 자리에는 비워두거나 원시형, 참조형 가능
  // 파라미터 자리는 호출하는 곳에서 결정
  // 파라미터 자리에 변수는 언제 초기화가 될까? ; 메소드가 호출될 때 결정
  // 메소드 호출은 어디서? ; 메인 메소드 안에서 해야 호출 가능
  // 메소드의 파라미터 자리는 오직 선언만 가능, 초기화는 불가능
  void m(int i){ // < void m(int i = 5) 불가능 // 파라미터 자리에는 사용자가 입력한 값이 담김
    // 21열에서 5의 값을 설정하여 i = 5
    i = i + 2;
    // insert here 10이 출력될 수 있는 코드 추가
    i = i + 3;
    System.out.println(i); //7
  } // end of m

  double m1(double d){
    return 3.5;
  } // end of m1
public static void main(String[] args) {
  // Method1 클래스 안에 정의된 메소드만 호출 가능
  Method1 method1 = new Method1();
  // 자바에서는 같은 이름의 메소드를 중복 선언 할 수 있음
  // 파라미터의 갯수가 다르거나 또는 타입이 다르면 인정 << 메소드 오버로딩 
  method1.m(5); // 메소드 호출
} // end of main
}
