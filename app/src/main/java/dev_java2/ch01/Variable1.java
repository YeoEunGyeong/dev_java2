package dev_java2.ch01;

public class Variable1 { // 클래스 안에는 변수 + 메소드
  int x;

  // 파라미터가 없는 메소드
  // 반환형이 없다
  void methodA() {
    int i; // 지변
    i = 1;
    x = i;
    System.out.println("i 값은 " + i);
  }

  public static void main(String[] args) {
    // insert here // static은 non-static이 없을 시 가져올 수 없기 때문에 인스턴스화 필요
    // System.out.println(x); //인스턴스화 후에 출력해야 x값을 가지고 올 수 있음
    Variable1 variable1 = new Variable1();
    variable1.methodA(); // 선언이 사용보다 먼저
    System.out.println("x 값은" + variable1.x);
  }
}