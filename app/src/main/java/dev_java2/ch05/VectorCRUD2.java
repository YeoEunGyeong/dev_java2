package dev_java2.ch05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUD2 {
    static Vector<String[]> vdept = new Vector<>();
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

    public int deptInsert(String[] userDept) {
        System.out.println("부서 정보 입력 호출");
        int result = 0; // 1 성공, 0 실패
        boolean isOK = vdept.add(userDept);
        if (isOK)
            result = 1;
        return result;
    }

    /***********************************
     * 부서 정보 수정 ; 있는 것 변경
     * 
     * @param deptno     수정하고자 하는 부서 번호
     * @param user_dname 수정하고자 하는 부서명
     * @param user_loc   수정하고자 하는 지역
     * @retrun 1 성공, 0 실패
     * 
     ***********************************/

    public int deptUpdate(int deptno, String user_dname, String user_loc) {
        System.out.println("부서 정보 수정 호출" + user_dname + ", " + user_loc);
        String[] oneRow = null;
        String[] comRow = null;
        //
        for (int i = 0; i < vdept.size(); i++) {
            oneRow = vdept.get(i);
            if (deptno == Integer.parseInt(comRow[0])) {
                oneRow = comRow; // 얕은 복사 ; 하나를 바꾸면 따라 바뀐다(같은 주소값을 참조하고 있기 때문)
                // 깊은 복사 ; 각자 바뀐 값을 가지고 있음
            }
        }
        int result = 0; // 1 성공, 0 실패
        here: for (int i = 0; i < vdept.size(); i++) {
            String row[] = vdept.get(i); // i는 row index
            // if() ; 벡터에서 꺼낸 배열(row)과 비교 (기존에 가지고 있는 정보)
            for (int j = 0; j < row.length; j++) { // String[] 돌림
                // if() ; 화면에서 가져온 배열(deptno)과 벡터에서 꺼낸 배열(row) 비교 ()
                // if (oneRow[0].equals(row[0])) {
                int deptno2 = 0;
                deptno2 = Integer.parseInt(row[0]);
                System.out.println(deptno + ", " + deptno2);
                if (deptno == deptno2) {
                    String[] updRow = { oneRow[0], user_dname, user_loc }; // 새로 받아오는 정보값을 updRow에 담김
                    // 수정이라 말하고 입력으로 처리 ; 한 셀씩 수정하는 것
                    vdept.remove(i); // 기존에 가지고 있는 값 삭제(i번째 자리 삭제)
                    // Vector 사용하면 배열의 모든 단점을 보완 ; 고정, 타입의 단
                    // Vector<Object>
                    vdept.add(i, updRow); // 삭제된 자리에 추가 ; 배열의 장애 int i[] = new int[3]
                    // break문만 사용 시 for문에서 내부 for문만을 탈출
                    // 여기서는 외부 for문을 빠져나가야 하므로 라벨문을 붙여 처리
                    break here;
                } else {
                    System.out.println("선택한 부서 번호와 벡터에서 가져온 부서 번호 다름");
                }
            } // end String[] ; 배열 inner for
        } // end Vector ; outter for
        return result;
    }

    public int deptDelete(int deptno) {
        System.out.println("부서 정보 삭제 호출");
        int result = 0; // 1 성공, 0 실패
        for (int i = 0; i < vdept.size(); i++) {
            String oneRow[] = vdept.get(i);
            int deptno2 = 0;
            if (oneRow[0] != null) {
                deptno2 = Integer.parseInt(oneRow[0]);
            }
            System.out.println("입력 받은 값과 벡터에서 가져온 값 비교 !!!" + deptno + ", " + deptno2);
            if (deptno == deptno2) {
                String[] deleteRow = vdept.remove(i);
                System.out.println("삭제된 배열은 " + Arrays.toString(deleteRow));
                if (deleteRow != null) {
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
        String[] oneRow = { "10", "개발부", "서울" };
        int result1 = vCrud.deptInsert(oneRow);
        String[] oneRow2 = { "20", "배달부", "제주" };
        result1 = vCrud.deptInsert(oneRow2);
        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록 완료!");
            vCrud.getDeptList();
        }
        Scanner s = new Scanner(System.in);
        System.out.print("수정할 부서 번호, 부서명, 지역 입력(구분은 | 부탁~~!) : ");
        String user = s.nextLine(); // 10|알라부|포항
        int user_deptno = 0;
        String user_dname = null;
        String user_loc = null;
        // 이거 뭐야 ?
        StringTokenizer st = new StringTokenizer(user, "|");
        user_deptno = Integer.parseInt(st.nextToken()); // 사용자가 입력한 부서 번호
        user_dname = st.nextToken(); // 사용자가 입력한 부서명
        user_loc = st.nextToken(); // 사용자가 입력한 지역
        s.close();
        // 삭제
        int result3 = vCrud.deptDelete(user);
        if (result3 == 1) {
            JOptionPane.showMessageDialog(null, "삭제 처리 완료!!");
            vCrud.getDeptList();
        }
        s.close();
        // 수정
        int result2 = vCrud.deptUpdate(user_deptno, user_dname, user_loc);
        // 상세보기
        String[] result4 = vCrud.deptDetail(deptno);
    }
}
