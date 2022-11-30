package dev_java2.ch01;

public class StaticExam1 {
  int i;
  static int j;

  void methodA() {
    i = i + 1;
    j = i * 2;
    System.out.println("i는" + i);
    System.out.println("j는" + j);
  }

  public static void main(String[] args) {
    StaticExam1 staticExam1 = new StaticExam1();
    staticExam1.methodA();
  }
}