package dev_java2.bookMVC;

import java.util.List;
import java.util.Map;

public class BookController {
    // public class BookController extends FrontController {
    // public class BookController implements Controller {
        // BookLogic bookLogic = new BookLogic();
        // 원래는 BookLogic 클래스를 객체 주입해야 하지만
        // 업무적인 depth가 얕아 로직 클래스에서 선택, 결정에 따른 프로세스가 전혀 없는 상태
        // 따라서 컨트롤러 클래스와 Dao클래스 사이에 연결만 담당하기 때문에 의미 없음~!
        BookDao bookDao = new BookDao();
        // 조회
        public List<Map<String, Object>> getBookList(String cols, String keyword) {
            System.out.println("도서 목록 조회");
            List<Map<String, Object>> bList = null;
            bList = bookDao.getBookList(cols, keyword);
            return bList;
        }
        // 입력
        public int bookInsert(BookVO bkVO) {
            System.out.println("도서 정보 등록");
            int result = 0;
            result = bookDao.bookInsert(bkVO);
            return result;
        }
        // 수정
        public int bookUpdate(BookVO bkVO) {
            System.out.println("도서 정보 수정");
            int result = 0;
            result = bookDao.bookUpdate(bkVO);
            return result;
        }
        // 삭제
        // 쿼리문을 보고 리턴, 파라미터 타입 및 갯수 결정하는데 참고!
        // DELETE FROM book WHERE bk_no = 5;
        // retrun 타입 int ; 1(삭제 성공) 0(실패)
        // 파라미터 타입 int ; 도서 번호
        public int bookDelete(int bk_no) {
            System.out.println("도서 정보 삭제");
            int result = 0;
            result = bookDao.bookDelete(bk_no);
            return result;
        }
}

/*
 * SQL 응용
 * 자바와 오라클 연동(연계)
 * JDBC API > MyBatis > Hibernate
 */