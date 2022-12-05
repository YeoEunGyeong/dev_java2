package dev_java2.ch02;

public class OperatorExam3 {

  public static void main(String[] args) { // main thread
    int i = 1;
    int j = 2;
    // if((i == --j) & (++i <= j)){}
    if ((i != --j) && (++i <= j)) { // (i = 1, j = 1) && () ; 거짓
      // &&의 경우 앞조건이 거짓인 경우 뒤의 조건 실행하지 않기 때문에 계산값을 출력하지 않음
      System.out.println("조건을 만족할 경우");

    } else {
      System.out.println("조건을 만족하지 않았을 경우");
    }
    // insert here ; i와 j 값?
    System.out.println("i =" + i + ",j = " + j); 
    }
}
// & < 참, 참 = 참 참, 거짓 = 거짓 거짓, 참 = 거짓, 거짓, 거짓 = 거짓