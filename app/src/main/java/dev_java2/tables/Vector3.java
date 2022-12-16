package dev_java2.tables;

import java.util.Vector;

public class Vector3 {
    public static void main(String[] args) {
        // 객체는 생성되었으나 방은 만들어지지 않았음
        Vector<Integer> v = new Vector<>();

        System.out.println(v.size()); // 0 ; 방이 만들어지지 않았기 때문에 0값
        // 방이 비었어 ??
        System.out.println(v.isEmpty()); // t

        boolean isExist = v.add(1);

        System.out.println(v.get(0)); // 1 ; 0번의 방의 값 가져와

        System.out.println(isExist); // t

        System.out.println(v.isEmpty()); // f ; 값이 입력되었기 때문

        System.out.println(v.contains(1)); // t ; 문자열에 포함되어 있는지 확인

        v.add(1, 2); // 1번 방에 2를 넣어

        System.out.println(v.contains(2)); // f -> t

        System.out.println(v.remove(1)); // 1번 방의 값 지워

        boolean isOk = v.remove(new Integer(1)); // t ;

        System.out.println(v.size()); // 1
    }
}
