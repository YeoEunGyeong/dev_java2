package dev_java2.ch02;
// 갯수가 다르거나, 
public class Exam1_1 {
  int i;
  int hap;

  // 디폴트 생성자 ; 디폴트 생성자는 파라미터를 결정해 줄 필요 없음 
  // 생략하면 JVM이 대신 생성해 주어 전변들을 초기화
  public Exam1_1() {
    System.out.println("디폴트 생성자 호출 성공" + i + ", " + hap); // i = 0, hap = 0
  }

  public Exam1_1(int i, int hap) { // 디폴트 생성자와 달리 스스로 초기화를 할 수 없음
    // 개발자가 설정값을 생성
    this.i = i;
    this.hap = hap;
    System.out.println("파라미터가 두 개인 생성자 호출 성공" + this.i + ", " + this.hap); // i = 1, hap = 0
  }

  public static void main(String[] args) {
    Exam1_1 e1 = new Exam1_1(); // 8번 생성자 호츨 ; 메소드 오버로딩 메카니즘
    Exam1_1 e2 = new Exam1_1(1, 0);
  }
}
