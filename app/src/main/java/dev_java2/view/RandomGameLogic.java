package dev_java2.view;

import java.util.Scanner;

public class RandomGameLogic {
  int com = -1;
  
public void ranCom() {
    com = (int) (Math.random() * 10);// 10을 곱하는 이유는 구간을 늘리기 위함
  }

  public String UDcheck(int user) {
    String msg = null;
    // 정답보다 입력한 값이 작니?
    if (com > user) {
      msg = "보다 높은값을 입력";
    }
    // 정답보다 입력한 값이 크니?
    else if (com < user) {
      msg = "보다 낮은값을 입력";
    } else if (com == user) {
      msg = "정답";
      //return msg;if문에서 해당메소드를 탈출할 때 return예약어 사용가능함
      //반복문에서는 break문 사용한다.
    }
    return msg;
   //return null;
  }
    public static void main(String[] args) {
      RandomGameLogic rgl = new RandomGameLogic();
      Scanner s = new Scanner(System.in);
      int i = 1; // 회차 표시
      String 입력값 = null;
      String 반환값 = null;
      //게임 기회는 5회로 제한하시오.
      while(i <= 5){ // 기회 5회로 제한, 무한루프 방지를 위해 break; 입력 필수
        System.out.print("0부터 9사이의 숫자를 입력하세요");
        입력값 = s.nextLine();//사용자가 입력한 값 받아오기 - nextLine()반환값이 있다
        System.out.println(입력값);//null이 아닌지 확인한다
        //알면서도 잡지 못하는 Exception -> NullPointerException
        int user = Integer.parseInt(입력값);//NumberFormatException
        반환값 = rgl.UDcheck(user);
        if("정답".equals(반환값)){
          //정답을 맞추었을 경우 축하합니다. 라고 말한 뒤
          //새 게임 진행 여부를 물어보시오.
          System.out.println("축하합니다.");
          break;
        }
    }
}
}