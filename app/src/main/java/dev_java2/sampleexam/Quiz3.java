package dev_java2.sampleexam;

// 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
// 출력하고 그 숫자의 빈도수를 계산하여 출력
public class Quiz3 {
    int counts[] = new int[10];

    int[] initArray(int datas[], int size) {
        int i;
        for (i = 0; i < datas.length; i++) {
            datas[i] = (int) (Math.random() * 10);
        }
        dataPrint(datas);
        return datas;
    }

    // 빈도 검사 배열에 들어있는 숫자 증가시켜보자 !!!!
    void numberCount(int[] datas) {
        int index = 0;
        for (int i = 0; i < 100; i++) {
            index = datas[i];
            counts[index]++;
        }
    }

    void dataPrint(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Quiz3 q3 = new Quiz3();
        int datas[] = new int[100];
        q3.initArray(datas, 100);
        q3.numberCount(datas);
        for (int i = 0; i < q3.counts.length; i++) {
            System.out.print(q3.counts[i] + " ");
        }
    }
}
