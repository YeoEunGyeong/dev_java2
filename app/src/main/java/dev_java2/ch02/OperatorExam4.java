package dev_java2.ch02;

public class OperatorExam4 {

  public static void main(String[] args) { // main thread
    int i = 1;
    int j = 2;
    // if((i == --j) & (++i <= j)){}
    if ((i == --j) || (++i <= j)) { // (i = 1, j = 1) || () ; 참
      // || 조건값이 하나라도 참인 경우 참으로 처리하기 때문에 앞의 계산값이 참이기 때문에 앞의 계산값으로 출력
      System.out.println("조건을 만족할 경우");

    } else {
      System.out.println("조건을 만족하지 않았을 경우");
    }
    // insert here ; i와 j 값?
    System.out.println("i =" + i + ",j = " + j);
  }
}
// & < 참, 참 = 참 참, 거짓 = 거짓 거짓, 참 = 거짓, 거짓, 거짓 = 거짓