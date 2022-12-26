package dev_java2.design;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("날수 있음");
    }
}
