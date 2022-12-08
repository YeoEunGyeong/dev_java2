package dev_java2.ch03;

public class Test3 {
  public void methodA() {
    int[] arr = new int[4];
    // int arr[] = new int[4];
    for (int i = 0; i < arr.length; i++) {
      arr[i] += (10 + i);
    }
    System.out.println("methodA 호출 성공");
  }

  public static void main(String[] args) {
    Test3 t3 = new Test3();
    t3.methodA();
  }
}
