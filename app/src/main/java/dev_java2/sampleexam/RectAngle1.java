package dev_java2.sampleexam;

public class RectAngle1 {
    public static void main(String[] args) {
        int width = 15, height = 2;
        int area = 0;

        area = width * height;
        System.out.println(area);
    }
}
/*
자바에서는 같은 이름의 메소드를 선언할 수 있음
단, 두 가지 규칙 존재
1 메소드 오버 라이딩 ;; 상속 관계에 있거나 인터페이스의 구현체 클래스인 경우에만 따짐
2 메소드 오버 로딩
둘의 공통점은 메소드 이름이 같을 때만 따짐


 * 원, 삼각형, 사각형의 면적을 구하고 싶으면 ??
 * 원 3개 int 2 double 1
 * 삼각형 
ㄴ 니가 해
 */