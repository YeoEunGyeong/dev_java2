package dev_java2.ch02;

public class Switch1 {
  public static void main(String[] args) {
    String bread = "도넛";
    switch(bread){
      case "소보로":{
      int protocol = 100;
      System.out.println("소보로 빵입니다" + protocol);
      break;
    }
    case "도넛":{
      int protocol = 200;
      System.out.printf("%s 빵입니다 %d %n" + protocol);
      break;
    }
    default:
    System.out.println("원하는 빵이 없습니다");
    break;
  } // end of switch
}
}
