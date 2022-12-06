package dev_java2.ch02;

import java.util.Scanner;

public class NansuExam1 {
  // 채번한 값을 다른 클래스에서 재사용한다면 전역(글로벌, 멤버)변수로 결정
  int com[] = new int[3];
  int my[] = new int[3]; // 사용자가 선택한 숫자
  // 3자리 숫자를 맞출 때
  // 사용자가 입력한 숫자가 컴퓨터가 입력한 숫자 중에 같은 숫자가 존재하면 ball
  // 존재하는 동안에
  // 난수로 3자리의 서로 다른 숫자로 된 값을 배열

  public void ranCom() {
    com[0] = (int) (Math.random() * 10); // 비교 대상이 없기 때문에 while문 필요 없음
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]); //
    // insert here
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }
  // 20221206 과제
  // 초기화 = 전변 / 지변 ? ; 지변 
  // 자리가 같다는 것을 배열의 index 활용
  public String accop(String user_input){
    // insert here
    Scanner scanner = new Scanner(System.in);
    return "1스 2볼";
  }

  public static void main(String[] args) {
    NansuExam1 nansuExam1 = new NansuExam1();
    for (int i = 0; i < 10; i++) { // 반복문 10번의 기회
      nansuExam1.ranCom();
      System.out.println(nansuExam1.com[0] + ""
          + nansuExam1.com[1] + "" + nansuExam1.com[2]);
    }
  }
}
