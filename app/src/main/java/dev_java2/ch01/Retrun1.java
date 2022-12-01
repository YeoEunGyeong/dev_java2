package dev_java2.ch01;

public class Retrun1 {
  void m() {
  }

  int m1() {
    return 2;
  }

  double m2() {
    return 3.3;
  }

  boolean isView() {
    return false;
  }

  boolean isView1() {
    boolean bool = true;
    return bool;
  }

  String getName() {
    String name = "winter";
    return name;
  }

  public static void main(String[] args) {
    Retrun1 r1 = new Retrun1();
    // int x = r1.m();
    int y = r1.m1();
    // System.out.println(r1.m());
    System.out.println(r1.m1());
  }
}