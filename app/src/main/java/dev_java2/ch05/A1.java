package dev_java2.ch05;

import java.util.Vector;

public class A1 {
    int ival = 1;

    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.ival = 10;
        System.out.println(a1);
        Vector<A1> va1 = new Vector<>();
        va1.add(a1);
        a1 = null; // 객체 초기화하면 다음 열으로 넘어갈 때 캔디데이트 상태
        a1 = new A1();
        a1.ival = 20;
        System.out.println(a1);

        // a1이 참조하고 있는 a1의 ival을 다시 출력하고 싶을 때 어떻게 해야 함 ??
        System.out.println(va1.get(0).ival);
        System.out.println(a1.ival);
    }
}
