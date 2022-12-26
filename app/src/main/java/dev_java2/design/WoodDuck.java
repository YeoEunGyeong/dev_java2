package dev_java2.design;

public class WoodDuck extends Duck {
    public WoodDuck() {
        // 생성자에서 설계한 객체가 어떤 특성을 가지고 어떻게 활동하는지 결정
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("나는 나무오리");
    }
}
