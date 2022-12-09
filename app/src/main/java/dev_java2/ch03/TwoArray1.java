package dev_java2.ch03;
// 2차 배열 -> List<Map> 제네릭
public class TwoArray1 {
    void toWhile(int[][] arr){
        System.out.println("=====while======");
        int i = 0;
        while(i < arr.length){
            int j = 0;
            while(j < arr[i].length) {
            System.out.println("arr["+i+"]["+j+"] = "+arr[i][j]);
            j++;
        } //end of inner while
        i++;
        } //end og outter while

    }
    public static void main(String[] args) {
        int arr[][]= new int[2][3];
        TwoArray1 ta = new TwoArray1();
        ta.toWhile(arr);
        System.out.println("=====for======");
        for(int i = 0; i < arr.length; i++){ // 로우 
            for(int j = 0; j < arr[i].length; j++){ // 컬럼
                // 여기서 arr[i]는 값이 아니라 주소 번지  
                System.out.println("arr["+i+"]["+j+"] = "+arr[i][j]);
            } // end of inner
        } // end of outter
    }
    
}
