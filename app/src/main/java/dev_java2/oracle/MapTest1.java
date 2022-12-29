package dev_java2.oracle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {
    Map<String, Object> rMap = new HashMap<>(); // rMap.size() = 0 ; 초기화값이 없다!

    public void setMap() { // put 메소드는 입력한 순서대로 출력되지 않음
        rMap.put("deptno", 1250);
        rMap.put("dname", "배고파");
        rMap.put("loc", "역삼");
    }

    public static void main(String[] args) {
        MapTest1 mt1 = new MapTest1();
        mt1.setMap(); // key 3개(김기범, 김기범, 김기범)
        System.out.println(mt1.rMap.size()); // 0 -> 3
        // Map에서 제공하는 메소드 중 key값을 묶음 처리하는 메소드 있음
        Set<String> set = mt1.rMap.keySet();
        // Set 인터페이스가 제공하는 메소드 중 toArray() 지원
        Object obj[] = set.toArray(); // deptno, dname, loc
        for (int i = 0; i < obj.length; i++) { // obj.length 배열의 원소 3개
            String key = (String)obj[i]; // 배열에서 꺼낸 값은 key 값
            System.out.println("key(김기범/32.9세) : " + key); // 3번 출력 ; 순서대로 출력 Xxx (11열 주석 참고)
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) { // hasNext = 자료 구조 안에 값 체크해서 있으면 t, 없으면 f
            String key = iter.next();
            // String value = (String) mt1.rMap.get(key); // deptno는 int의 값가지기 때문에 String
            // 출력 Xxxx
            Object value = mt1.rMap.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
