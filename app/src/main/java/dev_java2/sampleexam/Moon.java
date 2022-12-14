package dev_java2.sampleexam;

import java.util.Scanner;

public class Moon {
    public static void main(String[] args) {
        double w1 = 0.0;
        double weight = 0.0;
        final double moon = 0.17;
        Scanner s = new Scanner(System.in);

        System.out.print("지구에서의 몸무게 ?");
        String user1 = s.nextLine();
        double d1 = Double.parseDouble(user1);
        weight = d1 * moon;
        System.out.println("달에서의 몸무게는 : " + weight + "임!!");
    }
}