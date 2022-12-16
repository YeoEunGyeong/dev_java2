package dev_java2.sampleexam;

import java.util.Scanner;

public class ArrayAvg {
    public static void main(String[] args) {
        int[] num = new int[5];
        int sum = 0, avg = 0;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < num.length; i++) {
            System.out.print("숫자 입력!!!! : ");
            num[i] = s.nextInt();
        }
        // for (int i = 0; i < num.length; i++) {
        // System.out.println("숫자는!!!! : " + num[i]); // 배열에 숫자 입력됐는지 확인하는 출력문

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        avg = sum / (num.length);
        System.out.println("총 합은!!! :" + sum);
        System.out.println("평균은!!!! : " + avg);
        s.close();
    }
}
