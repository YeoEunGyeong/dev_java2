package dev_java2.ch05;

import java.util.Arrays;

public class ArrayCopy11 {
    public static void main(String[] args) {
        ArrayCopy1 aCopy1 = new ArrayCopy1();
        System.out.println(Arrays.toString(aCopy1.fruit)); // 깊은 복사 ; 원본은 그대로 살아있고 개별적으로 달라지는 것
        System.out.println(Arrays.toString(aCopy1.fruit2));

        aCopy1.fruit2 = new String[] { "파인애플", "키위" }; // 복사가 아니라 새로운 객체 생성
        System.out.println(aCopy1.fruit2[1]);
    }
}
