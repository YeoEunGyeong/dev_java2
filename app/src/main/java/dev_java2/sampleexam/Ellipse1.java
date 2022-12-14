package dev_java2.sampleexam;

import java.util.Scanner;

// private > friendly > protected > public // 접근 제한자
// static ; 변수 앞, 메소드 앞, 클래스 앞 사용 가능
// final ; 변수 앞(상수), 메소드 앞(오버라이딩 불가), 클래스 앞(상속 Xxxx)
public class Ellipse1 {
    public static void main(String[] args) {
        int r1 = 0, r2 = 0; // 반지름 2개 담을 변수
        double area = 0.0;
        final double PI = 3.14;

        // new 다음에 오는 클래스 생성 ; 이때, 생성자 호출(마치 메소드처럼)
        Scanner s = new Scanner(System.in); // 인스턴스화 ; 메모리에 로딩 // 메소드, 변수 호출 가능
        System.out.print("첫 번째 반지름 입력");
        String user1 = s.nextLine();
        System.out.println("사용자가 입력한 첫 번째 반지름은 : " + user1);
        System.out.print("두 번째 반지름 입력");
        String user2 = s.nextLine();
        int i1 = Integer.parseInt(user1); // 첫 번째 반지름을 원시형 int로 저장 ; 반지름 곱셈을 위해
        int i2 = Integer.parseInt(user2);
        area = i1 * i2 * PI; // int * int * double = double~~~
        System.out.println("타원형의 면적은 ?? " + area + "임~~");

    }

}
