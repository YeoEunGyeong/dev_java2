package dev_java2.ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
// List - java.util.List(Interface) ; ArrayList, Vector
// 

public class MyB {
    void m(List<String> myNames) { // List가 상속할 수 있는 타입을 더 많이 가짐
        System.out.println("=======List<String>========");
        for (String s : myNames) {
            System.out.println(s);
        }
    }

    void m2(Vector<String> myNames) {
        System.out.println("=======Vector<String>========");
        for (String s : myNames) {
            System.out.println(s);
        }
    }

    // JVM에서 제공하는 List에 대해서 구현체 클래스가 여러가지 존재
    // 선언부와 생성부의 타입이 서로 다르게 구현하는 것을 권장
    //
    public static void main(String[] args) {
        MyB myB = new MyB();
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("태연");
        nicknames.add("민정");
        nicknames.add("지민");
        Vector<String> nicknames2 = new Vector<>();
        nicknames2.add("르세라핌");
        nicknames2.add("에스파");
        nicknames2.add("뉴진스");
        List<String> nicknames3 = new Vector<>();
        nicknames2.add("소녀시대");
        nicknames2.add("원더걸스");
        nicknames2.add("포미닛");
        myB.m(nicknames);
        // myB.m2(nicknames);
        myB.m(nicknames2);
        myB.m2(nicknames2);
        myB.m(nicknames3); // myB.m2(nicknames3); <- List보다 구체적인 타입이기 때문에 m2 실행 XXX

    }
}
