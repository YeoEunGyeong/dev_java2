package dev_java2.bookMVC;

import java.util.List;
import java.util.Map;

public class BookDao {
    /*************************************************
     * 도서 정보 삭제 구현
     * @param bk_no ; 도서 번호
     * @return ; 1이면 삭제 성공, 0이면 실패
     *************************************************/
    public int bookDelete(int bk_no) {
        int result = 0;
        System.out.println("bookDelete 호출(사용자가 선택한 도서 번호) : " + bk_no);
        // insert here

        return result;
    }
    /*************************************************
     * 도서 정보 수정
     * @param bkVO ; 수정 요청으로 입력받은 값
     * @return ; 1이면 삭제 성공, 0이면 실패
     *************************************************/
    public int bookUpdate(BookVO bkVO) {
        int result = 0;
        // 롬복 어노테이션 @Data 사용했기 때문에 getter, setter 메서드 없지만 사용 가능
        // 단, VO타입이므로 전변에 담긴 값을 출력하면 getter 메서드 호출
        // 전역 변수는 캡슐화로 인해 직접 접근 불가하고 위변조로 인한 피해로부터 보호하기 위해 
        // 접근 제한자는 반드시 private로 해야 함
        System.out.println("bookUpdate 호출(사용자가 선택한 도서 정보(주소 번지 출력)) :" + bkVO);
        return result;
    }
    /*************************************************
     * 도서 정보 입력
     * @param bkVO
     * @return ; 1이면 삭제 성공, 0이면 실패
     *************************************************/
    public int bookInsert(BookVO bkVO) {
        int result = 0;
        System.out.println("bookInsert 호출(사용자가 선택한 도서 입력(주소 번지 출력)) :" + bkVO);
        return result;
    }
    /*************************************************
     * 도서 정보 조회
     * SELECT bk_no, bk_title FROM book
     *  WHERE bk_title(?) =?
     *  WHERE bk_author(?) =?
     *  WHERE bk_info(?) =?
     * @param cols 컬럼명 bk_title / bk_author / bk_info
     * @param keyword 텍스트필드에 사용자가 입력한 값
     * @return 검색 결과는 n개 로우 List<Map<>>
     * 조인이 필수적인 경우에는 반드시 List<Map<>> 형태가 유리
     * 그렇지 않은 경우라면 List<~~VO>형태 별 차이가 없음
     * 단, 조회 결과로 얻은 정보를 자바에서 연산을 해야 하는 경우라면
     * 제네릭 타입;(<>)으로 Map보다는 ~~VO가 유리
     * Map이면 return 값이 무조건 Object // ClassCastingException
     * int i = Integer.parselnt(pMap.get("bk_no").toString()); < Map 사용 시
     * int i = ~~VO.getBkno(); < 이거 쓰는 게 편함 ? 아무래도 짧으니까 당연해 ^^;
     *************************************************/
    public List<Map<String, Object>> getBookList(String cols, String keyword) {
        return null;
    }
    
}
