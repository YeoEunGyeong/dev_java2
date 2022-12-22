package dev_java2.ch05;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUD3 {
    static Vector<DeptVO> vdept = new Vector<>();
    static Scanner s = new Scanner(System.in);

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
    public int deptUpdate(DeptVO pdVO) { // pdVO 안에는 부서 번호 10만 있는 상태
        System.out.println("deptUpdata 호출 : 입력 받은 부서 번호는 " + pdVO.getDeptno());
        int result = 0;
        // here
        // Scanner scan = new Scanner(System.in);
        System.out.print("수정할 부서 번호, 부서명, 지역 입력(구분은 | 부탁~~!) : ");
        VectorCRUD3.s = null;
        VectorCRUD3.s = new Scanner(System.in);
        String user = VectorCRUD3.s.nextLine(); // 10|알라부|포항
        // 사용자가 입력한 부서 번호, 부서명, 지역 담을 변수 3개 선언
        int user_deptno = 0;
        String user_dname = null;
        String user_loc = null;
        // 문자열 3개를 한번에 받아오기 위해 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(user, "|");
        user_deptno = Integer.parseInt(st.nextToken()); // 사용자가 입력한 부서 번호
        user_dname = st.nextToken(); // 부서명
        user_loc = st.nextToken(); // 지역
        // 사용자가 입력한 부서 번호|부서명|지역 DeptVO의 멤버 변수에 초기화한 것
        DeptVO updVO = DeptVO.builder().deptno(user_deptno).dname(user_dname).loc(user_loc).build();
        // Vector에 들어있는 DeptVO에서 꺼낸 부서 번호와 파라미터로 넘겨 받은 부서 번호 일치하면
        // 그때 가져온 DeptVO의 인덱스가 우리가 삭제하고 추가해야 하는 Vector의 인덱스 값임
        DeptVO comVO = null;
        for (int i = 0; i < vdept.size(); i++) {
            comVO = vdept.get(i);
            // 화면에서 받아온 DeptVO의 deptno와 Vector에서 꺼내온 DeptVO의 deptno 동일한가 ??
            if (updVO.getDeptno() == comVO.getDeptno()) {
                // 화면에서 받아온 부서 번호와 Vector에서 꺼낸 부서 번호가 같을 때의 i값
                vdept.remove(i);
                vdept.add(i, updVO);
                result = 1;
                break; // Vector를 반복하는 for문 탈출
            } else {
                System.out.println("선택한 부서 번호와 Vector에서 가져온 번호가 다름");
            }
            getDeptList(); // 새로고침 처리됨
        }
        // VectorCRUD3.s.close();
        return result;
    }

    public int deptDelete(int deptno) {
        System.out.println("부서 정보 삭제 호출" + deptno);
        int result = 0;
        for (int i = 0; i < vdept.size(); i++) { //
            DeptVO rdVO = vdept.get(i);
            int deptno2 = 0;
            deptno2 = rdVO.getDeptno();
            System.out.println("입력 받은 값과 Vector에서 가져온 값을 비교 : " + deptno + ", " + deptno2);
            if (deptno == deptno2) { // 파라미터로 넘어온 부서 번호와 Vector에서 꺼낸 부서 번호 비교
                DeptVO rmVO = vdept.remove(i);
                if (rmVO != null)
                    result = 1;
            }
        }
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
            // return;
        }
        // 전체 조회 출력됨
        // Scanner s = new Scanner(System.in);
        // 수정과 삭제 메뉴 선택 담기
        int result2 = 0; // 수정 성공 여부 ; 성공 1, 실패 0
        int choice = 0; // 디폴트
        System.out.print("수정 1, 삭제 2 입력 : ");
        choice = VectorCRUD3.s.nextInt();
        if (choice == 1) {
            System.out.print("수정하고자 하는 부서 번호 입력 : ");
            int u_deptno = VectorCRUD3.s.nextInt();
            // 담을 수 있는 값은 부서 번호뿐 dname, loc은 null
            DeptVO updVO = DeptVO.builder().deptno(u_deptno).build();
            result2 = vCrud.deptUpdate(updVO); // DeptVO 파라미터로 넘김 ; 메인 메소드에서 결정된 정보(현재 10만 담겨있음)
            if (result2 == 1) {
                System.out.println("수정 완!");
                vCrud.getDeptList();
            } else
                System.out.println("실패");
        } else if (choice == 2) {
            System.out.println("삭제하고자 하는 부서 번호 입력 : ");
            VectorCRUD3.s = null;
            VectorCRUD3.s = new Scanner(System.in);
            int d_deptno = VectorCRUD3.s.nextInt();
            int result3 = vCrud.deptDelete(d_deptno);
            if (result3 == 1) {
                System.out.println("삭제 완!");
                vCrud.getDeptList();
            } else {
                System.out.println("실패");
            }
        }
        VectorCRUD3.s.close();
    }
}
