package dev_java2.ch05;

import java.util.Vector;

public class Mother {
    public static void main(String[] args) {
        Vector<Mother> v = new Vector<>();
        Mother m1 = new Mother();
        v.add(0, m1);
        Mother m2 = new Mother();
        v.add(1, m2);
        Mother m3 = new Mother();
        v.add(2, m3);

        for (Mother m : v) {
            System.out.println(m);
        }
        for (int i = 0; i < v.size(); i++) {
            Mother m = v.get(i);
            System.out.println(m.toString());
        }
    }
}
