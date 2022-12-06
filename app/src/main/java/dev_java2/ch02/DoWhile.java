package dev_java2.ch02;

public class DoWhile {
  public static void main(String[] args) {
    int i = 1;
    // 조건을 수렴하지 않으면 단, 한 번도 실행 기회가 없음
    while(i > 3){
      System.out.println("while문 실행 출력"); // i 값이 3보다 작기 때문에 실행 X
    }
    System.out.println("!!");
    // i값을 1로 초기화한 것은 동일한 조건에서 테스트를 하기 위함
    i = 1;
    do{ // 조건을 나중에 따짐 ; 무조건 한 번은 실행
      System.out.println("do_while문 실행문 출력");
    }while(i > 3);
  }
  
}
