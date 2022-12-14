package dev_java2.sampleexam;

import java.util.Scanner;

class S1 {
    static int i; // 0, 전변 ; 글로벌하게 사용 가능, 인스턴스화 없이 사용 가능, 복제본 만들지 않을 때

    static void m() {
    }
}

class S2 {
    void n() {
        S1.i = 500;
    }
}

public class StaticTest {
    int r1 = 10;
    int r2 = 20;
    double area = 0.0;
    // s.nextLine(); 의 반환값은 String

    public static void main(String[] args) {
        // insert here
        S1.i = 10;
        S1 s1 = new S1();
        s1.i = 100;
        S2 s2 = new S2();
        s2.n(); // 메소드 이름 뒤에 세미콜론이면 메소드 호출
        System.out.println(S1.i);
        System.out.println("n() 메소드 호출 후 : " + S1.i);

        Scanner s = new Scanner(System.in);
        String user1 = s.nextLine(); // string을 int 값으로 변경해서 값 출력
        String user2 = s.nextLine();
    }
}