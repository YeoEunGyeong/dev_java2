package dev_java2.basic1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExam1 {
    public static void main(String[] args) {
        // List, Map 따로 사용하는 경우보다 List<MAP<>> 더 많이 사용
        // 오라클에서 제공하는 테이블 구조에서 튜플을 구성할 때 Map 사용 가능
        // Member 테이블 기준
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> pmap = new HashMap<>();
        pmap.put("mem_id", "aaa");
        pmap.put("mem_pw", "123");
        pmap.put("mem_nick", "김태연");
        list.add(pmap); // list.get(0) 인덱스 0번 방에 주입

        pmap = new HashMap<>(); // 새 주소 번지 할당
        pmap.put("mem_id", "bbb");
        pmap.put("mem_pw", "123");
        pmap.put("mem_nick", "유지민");
        list.add(pmap); // list.get(1)

        pmap = new HashMap<>();
        pmap.put("mem_id", "ccc");
        pmap.put("mem_pw", "123");
        pmap.put("mem_nick", "김민정");
        list.add(pmap); // list.get(2)
        // Map의 키값은 DB테이블 컬럼명과 통일
        // 키값 출력 mem_id, mem_pw, mem_nick
        Object key[] = pmap.keySet().toArray();
        /*
         * for (Object s : key) {
         * System.out.println(s.toString());
         * System.out.println(pmap.get(s));
         * }
         */
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> rmap = list.get(i);
            System.out.println(rmap.get("mem_id") + ", " + rmap.get("mem_pw") + ", " + rmap.get("mem_nick"));
        }
    }
}
