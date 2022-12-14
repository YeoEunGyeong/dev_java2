package dev_java2.sampleexam;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 기본 패키지인 java.lang 제외 모두 import 필요
// 인터페이스를 implements하면 반드시, 추상 메소드 재정의 필요 ; 오버라이딩

public class Sub1 implements ActionListener {
    // 선언부 ; 전역 변수의 위치
    // 선언에서 결정되는 것은 ?? ; 타입만 결정함
    // 원시형은 필드와 메소드를 가질 수 없음
    // 원시형은 부르면 값 호출
    // 참조형은 부르면 주소 번지 
    // 원시형에서는 NullPointException Xxxxxxxxxx 안 터짐
    // sub1.insert();
    JDialog jdg = new JDialog();
    JButton jbtn = new JButton("저장");
    Main1 main1 = null; // 선언만 함 ; null의 의미는 결정 되지 않음을 뜻함 ;; 원본 사용
    //Main1 main1 = new Main1(); // 선언과 생성함, 생성자도 호출 ;; 복제본 만들어짐
    // public Sub1(){ // 디폴트 생성자
    
    public Sub1(Main1 main1){ // 파라미터를 가진 생성자 // Main1 main1 = null
        System.out.println(main1);
        if(main1 == null) System.err.println("main1 = null = 객체 생성 안 됨");
        // 나 언제 호출 ?? 메인 앱이 실행될 때
        // 나 어디서 호출 ?? Main1 클래스에서 
        // 나 왜 호출 ?? 입력을 눌렀을 경우
        this.main1 = main1; // 객체 치환 ; 21열에 선언된 main1 = null이기 때문에 선언 필요!!
        initDispaly();
    }
    public void initDispaly(){
        jdg.add("South", jbtn);
        jbtn.addActionListener(this);
        jdg.setTitle("Sub1");
        jdg.setSize(300, 250);;
        jdg.setVisible(true);

    }
    int insert(){ // 1 : 입력 성공, 0 : 실패
        // insert 메소드에서 main1 접근 불가
        return 1;

    }
    /* 
    public static void main(String[] args) {
        new Sub1(null); // null을 주는 이유는 생성자에서 Main1 main1 사용하지 않고 화면 호출만 확인하고 싶기 때문
    } // Sub1에서 main1 = nill 확인만 하기 위해 만든 메인 필요 Xxxxxxxx!!
    */
    
    /* 
     *  콜백 메소드
     *  저장 버튼이 클릭되었을 때 JVM 이를 감지하고 인터셉트하여 메소드 호출
     *  파라미터인 ActionEvent 객체를 통해서 이벤트가 감지된 버튼 구분 가능
     *  이 객체는 파라미터에 있으므로 JVM으로 부터 주입이 되는 객체임
     *  다시 말해 개발자가 인스턴스화 하지 않고 JVM이 대신 해 줌
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 너 저장 버튼 눌렀어 ??
        Object obj = e.getSource();
        // 반복문 탈출 시 break 사용
        // 조건문 탈출 시 retrun 사용
        if (obj == jbtn){
            int result = insert();
            if (result == 1){
                JOptionPane.showMessageDialog(jdg, "입력 성공~~!"); // 팝업창을 띄우는 코드
                main1.refresh();
                jdg.dispose(); // 현재 하나의 창을 종료
            } else if (result == 0){
                JOptionPane.showMessageDialog(jdg, "입력 실패~~~!!~!~!!");
                return; // actionPerforemed 탈출
            }
            
        }
    }
}
