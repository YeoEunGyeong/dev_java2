package dev_java2.tables;

import java.util.Vector;

// ? 뭘 원하는 거지
public class Vector7 {
    public static void main(String[] args) {
        String dpt[][] = {
                { "10", "개발부", "서울", "02" },
                { "20", "인사부", "인천", "032" },
                { "30", "총무부", "부산", "051" }
        };

        DeptVO[] dVO = new DeptVO[dpt.length];
        Vector<DeptVO> myd = new Vector<>();
        DeptVO dv = new DeptVO(10, "개발부", "서울");
        dVO[0] = dv;
        myd.add(dv);
        dv = new DeptVO(20, "인사부", "인천");
        dVO[1] = dv;
        myd.add(dv);
        dv = new DeptVO(30, "총무부", "부산");
        dVO[2] = dv;
        myd.add(dv);
    } // end of main
} // end of V7
