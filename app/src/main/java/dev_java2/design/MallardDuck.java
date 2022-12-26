package dev_java2.design;

public class MallardDuck extends Duck {
    public MallardDuck() {
        // 게으른 인스턴스화(ApplicationContext) <--> 이른 인스턴스화(BeanFactory) ; 스프링, 전자정부프레임워크
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("나는 청둥오리");
    }
}
