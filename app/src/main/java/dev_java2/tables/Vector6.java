package dev_java2.tables;

import java.util.Vector;

public class Vector6 {
    public static void main(String[] args) {
        String dpt[][] = {
                { "10", "개발부", "서울", "02" },
                { "20", "인사부", "인천", "032" },
                { "30", "총무부", "부산", "051" }
        };

        Vector<String[]> myd = new Vector<>();
        for (int i = 0; i < dpt.length; i++) {
            myd.add(dpt[i]);
        }

        for (int i = 0; i < myd.size(); i++) { // 로우가 3번 반복
            String[] oneRow = myd.get(i);
            for (int j = 0; j < oneRow.length; j++) { // 컬럼 수만큼 반복 ; 4개씩 선언되어 있으니까 4번
                System.out.println(oneRow[j] + " ");
            } // end of inner
            System.out.println();
        } // end of outter
    }
}
