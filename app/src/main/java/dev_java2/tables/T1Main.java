package dev_java2.tables;

class T1 {
    int i = 1;

}

public class T1Main {
    public static void main(String[] args) {
        T1[] t1s = new T1[3]; //
        T1 t1 = new T1();
        t1s[0] = new T1();
        System.out.println(t1 + ", " + t1s[0]);
        t1 = new T1(); // 타입을 붙이면 왜 오류 ?? 주소값은 왜 달라 ?
        t1s[1] = new T1();
        System.out.println(t1 + ", " + t1s[1]);
        t1 = new T1();
        t1s[2] = new T1();
        System.out.println(t1 + ", " + t1s[2]);
        for (T1 t : t1s) {
            System.out.println(t + " ");
        }
    }
}
