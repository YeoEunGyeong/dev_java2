package dev_java2.ch01;

public class DeptVOMain {

  public static void main(String[] args) {
    DeptVO deptVO = new DeptVO();
    deptVO.deptno = 10;
    deptVO.dname = "개발1팀";
    deptVO.loc = "부산";
    System.out.println(deptVO.deptno); // 10
    System.out.println(deptVO.dname); // 개발1팀
    System.out.println(deptVO.loc); // 부산
    deptVO = new DeptVO(); // 변수 선언이 아니라 새로운 객체 생성 ; 6번과 다른 객체
    deptVO.deptno = 30; // 새롭게 생성한 객체이므로 여기서 설정된 초기화 값으로 설정됨
    System.out.println(deptVO.deptno); // 30
    System.out.println(deptVO.dname); // 개발1팀
    System.out.println(deptVO.loc); // 부산
  }
}
