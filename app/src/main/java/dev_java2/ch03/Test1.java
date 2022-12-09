package dev_java2.ch03;

import java.util.Scanner;

public class Test1 {
    // 선언부

    // 메서드 선언
    public void count() {
        System.out.println("count 호출"); // 로그에 출력할 값
        Scanner sc = new Scanner(System.in);
        boolean isOk = false;
        while (!isOk) {
            System.out.print("문자열을 입력해 주세요 : ");
            String str = sc.nextLine();
            if ("exit".equals(str)) { // string을 비교하고 싶기 때문에 ""을 사용하여 문자와 비교
                break; // 무한 루트 방지 // while문 탈출
            } else {
                System.out.println(str.length() + "글자입니다"); // () 붙어있기 때문에 동사형, 문자열의 길이 반환
            }
        } // end of while
        sc.close();
        System.out.println("프로그램을 종료합니다");
    } // end of count

    // 메인 메소드

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.count();
    }
}
