package dev_java2.ch02;

public class NansuExam2 {
  int com[] = new int[3];
  int my[] = new int[3];

  public void ramCom(){
    com[0] = (int)(Math.random() * 3);
    do{
      com[1] = (int)(Math.random() * 3);
    }
    while(com[0] == com[1]);
    }

  public static void main(String[] args) {

  }

}
