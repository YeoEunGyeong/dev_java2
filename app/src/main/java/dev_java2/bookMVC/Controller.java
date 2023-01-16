package dev_java2.bookMVC;
// 추상 메서드만 interface 가질 수 있음
// 생성자, 일반 전역 변수 불가
public interface Controller {
    public abstract FrontController getController(String gubun);
}
