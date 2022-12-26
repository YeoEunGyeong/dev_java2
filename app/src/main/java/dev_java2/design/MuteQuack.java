package dev_java2.design;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("무음");
    }

}
