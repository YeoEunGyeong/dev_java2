package dev_java2.ch07;

public class T {
    ZipCodeSearch zcs = null;

    // 메소드를 통해서도 객체주입 받기 가능 ; 싱글톤패턴
    public ZipCodeSearch getInstance() {
        if (zcs == null) { //
            zcs = new ZipCodeSearch();
        }
        return zcs;
    }

    public static void main(String[] args) {
        T t = new T();
        t.zcs = t.getInstance();
        t.zcs.getZipcode("동동동대문을 열어라");
    }
}
