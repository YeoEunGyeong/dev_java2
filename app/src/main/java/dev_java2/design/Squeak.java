package dev_java2.design;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        // 무음, 삑, 꽥인지는 언제, 누가, 어디에서 결정 가능 ??
        // 언제? 해당 기능이 요청될 때
        // 누가? 구현하고자 하는 객체가 무엇인가에 따라
        // Duck myDuck = new WoodDuck();
        // Duck myDuck = new RubberDuck();
        // Duck myDuck = new MallardDuck();
        System.out.println("삑");
    }

}
