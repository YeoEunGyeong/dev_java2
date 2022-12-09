package dev_java2.ch03;
// 중간고사 채점 결과표

// 학생별 총점, 평균, 석차를 구하는 프로그램 작성

import java.util.PrimitiveIterator.OfLong;

public class TwoArrayExam1 {
    String[] subject = { "JAVA", "ORACLE", "SPRING" };
    String[][] date = {
            { "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" }
    };

    int totalsum = 0;
    double average = 0.0;

    void javaHap() {
        int javaHap = 0;
        for (int i = 0; i < date.length; i++) {
            javaHap += Integer.parseInt(date[i][1]);
        }
        System.out.println("자바의 총점 : " + javaHap);
    }

    void OracleHap() {
        int Oraclehap = 0;
        for (int i = 0; i < date.length; i++) {
            Oraclehap += Integer.parseInt(date[i][2]);
        }
        System.out.println("오라클의 총점 : " + Oraclehap);
    }

    void SpringHap() {
        int Springhap = 0;
        for (int i = 0; i < date.length; i++) {
            Springhap += Integer.parseInt(date[i][3]);
        }
        System.out.println("스프링의 총점 : " + Springhap);
    }

    public static void main(String[] args) {
        TwoArrayExam1 tae = new TwoArrayExam1();
        tae.javaHap();
        tae.OracleHap();
        tae.SpringHap();
    }
}
