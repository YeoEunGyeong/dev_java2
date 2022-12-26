package dev_java2.design;
// 추상 클래스

// 단독으로 인스턴스화 불가 반드시, 구현체 클래스가 있어야만 함 ; 메소드 오버라이딩
// 인터페이스가 추상 클래스보다 더 추상적 추상 클래스) 생성자, 일반 메소드를 가지고 있기 때문
// 생성자는 전변의 디폴트값을 결정 가능

public abstract class Duck {
    FlyBehavior flyBehavior; // 인터페이스 (날다 / 날지 못한다)
    QuackBehavior quackBehavior; // 인터페이스 (무음;MuteQuack / 삑;Squeak / 꽥;Quack)

    public Duck() {
    } // 생성자

    public abstract void display();

    public void performFly() {
        // FlyWithWings.java, FlyNoWay.java
        flyBehavior.fly(); // 추상 메소드 ; Override 필요, 구현체 클래스 필요
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swimming() {
        System.out.println("모든 오리는 물위에 뜬다");
    }
}
