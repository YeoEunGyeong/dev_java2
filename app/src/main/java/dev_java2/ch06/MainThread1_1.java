package dev_java2.ch06;

/*										
 * main메소드 호출은 JVM에 의해 호출된다. 										
 * JVM은 main스레드를 생성하여 main메소드를 호출한 것이다.										
 * 따라서 프로그램을 실행할 때 main메소드가 실행되었다는 것은 main스레드가 										
 * 수행되는 것이다.										
 * 그리고 main안에서 사용자가 만든 새로운 스레드를 실행시켰다면 										
 * 두 개의 스레드(main 스레드와 사용자 스레드)가 작동하고 있다는 것을 의미한다.										
 * 										
 * 아래 결과는 예측 불허(실행할 때마다 다를 수 있다.)										
 * 										
 */

public class MainThread1_1 { // 스레드 클래스 아님, 메인 스레드는 가지고 있음
    // 18 -> 19 -> 20(main start) -> 21 ; 인스턴스화만 진행 -> 24 ; implements라서 필요(상속 시에는
    // 필요X)
    // -> 28 ; start() -> run() 즉시 실행되지는 않고 대기실에서 순서를 따짐 -> 56 -> 57 -> 58 ->

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("main start");
        Runnable r = new MyRunnableOne(); // 인터페이스 = 구현체 클래스 (Override : run - 추상 메소드) ; 다형성
        // 코드 수정 범위가 좁고 유지보수 가능
        // 수정이 많아질 수록 의존관계로 인해 다른 에러 유발
        Thread myThread = new Thread(r); // r == MyRunnableOne ; run 메소드를 가지고 있기 때문에 사용 Oooo
        // 1 스레드가 아니기 때문에 에러 2 static안에서는 this 사용 불가
        // Thread myThread = new Thread(this); // this 누구 ?? ; MainThread1_1 임! 스레드는 아님
        myThread.start(); // 디폴트 가중치 = 5
        /*
         * try {
         * // Thread 클래스가 제공 ; 스레드 구현(yield, join, sleep ~~ 차례대로 스케줄링)
         * myThread.sleep(5000); // 안정성 떨어짐(순위가 밀려날 수 있음)
         * } catch (Exception e) {
         * // TODO: handle exception
         * }
         */
        // Thread himThread = new MyRunnableTwo(); // 나 자신이 스레드일 때 start 호출하는 방법과 아닐 때의
        // 방법
        // himThread.start(); // 디폴트 가중치 = 5 ; 절대적인 값은 아님
        // 상속 or 인터페이스 처리 시 그에 따른 가중치는 없음(동등함)
        // 누구든 먼저 선점하는 스레드가 우선권을 갖음
        System.out.println("main end");
    }
}

// Thread가 되는 2가지 방법
// 1 상속
// 2 implements
// 두 방법다 run 메소드 가질 수 있음(재정의 가능) ; 그안에서 실행문을 처리하면 안전
class MyRunnableTwo extends Thread {
    @Override
    public void run() {
        System.out.println("MyRunnableTwo run 호출");
    }
}

class MyRunnableOne implements Runnable {
    @Override
    public void run() {
        System.out.println("run메소드 호출 성공");
        first();
    }

    public void first() {
        System.out.println("first메소드 호출 성공");
        second();
    }

    public void second() {
        System.out.println("second메소드 호출 성공");
        System.out.println("====================================");
    }
}

/*
 * 클래스를 상속 받으면 클래스간의 결합도가 높아짐 -> 재사용성은 떨어짐, 오작동 경험
 * 기능적인 부분의 결합도를 낮추면서 테스트 용이, 오작동 방지되는 방법
 * ; 인터페이스 중심 코딩을 전개하는 방법 - 오버라이딩 (Overriding) 중요!
 */