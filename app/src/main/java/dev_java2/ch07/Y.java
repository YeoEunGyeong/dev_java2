package dev_java2.ch07;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Y {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Vector<Integer> vlist = new Vector<>();
        // 인터페이스 List에는 copyInto 메서드가 정의되지 않아서 사용 불가
        // list.copyInto();
        vlist.copyInto(args);
    }
}
