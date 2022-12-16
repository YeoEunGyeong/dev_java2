package dev_java2.tables;

import java.util.Vector;

public class Vector5 {
    public static void main(String[] args) {
        String fruits[] = { "키위", "포도", "사과", "토마토", "메론", "파인애플", "바나나", "복숭아" };
        // 판매 상품
        String myf[] = { "키위", "포도", "사과" };
        // 사려고 하는 상품 ; Vecotor에 담아줘

        Vector<String> v = new Vector<>();

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < myf.length; j++) {
                if (fruits[i].equals(myf[j])) {
                    v.add(fruits[i]);
                }
            }
        } // end of for
        for (String f : v) {
            System.out.print("과일~~~!! : ");
            System.out.println(f + " ");
        }
    }
}
