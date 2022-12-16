package dev_java2.ch02;

public class HapExam221205_3 { // 1에서 100까지 5의 배수 "fizz",
  // 7의 배수 "buzz"
  // 35의 배수 "fizzbuzz"
  // 나머지 값은 숫자로 출력
  void methodA() {
    System.out.println("====[[methodA 호출]]=====");
    for (int i = 1; i < 101; i++) {
      switch (i % 35) {
        case 0:
          System.out.println("fizzbuzz");
          break;
        case 5:
        case 10:
        case 15:
        case 20:
        case 25:
        case 30:
          System.out.println("fizz");
          break;
        case 7:
        case 14:
        case 21:
        case 28:
          System.out.println("buzz");
          break;
        default:
          System.out.println(i);
          break;
      } // end of switch
    } // end of for
  } // end of methodA

  public static void main(String[] args) {
    HapExam221205_3 h3 = new HapExam221205_3();
    h3.methodA();
  }
}
