package dev_java2.ch07;

class Sup {
    void go() {
        System.out.println("go 호출");
    }

    void stop() {
        System.out.println("Suppppp stop 호출");
    }
}

class Sub extends Sup {
    Sub() {
        super.stop(); // Suppppp stop
        this.stop(); // Sub stop
    }

    @Override
    void stop() {
        System.out.println("stop 호출");
    }
}

public class SuperMain {
    public static void main(String[] args) {
        Sup sup = new Sup();
        Sub sub = new Sub();
        sup = sub;
        // 부모가 가진 stop 메서드는 은닉 메서드(shadow method)
        sup.stop();
        // this/super 예약어는 static이 있는 메서드 영역에서 사용 불가(컴파일 에러 발생!)
        // super.stop();
    }
}
