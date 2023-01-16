package dev_java2.bookMVC;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 개발 방법론에서 디자인 패턴 MVC 패턴 알아보자
// M : 모델 계층 (~~Lojic.java + ~~Dao.java > 서비스 계층 ; 비지니스 로직(업무) 계층)
// ~~Dao가 있고 없고는 MVC 패턴에 영향 없음
// 단, 오라클 서버와 연계에 반복되는 코드를 줄여주고 오픈 소스나 라이브러리
// (iBatis, MyBatis(반자동), Hibernate(완전 자동)) 조립하기 위한 요구사항으로 만들어 사용하는 클래스
// 클래스 쪼개기 ;POJO(pure) > Spring(maven) > Spring boot(Gradle)
// C : 컨트롤 계층
// V : 뷰 계층 
// 프레임워크를 왜 ??
// 1 실력 차이 줄임
// 2 틀이 정해짐 ; 클래스 선언, 메서드 선언(단, 파라미터 타입과 갯수는 사용자가 결정)
// 개발자는 비지니스 로직에만 집중!
public class BookManger extends JFrame implements ActionListener {
    JButton jbtn_sel = new JButton("조회"); // SELECT
    JButton jbtn_ins = new JButton("입력"); // INSERT
    JButton jbtn_upd = new JButton("수정"); // UPDATE
    JButton jbtn_del = new JButton("삭제"); // DELETE
    JButton jbtn_board = new JButton("게시판"); //
    JPanel jp_north = new JPanel();
    String gubun = "bookMgr"; // 도서 CRUD이면 bookMgr, 게시판 CRUD이면 boardMgr

    public BookManger() {
        // initDisplay()
        // ; 속지(JPanel, JScrollPane ~)로 사용되는 페이지일 때
        // 요청에 따른 페이지 갱신처리, 화면 갱신, 화면 초기화
        // 그러나 스레드 구현 시에는 이슈가 발생하기 때문에 주의!
        // 문법 에러 <-> 논리 에러 ; 트러블슈팅 NullPointException (예외 상황)
    }

    public void initDisplay() {
        // 이벤트 소스와 처리 클래스 매핑
        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_board.addActionListener(this);
        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_del);
        jp_north.add(jbtn_board);
        this.setTitle("도서 관리 시스템");
        this.setLocation(100, 100);
        this.setSize(500, 400);
        this.add("North", jp_north);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BookManger bManger = new BookManger();
        // 메인 스레드와 Runnable을 통해 구현하는 스레드를 분리할 수 있는 경우에 사용함
        // 메인 스레드와 자기 자신이 Run 구현체 클래스 역할을 병행하는 컨셉일 때 메인에서 호출
        // 이런 경우 메인에서 호출을 하지 않으면 화면 지연 발생, socket accept 일어나지 않음 ; 사! 망!
        bManger.initDisplay(); // 리펙토링 ;
    }

    // 왜 재정의 해 ??
    // 장치마다 결정되지 않았기 때문에
    @Override
    public void actionPerformed(ActionEvent e) { // 콜백 함수 ; 웹, 앱, 하이브리드앱 개발
        // 4개 버튼 클릭되면 이벤트를 JVM이 감지 > actionPerformed 메서드를 자동 호출
        Object obj = e.getSource();
        BookController bookController = null;
        BoardController boardController = null;
        if (obj == jbtn_board) {
            // 게시판 CRUD
            gubun = "boardMgr";
            if ("boardMgr".equals(gubun)) {
                boardController = (BoardController) FrontController.getController(gubun);
                System.out.println("게시판 선택 : " + boardController);
                // 게시판 컨트롤러가 결정되면 다시 디폴트값으로 초기화
                gubun = "bookMgr";
            }
        }
        // 도서 CRUD ??
        else if ("bookMgr".equals(gubun)) {
            bookController = (BookController) FrontController.getController(gubun);
            System.out.println("도서 관리 선택 : " + bookController);
            // if문은 무조건! 조건! 따짐!
            // else if문은 앞조건 수렴하면 뒤에 있는 코드 실행 기회가 없음
            // 조회 ?
            if (obj == jbtn_sel) {
                System.out.println("입력");
            }
            // 입력 ?
            else if (obj == jbtn_ins) {
                System.out.println("조회");
            }
            // 수정 ?
            else if (obj == jbtn_upd) {
                System.out.println("수정");
            }
            // 삭제 ???
            else if (obj == jbtn_del) {
                System.out.println("삭제");
            }
        } // bookMgr end

    }
}
