package dev_java2.ch05;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class List2 {
    public static void main(String[] args) {
        // 자료 구조를 지원하는 클래스들은 오브젝트의 존재 유무 체크
        // 포함 여부, 비어있는지 혹은 채워져있는지 확인할 수 있는 api 제공
        List<String> fruitList = new Vector<>();
        fruitList.add("딸기");
        fruitList.add("포도");
        boolean isExist = fruitList.contains("감자");
        isExist = fruitList.contains("딸기");
        if (isExist) {
            System.out.println("있음!!");
        } else {
            System.out.println("없음!!!");
        }
        boolean isEmpty = fruitList.isEmpty();
        System.out.println(isEmpty);

        // Vector, ArrayList는 오브젝트 추가, 꺼내기 기능 제공
        // Iterator는 그 안에 오브젝트 존재 유무
        Iterator<String> iter = fruitList.iterator();
        while (iter.hasNext()) {
            String fname = iter.next();
            System.out.println(fname);
        }
        Iterator iter2 = fruitList.iterator();
        while (iter2.hasNext()) {
            // 다이아몬드연산자에 의미 ; 타입을 명시적으로 작성
            String fname = (String) iter2.next(); // 제네릭 타입을 지정하지 않아서 에러, 강제형변환을 통해 사용 가능하지만 권장 Xxxx
            System.out.println(fname);
        }
        // Iterator<Object> iter3 = fruitList.iterator();
        // <Object> 사용 불가 ; Vector의 제네릭 타입은 String이기 때문
        Iterator<String> iter4 = fruitList.iterator();
    }
}
