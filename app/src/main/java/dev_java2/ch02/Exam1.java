package dev_java2.ch02;

public class Exam1 {
  int i;
  int hap;

  // 디폴트 생성자 ; 디폴트 생성자는 파라미터를 결정해 줄 필요 없음
  // 생략하면 JVM이 대신 생성해 주어 전변들을 초기화
  public Exam1() {
    System.out.println("디폴트 생성자 호출 성공" + i + ", " + hap); // i = 0, hap = 0
  }

  public Exam1(int i, int hap) {
    System.out.println("파라미터가 두 개인 생성자 호출 성공" + i + ", " + hap); // i = 1, hap = 0
    this.i = i;
    this.hap = hap;
  }

  public static void main(String[] args) {
    Exam1 e1 = new Exam1(); // 8번 생성자 호츨 ; 메소드 오버로딩 메카니즘
    Exam1 e2 = new Exam1(1, 0);
  }
}
