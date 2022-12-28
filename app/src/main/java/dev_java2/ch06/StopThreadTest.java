package dev_java2.ch06;

class StopThread implements Runnable {
    boolean stopped = false;

    @Override
    public void run() {
        while (!stopped) { // == true
            System.out.println("Thread is alive...."); // 출력
            try {
                Thread.sleep(500); // 0.5초 후 Thread is alive 반복 출력
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // end while
          // 아래 코드는 9, 17열 구간 중 11열에 멈춰있을 때 다른 스레드가 인터셉트 가능 (다른 스레드가 있을 시)
        System.out.println("Thread is deaded");
    } // end run

    public void stop() {
        stopped = true;
    }
}

public class StopThreadTest {
    //
    public static void main(String[] args) {
        StopThreadTest stt = new StopThreadTest();
        stt.process(); // stack 영역
        System.out.println("main end"); // 애플리케이션 죽음 ; 메인 스레드 회수(JVM이)
    }

    public void process() {
        StopThread st = new StopThread(); // 지변으로 객체 생성 ; automatic 영역에서만 살다가... 살다가... 살다가... 너 지칠 때...
        Thread th = new Thread(st); // 스레드 생성()
        th.start(); // run() 호출
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        st.stop();
    }
}
