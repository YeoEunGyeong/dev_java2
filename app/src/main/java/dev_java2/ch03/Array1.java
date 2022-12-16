package dev_java2.ch03;

public class Array1 {

  public static void main(String[] args) { // 상속 ; 확장, 재사용(오버라이딩 경우), 재정의하여 사용
    // 선언과 생성을 나누어 할 수 있음
    // 이른 주입, 게으른 주입 ?
    // 게으른 인스턴스화는 선언과 생성을 분리
    // 이른 인스턴스화는 선언부에 선언과 생성을 한 문장에 작성
    int i[];
    // int j[] = new int[3];
    i = new int[3];
    // 초기화가 되지 않은 상태
    // 객체 배열 null, null, null
    System.out.println(i[0]);
    try {
      // 문법에는 Exception 과 상관 없음 ; 런타임 에러
      // 예외가 발생할 가능성이 있는 코드를 감싸는 명령문
      System.out.println(i[3]); // i[x] << 작성하면 문법 에러

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("인덱스가 범위를 넘음");
    }
    System.out.println("!!");
  }
}
