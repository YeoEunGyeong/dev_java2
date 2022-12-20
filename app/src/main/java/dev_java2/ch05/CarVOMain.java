package dev_java2.ch05;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 직관적
class CarVO {
    private int speed;
    private String carColor;
    private int wheelNum;

    CarVO() {
    }

    CarVO(int speed) { // new CarVO(30); 호출 시 값 ??
        this.speed = speed;
    }

    CarVO(int speed, String carColor) { // new CarVO(50, "검정"); 호출 시 값 ??
        this.speed = speed;
        this.carColor = carColor;
    }

    CarVO(int speed, String carColor, int wheelNum) { // new CarVO(100, "파랑", 4); 호출 시 값 ??
        this.speed = speed;
        this.carColor = carColor;
        this.wheelNum = wheelNum;
    }

    @Override
    public String toString() {
        return "내 자동차는 !!! " + carColor + "이고, 바퀴 수는 !!!! " + wheelNum
                + "이며, 속도는 !!! " + speed + "임~~!";
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCarColor() {
        return this.carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getWheelNum() {
        return this.wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }

}

public class CarVOMain {
    public static void main(String[] args) {
        CarVO cVo1 = new CarVO();
        CarVO cVo2 = new CarVO(50, "검정"); // ~("검정", 50) 순서를 다르게 설정하면 에러
        CarVO cVo3 = new CarVO(100, "파랑", 4);
        CarVOMain carVOMain = new CarVOMain();
        System.out.println(carVOMain);
        System.out.println(cVo1); // 오버라이딩이 되어있기 때문에 주소 번지가 아니라 선언한 문자열이 호출
        System.out.println(cVo2);
        System.out.println(cVo3);
    }
}
