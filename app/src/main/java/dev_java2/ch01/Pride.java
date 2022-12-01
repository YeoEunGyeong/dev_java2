package dev_java2.ch01;

public class Pride {
  
  public static void main(String[] args) {
    Pride myCar = new Pride();
    Pride herCar = new Pride();
    herCar = myCar; // myCar 주소값을 가짐, herCar 주소값이 사라지고 myCar 주소값으로 변경

    System.out.println(myCar == herCar);
  }
}
