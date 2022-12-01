package dev_java2.ch01;

// 일괄처리의 편리성
public class Variable2 {

  public static void main(String[] args) {
    System.out.println("아메리카노"); // 동일한 설정값 변경 시 출력한 값 두 번 다 변경
    System.out.println("아메리카노");

    String Coffeename = "라떼"; // 설정한 변수 초기화 값 하나만 변경하면 가능
    System.out.println(Coffeename);
    System.out.println(Coffeename);
  }
}
