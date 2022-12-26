package dev_java2.design;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("날지 못함");
    }
}
