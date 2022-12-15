package dev_java2.tables;

import java.util.Vector;

public class Vector2 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("멋쟁이 토마토");
        v.add("앗");
        v.add(1, "벡터 랄랄라");
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}