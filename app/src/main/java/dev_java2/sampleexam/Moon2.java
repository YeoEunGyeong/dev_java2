package dev_java2.sampleexam;

import java.util.Scanner;

public class Moon2 {
    // double weight;
    final double moon = 0.17;

    double erth(int d1) {
        double weight = d1 * moon;
        return weight;
    }

    public static void main(String[] args) {
        Moon2 m2 = new Moon2();
        Scanner s = new Scanner(System.in);
        System.out.print("지구에서의 몸무게 ??");
        String user1 = s.nextLine();
        double d1 = Double.parseDouble(user1);
        double weight = m2.erth(100);
        System.out.println("달에서의 몸무게는 : " + weight + "임!!");
    }

}
