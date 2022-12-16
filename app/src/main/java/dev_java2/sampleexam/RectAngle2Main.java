package dev_java2.sampleexam;

class RectAngle2 {
    void area(int w, int h) {
        int result = w * h;
        System.out.println("void : " + result);
    }

    int area(int w, int h, int result) {
        result = w * h;
        return result;
    }

}

public class RectAngle2Main {

    public static void main(String[] args) {
        RectAngle2 ra = new RectAngle2();
        ra.area(2, 3); // call by value

        int result = ra.area(5, 6, 0);
        System.out.println("int = retrun : " + result);
    }
}
