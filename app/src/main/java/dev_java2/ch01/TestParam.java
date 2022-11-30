package dev_java2.ch01;

class Param {
  int ival;

}

public class TestParam {
  void effectParam(Param p) {
    // 1 insert here 여기에 p = new Param() 있으면 결과가 달라진다, 아니다
    // Param p = new Param();
    // p.ival();
    p = new Param(); // << 2 코드를 넣으면 실행값이 서로 달라는 이유 ?
    p.ival = 500;
    System.out.println("sub ival ===> " + p.ival); // 500
  }

  public static void main(String[] args) {
    TestParam tp = new TestParam();
    Param p = new Param();
    tp.effectParam(p);
    System.out.println("main ival ===>" + p.ival);
  }
}