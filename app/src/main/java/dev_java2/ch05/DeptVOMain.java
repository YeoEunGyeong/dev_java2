package dev_java2.ch05;

public class DeptVOMain {
    public static void main(String[] args) {
        DeptVO dVo = DeptVO.builder().deptno(10).build();
        DeptVO dVo2 = DeptVO.builder().loc("제주").deptno(30).dname("경영부").build();
        System.out.println(dVo.getDeptno() + ", " + dVo.getDname() + ", " + dVo.getLoc());
        System.out.println(dVo2.getDeptno() + ", " + dVo2.getDname() + ", " + dVo2.getLoc());
    }
}
