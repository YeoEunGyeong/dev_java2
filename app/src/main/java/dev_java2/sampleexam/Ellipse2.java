package dev_java2.sampleexam;

import java.util.Scanner;

// private > friendly > protected > public // 접근 제한자
// static ; 변수 앞, 메소드 앞, 클래스 앞 사용 가능
// final ; 변수 앞(상수), 메소드 앞(오버라이딩 불가), 클래스 앞(상속 Xxxx)
public class Ellipse2 {
    // 선언
    double area; // 전변은 생략 가능 ? ok 생성자가 자동으로 해 줌
    final double PI = 3.14;
    
    // 1 리턴 타입 결정 가능 ?? ; 너 메인 메소드에서 면적 출력 ? ok 메인 메소드에서 출력 double
    // 2 파라미터의 갯수와 타입까지 선택 가능 ??
    
    // 자바에서는 같은 이름 메소드를 여러 개 선언할 수 있다
    // 단, 파라미터의 갯수가 다르거나 타입이 달라야만 함 ; 메소드 오버로딩~~~!
    double 면적구해줘(){
        return 0.0;
    }
    double 면적구해줘(int i1, int i2){
        area = i1 * i2 * PI; // int * int * double = double~~~
        return 0.0;
    }

    public static void main(String[] args) { // static 안에서는 non-static 절대 안 돼~~~!
        Ellipse2 e2 = new Ellipse2();

        // new 다음에 오는 클래스 생성 ; 이때, 생성자 호출(마치 메소드처럼)
        Scanner s = new Scanner(System.in); // 인스턴스화 ; 메모리에 로딩 // 메소드, 변수 호출 가능
        System.out.print("첫 번째 반지름 입력");
        String user1 = s.nextLine();
        System.out.println("사용자가 입력한 첫 번째 반지름은 : " + user1);
        System.out.print("두 번째 반지름 입력");
        String user2 = s.nextLine();
        int i1 = Integer.parseInt(user1); // 첫 번째 반지름을 원시형 int로 저장 ; 반지름 곱셈을 위해
        int i2 = Integer.parseInt(user2);
        
        e2.면적구해줘(i1, i2);
        System.out.println("타원형의 면적은 ?? " + e2.area + "임~~"); 
        // 10열에서 double 앞에 static이 있으면 e2 << 아니고 Ellipse2 붙여서 사용 가능
    }
}
