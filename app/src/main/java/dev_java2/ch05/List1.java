package dev_java2.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class List1 {
    public static void main(String[] args) {
        // 아래는 생성부에 인터페이스(List)가 와서 에러 ; 구현체 클래스가 와야함
        // List<String> nameList = new List<>();

        List<String> nameList1 = new Vector<>(); // 멀티스레드 안전 ; 속도 느림, 안정성 높다
        List<String> nameList2 = new ArrayList<>(); // 싱글스레드 안전 ; 속도 빠름, 안전성은 떨어진다

        System.out.println(nameList1.size()); // 0
        boolean isOk = nameList1.add("유지민");
        System.out.println(nameList1.size()); // 1
        System.out.println(nameList1.get(0));
        System.out.println(isOk);
    }

}
