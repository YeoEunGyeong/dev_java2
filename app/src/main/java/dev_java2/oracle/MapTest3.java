package dev_java2.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 회원정보
public class MapTest3 { // 모든 class는 Object를 상속
    // Object는 toString를 가지고 있기 때문에 주소값을 출력할 때 직접 코드를 넣지 않아도 toString으로 출력해 줌
    public static void main(String[] args) {
        // List<Map<>> 밖에 있는 List는 대괄호로 표시 ; [{}]
        List<Map<String, Object>> list = new ArrayList<>();
        // mem_id, mem_name, mem_pw, mem_gender
        // a123, 타자치는 감자, 321, 여자
        // b456, 집중아빈, 654, 여자
        // c789, 핵불주먹, 987, 여자
        Map<String, Object> rmap = new HashMap<>();
        rmap.put("mem_id", "a123");
        rmap.put("mem_name", "타자치는 감자");
        rmap.put("mem_pw", "321");
        rmap.put("mem_id", "여자");
        list.add(rmap);

        rmap.put("mem_id", "b456");
        rmap.put("mem_name", "집중아빈");
        rmap.put("mem_pw", "654");
        rmap.put("mem_id", "다빈형");
        list.add(rmap);

        rmap.put("mem_id", "c789");
        rmap.put("mem_name", "핵불주먹");
        rmap.put("mem_pw", "987");
        rmap.put("mem_id", "없어요아니없다니까요");
        list.add(rmap);
    }
}
