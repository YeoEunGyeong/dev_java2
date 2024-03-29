package dev_java2.ch04;

public class Main_2 {
    int i = 1;
    boolean isOk[] = null;

    // 디폴트 생성자는 생략 가능
    // 그러나, 지금은 isOk 배열의 생성을 위해 getisOk()를 경유하도록 해야 함
    public Main_2() {
        System.out.println("Main_2() 디폴트 생성자 호출 성공");
        getisOk();
    }

    // 선언과 동시에 인스턴스화를 하지 않는 경우를 게으른 인스턴스화
    // 선언과 생성을 동시에 하지 않고 메소드를 통해 객체 주입을 받을 수 있음
    // 이럴 경우 메소드 안에서 if문을 통해 널체크 할 수 있어 싱글톤 패턴으로
    // 객체를 주입 받을 수 있어 현업에서 선호하는 객체 주입 방법 중 하나
    boolean[] getisOk() {
        if (isOk == null) {
            isOk = new boolean[] { true, false, true };
        }
        return isOk;
    }

    public static void main(String[] args) {
    }
}
