package dev_java2.ch03;
// java 예외 처리
// finally 사용법
public class Finally1 {
  public static void main(String[] args) {
    int i = 10;
    int j = 2;
    j = 0;
    try{
      System.out.println(i/j);
    } catch (ArithmeticException e) {
    System.out.println(e.getMessage());
    } finally{
      System.out.println("finally는 무조건 실행");
    } 
  }
}
