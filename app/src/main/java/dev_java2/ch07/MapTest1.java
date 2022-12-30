package dev_java2.ch07;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class S1 {
    int age = 27;
}

class S2 {
    String animal = "삵";
    int leg = 4;
}

class S3 { // 3개 클래스 설계
}

public class MapTest1 {
    List<Map<String, Object>> list = null;

    public static void main(String[] args) {
        S1 s1 = new S1();
        System.out.println(s1.age);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("s1", s1);
        S1 s2 = (S1) map1.get("s1");
        System.out.println(s2.age);
        Map<String, String> map11 = new HashMap<>();
        // map11.put("s1", s1);
        Map<String, Object> map2 = new Hashtable<>();
        S2 s3 = new S2();
        map2.put("s2", s3);
        S2 s4 = (S2) map2.get("s2");
        if (s4.animal instanceof String) {
            System.out.println("문자열");
            System.out.println(s4.animal);
        }
        // Deprecated ; 하위 버전을 위해 남겨둠
        if (new Integer(s4.leg) instanceof Integer) {
            System.out.println("정수형");
            System.out.println(s4.leg);
        }
    }
}
