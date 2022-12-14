package dev_java2.sampleexam;

class RectAngle3{
    // 배열을 사용했을 시 어느 방에 가로, 세로길이가 있는지 알 수 없음
    // 결과값도 마찬가지
    void area(int params[]){
        params[2] = params[0] * params[1];
        System.out.println(params[2]);
    }
}
public class RectAngle3Main {
    public static void main(String[] args) {
        RectAngle3 r3 = new RectAngle3();
        int params[] = {6,7,0};
        r3.area(params);
    }
}
