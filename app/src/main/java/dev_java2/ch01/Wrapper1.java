package dev_java2.ch01;

// ScannerExam << 22열 설명을 위함
public class Wrapper1 {

  public static void main(String[] args) {
    Integer i = new Integer(10);
    int j = i;
    System.out.println(i);
    System.out.println(j);

    String x = String.valueOf(j);
    // String y = j;
    String y = x;
    System.out.println(y);

    if (y instanceof String) {
      System.out.println("y는 String 타입");
    }
    if (i instanceof Integer) {
      System.out.println("i는 Integer 타입");
    }
  }
}
