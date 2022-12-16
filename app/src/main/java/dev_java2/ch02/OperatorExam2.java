package dev_java2.ch02;

public class OperatorExam2 {

  public static void main(String[] args) { // main thread
    int i = 1;
    int j = 2;
    // if((i == --j) & (++i <= j)){}
    if ((i == --j) && (++i <= j)) { // (i = 1, j = 1) && (i = 2, j =1) ; 거짓
      System.out.println("조건을 만족할 경우"); // 조건이 거짓이기 때문에 출력될 수 없음

    } else {
      System.out.println("조건을 만족하지 않았을 경우");
    }
    // insert here ; i와 j 값?
    System.out.println("i =" + i + ",j = " + j);
  }
}
// & < 참, 참 = 참 참, 거짓 = 거짓 거짓, 참 = 거짓, 거짓, 거짓 = 거짓