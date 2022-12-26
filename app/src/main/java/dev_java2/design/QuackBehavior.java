package dev_java2.design;
// 단독으로 인스턴스화 불가 구현체 클래스가 있어야함

// QuackBehavior qb= new MuteQuack();
// QuackBehavior qb= new Squeak();
// QuackBehavior qb= new Quack();

public interface QuackBehavior {
    // 메소드 선언 시 추상 클래스와는 다르게 abstract 예약어 생략 가능
    // 왜냐하면 인터페이스는 추상만 가능함
    public abstract void quack();
}
