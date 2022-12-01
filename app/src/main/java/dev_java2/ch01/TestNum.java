package dev_java2.ch01;

class Num {
  int inum;
}

public class TestNum {
  void examNum(Num num) {
    num = new Num();
    num.inum = 449123;
    System.out.println("1 번호는" + num.inum); // 449123 // 10열 주석 처리 시 0
  }

  public static void main(String[] args) {
    TestNum tn = new TestNum();
    Num num = new Num();
    num.inum = 339123;
    tn.examNum(num);
    System.out.println("2 번호는" + num.inum); // 339123
  }
}