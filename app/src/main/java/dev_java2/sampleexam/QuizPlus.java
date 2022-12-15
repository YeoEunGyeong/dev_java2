package dev_java2.sampleexam;

import java.util.Random; // ctrl shift o

public class QuizPlus {
    int user[] = new int[10];
    int sum1, sum2;

    int[] abcd() {
        Random random = new Random();
        for (int i = 0; i < user.length; i++) {
            user[i] = random.nextInt(21) - 10; // -10에서 10사이의 정수값 설정
        }
        return user;
    }

    void efg() {
        for (int i = 0; i < user.length; i++) {
            if (user[i] > 0) {
                sum1 += user[i];
            } else {
                sum2 += user[i];
            }
        }
    }

    public static void main(String[] args) {
        QuizPlus qp = new QuizPlus();
        qp.abcd();
        for (int i = 0; i < qp.user.length; i++){
        System.out.println(qp.user[i]);}
        qp.efg();
        System.out.println("\n" + "양의 정수 합!!! : " + qp.sum1 + " ,음의 정수 합!!! : " + qp.sum2);
    }
}
