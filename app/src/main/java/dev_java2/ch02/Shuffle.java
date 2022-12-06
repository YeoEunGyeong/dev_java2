package dev_java2.ch02;

public class Shuffle {
  public static void main(String[] args) {
  int a = 3;
  int b = 5;
  int imsi = 0;
  imsi = a; // 3
  a = b; // 5
  b = imsi; // 3
  System.out.println("a : "+ a +", b : "+ b);
}
}
