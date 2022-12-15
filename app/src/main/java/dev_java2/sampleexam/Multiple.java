package dev_java2.sampleexam;

import java.util.Scanner;

public class Multiple {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("입력값 : ");
        int user1 = s.nextInt(); 
        System.out.print("입력값 : ");
        int user2 = s.nextInt();

        if (user1 < user2) {
            for (int i = user1; i < user2; i++) {
                if (i % 3 == 0)
                    System.out.println(i + " : 3의 배수!!");
            }
        } else {
            for (int i = user2; i < user1; i++) {
                if (i % 3 == 0)
                    System.out.println(i + " : 3의 배수!!");
            }

        }
    }
}