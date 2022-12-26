package dev_java2.design;

public class DuckSimulation {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        Duck yourDuck = new WoodDuck();
        yourDuck.performFly();
        yourDuck.performQuack();
    }
}
