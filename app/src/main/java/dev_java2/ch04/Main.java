package dev_java2.ch04;

public class Main {
    int i = 1;
    boolean isOk[] = new boolean[3];

    public static void main(String[] args) {
        Sub sub = new Sub(); // 지변의 성격을 가짐, 디폴트 생성자
        System.out.println(sub.j); // 전역 변수만이 인스턴스 변수.변수명으로 호출 가능
        sub.methodSub();
    }
}
