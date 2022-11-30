package dev_java2.ch01;

public class StaticExam2 {
  int i;
  static int j;

  public static void main(String[] args) {
    StaticExam1 staticExam1 = new StaticExam1();
    StaticExam1 staticExam2 = new StaticExam1();
    StaticExam1 staticExam3 = new StaticExam1();
    staticExam1.methodA();
    staticExam2.i = 5;
    staticExam3.i = 3;
    System.out.println(staticExam1.i); // 1
    System.out.println(staticExam2.i); // 5
    System.out.println(staticExam3.i); // 3

  }
}