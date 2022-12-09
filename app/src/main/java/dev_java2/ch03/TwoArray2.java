package dev_java2.ch03;

public class TwoArray2 {
    public static void main(String[] args) {
        int arr[][] = new int[3][];
        // arr[0] = new int[3];
        arr[0] = new int[]{1, 2, 3};
        // arr[1] = new int[3];
        arr[1] = new int[]{4, 5, 6, 7};
        // arr[2] = new int[3];
        arr[2] = new int[]{8, 9, 10, 11, 12};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println("arr["+i+"]["+j+"] = "+arr[i][j]);
            } // end of inner
        } // end of outter

    
}
}
