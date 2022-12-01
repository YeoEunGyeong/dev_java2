package dev_java2.ch01;

// static은 변수, 메소드 앞에 올 수 있음
// static이 있으면 정적 변수, 정적 메소드
// 인스턴스화 없이 어디서나 호출 가능
// non_static을 호출하려면 인스턴스화 필요
public class StaticExam1 {
  int i; // 전역 변수는 초기화 생략 가능, 디폴트값 0
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