package dev_java2.ch01;

// 두 개의 클래스(Param, TestParam) 가지고 있으나 둘 다 public을 가질 수 없다
class Param {
  int ival; // static이 없는 non-static 전역 변수 ; 전역 변수는 초기화를 생략 가능, 생성자가 초기화 생략해 줌
}

public class TestParam {
  void effectParam(Param p) { // p 지변
    // 1 insert here 여기에 p = new Param() 있으면 결과가 달라진다, 아니다
    p = new Param(); // << 2 코드를 넣으면 실행값이 서로 달라는 이유 ?
    p.ival = 500; // p는 주소번지 ; 참조형 변수
    // p = new Param(); **11열과 13열의 위치를 바꿔주면 sub 값 0, main 값 500
    System.out.println("sub ival ===> " + p.ival); // 500
  }

  public static void main(String[] args) { // 실행은 main인 15열부터 시작
    TestParam tp = new TestParam();
    Param p = new Param();
    p.ival = 100;
    tp.effectParam(p);
    System.out.println("main ival ===>" + p.ival);
  }
}