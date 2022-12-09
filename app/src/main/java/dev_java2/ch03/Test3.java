package dev_java2.ch03;

public class Test3 {
  public void methodA() {
    System.out.println("methodA 호출 성공");
    int arr[] = new int[4]; // 초기화값이 없는 상태 [0, 0, 0, 0]
    for (int i = 0; i < arr.length; i++) { 
      arr[i] += (10 + i);
      System.out.println(arr[i]);
    }
  }
  // try-catch를 사용하여 에러 예외처리
  // int arr[] = new int[4]; // 초기화값이 없는 상태 [0, 0, 0, 0]
  // for (int i = 0; i <= arr.length; i++) { 
  //  try {
  //    arr[i] += (10 + i);
  //    System.out.println(arr[i]);
  //  } catch (ArrayIndexOutOfBoundsException e) {
  //    System.out.println(e.toString());
  //  }


  public static void main(String[] args) {
    Test3 t3 = new Test3();
    t3.methodA();
  }
}
