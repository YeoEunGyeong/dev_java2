package dev_java2.pattern;

public class HintPart1 {
  // 선언부
  // 컴퓨터가 채번한 숫자를 담을 1차 배열 선언
  int com[] = new int[3];
  // 사용자가 입력한 문자열을 쪼개서 담을 1차 배열 선언
  int my[] = new int[3];
  // 회차를 담을 변수 선언
  int cnt = 0;

  // 새 게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    // 중복된 숫자를 제거하는 목적으로 do_while 선택
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }

  // 3자리 숫자를 입력 받아서 힌트문을 작성해 주는 메소드 구현
  public String account(String user) {
    if (user.length() != 3) {
      return "세 자리 숫자만 입력"; // account 메소드 탈출
    }
    int imsi = 0; // 파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환해 담기
    int strike = 0; //
    int ball = 0;
    try { // 문제가 생겼을 때만 실행
      imsi = Integer.parseInt(user);
    } catch (NumberFormatException e) {
      return "숫자만 입력";
    }
    my[0] = imsi / 100; // 256/100 -> 2.56 ; int/int 값이기 때문에 2 정수만 남음
    my[1] = (imsi % 100) / 10; // 256%100 -> 56 56/10 -> 5.6 ; 5
    my[2] = imsi % 10; // 256%10 -> 몫 25, 나머지 6
    for (int i = 0; i < com.length; i++) { // 입력 받은 숫자가 com 배열에 존재 ?? Y = ball , N = 제외
      for (int j = 0; j < com.length; j++) { // 위에서 Y 스트라이크인지 검사 ; com배열의 i자리와 my 배열의 j 동일 ??
        // 숫자 ??
        if (com[i] == my[j]) { // 같은 숫자가 있는지만 비교하기 때문에 자리가 달라도 참
          // 볼은 확보 자리가 같은지 비교
          // 숫자와 자리도 같아??
          if (i == j) { // 42번에서 비교한 숫자의 자리가 사용자가 입력 받은 자리까지도 같아 ?? Y = 스 , N = 볼
            strike++;
          } else {
            ball++;
          }
        } // 입력 받은 숫자가 컴퓨터가 채번한 숫자와 일치하는 경우
      } // end of inner for
    } // end of outter for
    // strike 변수값이 3이면 55번 실행될 기회 없음
    if (strike == 3)
      return "정답";
    return strike + "스" + ball + "볼";
  } // end of account

  public static void main(String[] args) {

  }
}
