package dev_java2.test2;

import java.util.Scanner;

public class Test2 {
    public void sum() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1이상의 숫자를 입력하세요");
        int num = sc.nextInt();

        int sum = 0;
        if (num > 0) {
            int i = 1;
            while (i <= num) { // ++연산자, break;
                for (i = 0; i <= num; i++) {
                    sum += i;
                }
                break;
            }
            System.out.println("1부터 " + num + "까지의 합은 : " + sum + "입니다");
        } else {
            System.out.println("숫자가 1이상이 아닙니다");
        } // else
    } // sum

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        t2.sum();
    }
}
