package dev_java2.ch06;

class Sup {
    Sup() { // 부모 디폴트 생성자 생성
    }

    public void m() {
        System.out.println("Sup m() 호출");
    }
}

class Sub extends Sup {
    Sub() { // 자식 디폴트 생성자 생성
        super.m(); // <- 디폴트 생성자를 생성하여 호출했을 시 두 번 호출되는데 인스턴스화가 두 번 이루어짐(23, 27열) ; 그렇기 때문에 2번 출력
        // this.m(); 여기서 this == Sub this로 호출 시 Sub m()호출 메시지 출력
    }

    @Override
    public void m() {
        System.out.println("Sub m() 호출");
    }
}

public class SupNSubMain {
    public static void main(String[] args) {
        Sup sup = new Sup();
        // sup.m();
        Sub sub = new Sub();
        // sub.m();
        // 선언부(Sup) = 생성부(Sub)
        // 부모의 메소드는 shadow 메소드(은닉)
        Sup sup2 = new Sub();
        // sup2.m(); // 생성부 메소드로 재정의됨

        // sub = (Sub)sup; // 강제형전환 == sub = new Sub();
        // 강제형전환을 통해 문법적인 문제는 해결되지만 실제로 가리키는 객체는 상위 객체이기 때문에 에러 발생
        sub = (Sub) sup2;
        // sup2의 재정의를 Sub로 하였기 때문에 강제형전환은 필요하나 실제 가리키는 객체가 Sub이기 때문에 문제 Xxx

        sub.m();
    }
}
