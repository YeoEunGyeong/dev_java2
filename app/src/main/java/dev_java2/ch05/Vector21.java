package dev_java2.ch05;

import java.util.Map;
import java.util.Vector;

public class Vector21 { // 서로 다른 타입을 담을 수 있는 장점을 가짐
    public static void main(String[] args) {
        // 2중[outter : = Vector-size(), inner : = String[]-length] for문 돌림
        // 끼워넣기 가능
        // 수정에 대한 API 제공은 없음 ; 클라우드 기반 데이터베이스 제품이 이런 식
        Vector<String[]> v = new Vector<>();
        Vector<Map<String, Object>> v3 = new Vector<>();
        String imsi[] = { "10", "개발부", "서울" };
        v.add(imsi);
        imsi = new String[] { "20", "영업부", "인천" };
        v.add(imsi);
        for (int x = 0; x < v.size(); x++) { // 로우의 수 !! outter for문 2번 돌아감
            String[] r = v.get(x);
            for (int y = 0; y < imsi.length; y++) { // 컬럼의 수 !!! inner for문 3번 돌아감
                System.out.println(r[y] + " ");
            }
            System.out.println();
        }
        //

        // 단일 for문 처리
        Vector<String[]> v2 = new Vector<>();
    }
}
