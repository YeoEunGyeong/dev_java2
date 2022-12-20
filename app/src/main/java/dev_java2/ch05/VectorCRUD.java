package dev_java2.ch05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
// List ; 순서가 있음, 느리다, 정렬(2차 가공 ; ), 추가하면 뒤로 추가시킴
// index 다르면 중복값 저장 가능

public class VectorCRUD {
    static Vector<String[]> vdept = new Vector<>(); // 조회 결과가 벡터에 담김
    static Vector<DeptVO> vdept2 = new Vector<>();

    public void getDeptList() {
        for (int i = 0; i < vdept.size(); i++) {
            String[] oneRow = vdept.get(i);
            for (int j = 0; j < oneRow.length; j++) {
                System.out.print(oneRow[j] + ", ");
            } // end inner
            System.out.println();
        } // end outter
    }

    // 벡터에 부서 정보 추가 ; 없는 것 새로 추가
    // pass by value 호출하는 경우 주소 번지 받아옴 ; 원본을 받는 것 main, ival, sub.ival
    public int deptInsert(String[] userDept) {
        System.out.println("부서 정보 입력 호출");
        int result = 0; // 1 성공, 0 실패
        boolean isOK = vdept.add(userDept);
        if (isOK)
            result = 1;
        return result;
    }

    // 부서 정보 수정 ; 있는 것 변경
    public int deptUpdate(int user, String user_dname, String user_loc) {
        System.out.println("부서 정보 수정 호출");
        int result = 0; // 1 성공, 0 실패
        return result;
    }

    // 부서 정보 삭제 ; 있는 것 삭제
    // 벡터에 있는 부서 정보 중 어떤 로우를 삭제할 것인지 부서 번호(식별자) 필요
    // 이 값은 사용자로부터 받아와야하는 값
    // 받아오는 값은 int형, 그런데 비교하는 값은 String[]에서 부서 번호 String 타입
    // int -> String 형변환 필요 ; null이 오면 NumberFormatException 발생할 가능성 있음
    // 방어코드 작성 필요 ; null에 대한 이슈는 현재 프로그래밍에 있어 심각한 장애로 인식 (중요!!)
    public int deptDelete(int user) { // 받아오는 값은 int 숫자, scanner에서 사용자로부터 받은 값
        System.out.println("부서 정보 삭제 호출");
        int result = 0; // 1 성공, 0 실패
        for (int i = 0; i < vdept.size(); i++) {
            String oneRow[] = vdept.get(i); // 비교하는 값은 String
            int deptno2 = 0;
            // 예외 발생에 대한 방어 코드 작성
            if (oneRow[0] != null) { // null 체크 ; 프레임워크에서 떠안으려고 함
                // oneRow[1] = dname, oneRow[2] = loc
                deptno2 = Integer.parseInt(oneRow[0]);
            }
            // 사용자가 선택한 부서 번호와 벡터에 있는 부서 번호를 비교하여 같은 번호 찾기
            System.out.println("입력 받은 값과 벡터에서 가져온 값 비교 !!!" + user + ", " + deptno2);
            if (user == deptno2) {
                // 삭제할 벡터의 로우값 필요 ; 벡터의 size 통해 찾아냄
                // 여기서 변수 i가 인덱스값에 해당
                // remove메소드의 파라미터가 int인 경우에 대해서만 삭제된 벡터의 제네릭 반환
                // 그 값을 받아 처리 여부 확인 가능
                String[] deleteRow = vdept.remove(i); // i = 0
                System.out.println("삭제된 배열은 " + Arrays.toString(deleteRow)); // toString 사용으로 값으로 확인
                // boolean isOk = vdept.remove(oneRow); // 메소드 오버로딩 // 삭제 처리가 됐는지 t, f 알 수 있음
                // 삭제한 객체가 존재 ?? Y/N
                if (deleteRow != null) {
                    // JOptionPane.showMessageDialog(null, "삭제됨!!"); // 삭제 처리 창이 두 번 호출되기 때문에 주석
                    // 삭제 처리가 성공했으므로 반환값 1
                    result = 1;
                }
            }
        } // end for
        return result;
    } // end deptDelete

    // 부서 정보 상세보기 ; 있는 것에서 꺼냄

    public String[] deptDetail(int index) {
        String[] oneRow = new String[3];
        for (int i = 0; i < vdept.size(); i++) {
            if (1 == 1) {
            }
        }
        return oneRow;
    }

    public static void main(String[] args) {
        VectorCRUD vCrud = new VectorCRUD();
        // 입력 테스트
        int deptno = 10;
        String dname = "개발부";
        String loc = "서울";
        String[] oneRow = { "10", "개발부", "서울" }; // 제네릭 타입으로 사용
        int result1 = vCrud.deptInsert(oneRow); // 배열로 선언한 값이 있기 때문에 변수 3개 사용보다 실용적
        String[] oneRow2 = { "20", "배달부", "제주" };
        result1 = vCrud.deptInsert(oneRow2);
        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록 완료!");
            vCrud.getDeptList();
            // retrun 주석 처리가 안 되면 메소드 블록을 빠져나가기 때문에 scanner 거치지 않기 때문에 값을 입력받지 못함
            // return; // 조건문이 retrun문 해당 메소드 블록을 빠져나감
        }
        // 입력하여 삭제할 부서 번호 받기 위한 코드 입력
        Scanner s = new Scanner(System.in);
        System.out.print("삭제할 부서 번호 입력 : ");
        int user = s.nextInt();
        // 삭제
        int result3 = vCrud.deptDelete(user);
        if (result3 == 1) {
            JOptionPane.showMessageDialog(null, "삭제 처리 완료!!");
            vCrud.getDeptList();
            // return; // scanner 종료 코드 실행시키기 위해 주석
        }
        s.close();
        // 수정
        // int result2 = vCrud.deptUpdate(deptno);
        // 상세보기
        String[] result4 = vCrud.deptDetail(deptno);
    }

    public int deptDelete(String user) {
        return 0;
    }
}
