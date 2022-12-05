package dev_java2.ch02;

public class OperatorExam1 {

  public static void main(String[] args) {

    int i = 1;
    switch (i) { // 실행문 만족 시 switch문을 빠져나갈 수 있도록 break를 걸어 빠져나가야 함
      case 0:// 실행문 ; i가 1의 값을 가지고 있기 때문에 0인 경우 실행될 기회가 없음
        ++i;
        break;
      case 1: // 실행문
        ++i;
        break;
      default: // 만족하는 조건 값이 없을 경우 default 수행, defalt 뒤는 break 생략 가능
        ++i;
    } // end of switch
    System.out.println(i);
  }
}