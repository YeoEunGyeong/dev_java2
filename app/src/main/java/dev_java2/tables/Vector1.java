package dev_java2.tables;

import java.util.Vector;

public class Vector1 {
    public static void main(String[] args) {
        Vector v = new Vector();
        Vector<String> v2 = new Vector<>(); // <> ; 다이아몬드 연산자, 안에는 타입
        v2.add("잠와"); // v2.get(0)
        v2.add("2"); // v2.get(1)
        Vector<Integer> v3 = new Vector<>();
        Vector<DeptVO> v4 = new Vector<>(); // 3배열 안 씀!!
        v.add("잠와"); // v.get(0)
        v.add(1); // v.get(1)

        System.out.println(v.size()); // 2
        System.out.println(v.get(0)); //
        System.out.println(v.get(1)); //

        String insa = (String) v.get(0); // 강제 형전환, 에러가 발생하진 않지만 권장하지는 않음
        System.out.println(insa);
        String insa2 = v2.get(1);
        System.out.println(insa2);

        if (v.get(1) instanceof Integer) {
            System.out.println("너 정수");
        } else if (v.get(2) instanceof String) {
            System.out.println("너 실수");
        }
    }
}
