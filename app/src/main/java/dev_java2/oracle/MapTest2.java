package dev_java2.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> rMap = new HashMap<>();
    // Map은 기능 구현을 할 수 없는 인터페이스이기 때문에 HashMap으로 인스턴스화하여 기능 구현 가능하게 해 줌
    // 예를 들어, Map은 요구사항 정의서(User1의 걷기, 뛰기, 멈추기와 기능 요구) 그 기능을 직접 구현할 수 있게 해 주는 것이 HashMap
    //           ; user마다 다르게 요구사항 정의할 수 있음

    public void setMap() {
        rMap.put("deptno", 1250);
        rMap.put("dname", "배고파");
        rMap.put("loc", "역삼");
        list.add(rMap); // list.get(0)
        // 새로운 객체 생성하기 전에 List에 첫 번째로 생성한 rMap에 저장되어 있는 3가지 값을 넣어주는 작업
        rMap = new HashMap<>(); 
        rMap.put("deptno", 1350);
        rMap.put("dname", "자고파");
        rMap.put("loc", "강남");
        list.add(rMap); // list.get(1)
        rMap = new HashMap<>();
        rMap.put("deptno", 1450);
        rMap.put("dname", "집가고파");
        rMap.put("loc", "삼성");
        list.add(rMap); // list.get(2)
    }

    public void mapPrint() {
        // 각 로우 안에 key값이 세 개씩 존재(컬럼 ; deptno, dname, loc)
        // Map m1 = get(0) / m2 = get(1) / m3 = get(2)
        // for문에서 반복할 것은 List(ArrayList)
        for (int i = 0; i < list.size(); i++) { // 로우(get(0), get(1), get(2))값 반복
            Map<String, Object> m1 = list.get(i);
            Object[] keys = m1.keySet().toArray();
            for (int j = 0; j < keys.length; j++) { // 컬럼(deptno, dname, loc)값 반복
                String key = (String) keys[j];
                System.out.print(m1.get(key) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MapTest2 mt1 = new MapTest2();
        mt1.setMap();
        // Map의 size는 세로 방향(컬럼의 수)
        /*
         * System.out.println(mt1.rMap.size());
         * Set<String> set = mt1.rMap.keySet();
         * Iterator<String> iter = set.iterator();
         * while (iter.hasNext()) {
         * String key = iter.next();
         * Object value = mt1.rMap.get(key);
         * System.out.println(key + " : " + value);
         * }
         */
    }
}
