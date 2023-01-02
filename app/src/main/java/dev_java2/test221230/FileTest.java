package dev_java2.test221230;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    public void output() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("test.txt", true);
            fw.write(97);
            fw.write(65);
            fw.close();
            // io패키지는 스트림형태로 이동하니까 열려있을 경우 인터셉트, 위변조 가능하므로 반드시 닫는 코드
        } catch (FileNotFoundException fe) {
            System.out.println("파일 존재 Xxxxx");
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // 예외가 발생하든 아니든 무조건 처리할 코드는 아래에 작성
            try {
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) {
        FileTest ft = new FileTest();
        ft.output();
    }
}
