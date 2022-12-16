package dev_java2.tables;

import java.util.Scanner;
import java.util.Vector;

public class Vector6_1 {
    Vector<String[]> myd = new Vector<>();
    String dpt[][] = {
            { "10", "개발부", "서울", "02" },
            { "20", "인사부", "인천", "032" },
            { "30", "총무부", "부산", "051" }
    };

    void initVector() {
        for (int i = 0; i < dpt.length; i++) {
            myd.add(dpt[i]); // Vector에 담긴 것은 1차 배열 ; 1차 배열의 컬럼의 수는 변경될 수 있음
            //
        }
    }

    void initVectorPrint() {
        for (int i = 0; i < myd.size(); i++) {
            String[] oneRow = myd.get(i); //
            System.out.println(oneRow.toString()); // toString ; 주소값을 알고 싶을 때
            for (int j = 0; j < oneRow.length; j++) {
                System.out.print(oneRow[j] + " "); // 최종적으로 vector 안에 선언된 배열과 동일하게 호출되는지 확인
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Vector6_1 v61 = new Vector6_1();
        v61.initVector(); // 로우가 3개
        // myd.get(0) --> {"10", "개발부", "서울", "02"}
        // myd.get(1) --> {"10", "개발부", "서울", "02"}
        // myd.get(2) --> {"10", "개발부", "서울", "02"} // 21열 추가하여 호출 시 3출력
        System.out.println(v61.myd.size()); // initVector 메소드를 거치지 않았기 때문에 0
        v61.initVectorPrint();

        System.out.print("삭제하고자 하는 부서 번호 입력");
        Scanner s = new Scanner(System.in);
        int dptno = s.nextInt();
        for (int i = 0; i < v61.myd.size(); i++) {
            String[] oneRow = v61.myd.get(i);
            if (dptno == Integer.parseInt(oneRow[0])) {
                v61.myd.remove(i);
            }
        }
        // 삭제한 뒤 남은 정보 출력
        System.out.println(v61.myd);
        s.close();
    }

}
