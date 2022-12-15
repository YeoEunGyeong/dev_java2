package dev_java2.tables;

import java.util.Arrays;

public class ArrayCopy1 {
    void deepCopy2() {
        int[] org = { 1, 2, 3, 4, 5 };
        int[] org_copy = Arrays.copyOf(org, 2);
        org_copy[1] = 5;
        for (int e : org) {
            System.out.println(e);
        }
        for (int e : org_copy) {
            System.out.println(e);
        }
    }

    void deepCopy() {
        int[] org = { 1, 2, 3 };
        int[] org_copy = org.clone();
        org_copy[2] = 5;
        for (int e : org) {
            System.out.println(e);
        }
        for (int e : org_copy) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ArrayCopy1 ac1 = new ArrayCopy1();
        ac1.deepCopy2();
    }
}
/*
 * int[] org = {1, 2, 3};
 * int[] org_copy = org;
 * org_copy[2] = 5; // 본사된 배열의 값을 바꿨기 때문에 원본과 같이 바뀜
 * for(int e : org){
 * System.out.println(e);
 * }
 * for(int e : org_copy){
 * System.out.println(e);
 * }
 * }
 * }
 * 
 * /*
 * 배열 복사
 * ; 얕은 복사
 * 복사된 배열이나 원본 배열이 변경이 될 때 서로간의 값이 같이 복사
 * 객체의 주소값만 복사
 * 
 * ; 깊은 복사
 * 복사된 배열만 변경되고 원본 배열은 그대로 유지하는 복사
 * 객체의 실제값을 새로운 객체로 복사 ; 즉 배열이 2개가 만들어지는 것
 */