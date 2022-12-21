package dev_java2.ch05;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUD3 {
    static Vector<DeptVO> vdept = new Vector<>();

    public void getDeptList() {
        for (int i = 0; i < vdept.size(); i++) {
            DeptVO dVO = vdept.get(i);
            System.out.println(dVO.getDeptno() + ", " + dVO.getDname() + ", " + dVO.getLoc());
        } // end outter
    }

    public int deptInsert(DeptVO pdVO) {
        System.out.println("부서 정보 입력 호출");
        int result = 0; // 1 성공, 0 실패
        boolean isOK = vdept.add(pdVO);
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

    public int deptUpdate(DeptVO pdVO) {
        int result = 0;
        // here
        return result;
    }

    public int deptDelete(int deptno) {
        System.out.println("부서 정보 삭제 호출");
        int result = 0;
        return result;
    } // end deptDelete

    // 부서 정보 상세보기 ; 있는 것에서 꺼냄
    public DeptVO deptDetail(int deptno) {
        DeptVO rdVO = null;
        // here
        return rdVO;
    }

    public static void main(String[] args) {
        VectorCRUD3 vCrud = new VectorCRUD3();
        // 입력 테스트
        DeptVO dvo1 = DeptVO.builder().deptno(10).dname("개발부").loc("인천").build();
        System.out.println(dvo1.toString());
        int result1 = vCrud.deptInsert(dvo1);
        dvo1 = null; // 기존에 참조하는 객체와 연결을 끊음
        dvo1 = DeptVO.builder().dname("배달부").deptno(20).loc("제주").build();
        System.out.println(dvo1.toString());
        result1 = vCrud.deptInsert(dvo1);
        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록 완료!");
            vCrud.getDeptList();
            return;
        }
        Scanner s = new Scanner(System.in);
        System.out.print("수정할 부서 번호, 부서명, 지역 입력(구분은 | 부탁~~!) : ");
        String user = s.nextLine(); // 10|알라부|포항
        int user_deptno = 0;
        String user_dname = null;
        String user_loc = null;
        // 이거 뭐 ??
        StringTokenizer st = new StringTokenizer(user, "|");
        user_deptno = Integer.parseInt(st.nextToken()); // 사용자가 입력한 부서 번호
        user_dname = st.nextToken(); // 사용자가 입력한 부서명
        user_loc = st.nextToken(); // 사용자가 입력한 지역
        s.close();
    }
}
