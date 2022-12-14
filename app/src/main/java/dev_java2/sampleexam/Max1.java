package dev_java2.sampleexam;

import java.util.Scanner;

public class Max1 {
    int max;

    int methodA(int i1, int i2) {
        max = Math.max(i1, i2);
        return 0;
    }

    public static void main(String[] args) {
        Max1 m1 = new Max1();
        Scanner s = new Scanner(System.in);
        System.out.println("첫 번째 입력 숫자");
        String user1 = s.nextLine();
        System.out.println("입력한 첫 번째 숫자는 : " + user1);
        System.out.println("두 번째 입력 숫자");
        String user2 = s.nextLine();
        int i1 = Integer.parseInt(user1);
        int i2 = Integer.parseInt(user2);
        m1.methodA(i1, i2);
        System.out.println("입력한 숫자 중 더 큰 숫자는 : " + m1.max + "임~~~!!");

    }
}