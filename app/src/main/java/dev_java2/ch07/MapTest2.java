package dev_java2.ch07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("one", 1);
        map1.put("two", 2);
        map1.put("five", (int) 5.0);
        Map<String, Double> map2 = new HashMap<>(); // 참조형(주소 번지를 담고 있음)임으로
        map2.put("one1", new Double(1));
        map2.put("two1", new Double(2));
        map2.put("five1", 5.0);
        int i = 0; // 원시형(값을 담고 있음)이기 때문에 double안에 int가 들어가는 것은 문제가 되지 않음
        double d = i;
        Map<String, Object> map3 = new HashMap<>(); // Object는 모든 타입을 담을 수 있기 때문에 오류 Xxxx
        map3.put("one2", 1);
        map3.put("two2", 2);
        map3.put("five2", 5);
    }
}
