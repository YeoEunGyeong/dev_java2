package dev_java2.addressbook;

import javax.swing.JDialog;

public class AddressDialog {
    JDialog jdg = new JDialog();

    public AddressDialog(){
        jdg.setTitle("입력|수정|상세보기");
        jdg.setSize(400, 300);
        jdg.setVisible(false); // 입력 버튼 눌렀을 시 화면이 떠야 하기 때문에 false
    }
    // 생성

    // 화면

    // 메인
    public static void main(String[] args) {
        new AddressDialog();
    }

}
