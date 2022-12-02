package dev_java2.ch01;

public class MemberAction {
  // 회원가입 성공 시 1 반환, 실패 시 0 반환 처리하는 메소드 선언
  public int memberInsert(String mem_id, String mem_pw, String mem_name) {
    System.out.println("memberinsert 호출 - 파라미터 3 개");
    System.out.println(mem_id + "," + mem_pw + "," + mem_name);
    int result = -1; // End of file
    // 회원가입에 성공?
    if (1 == 1) {
      result = 1;
    } else {
      result = 0;
    }
    return result;
  }

  public int memberinsert(MemberVO memberVO) {
    System.out.println("memberinsert 호출 - 파라미터 1 개");
    System.out.println(memberVO.getMem_id() +
        "," + memberVO.getMem_pw() +
        "," + memberVO.getMem_name());
    int result = -1;
    return result;
  }

  public static void main(String[] args) {
    // insert here ; memberinsert 메소드 호출
    MemberAction memberAction = new MemberAction();
    int result = memberAction.memberInsert("winter_01", "0001", "김민정");
    if (result == 1) {
      System.out.println("회원가입 성공");
    } else {
      System.out.println("회원가입 실패");
    }
    MemberVO memberVO = new MemberVO();
    memberVO.setMem_id("karina_00");
    memberVO.setMem_pw("0000");
    memberVO.setMem_name("유지민");
    memberAction.memberinsert(memberVO);
    int result2 = memberAction.memberinsert(memberVO);
    if (result == 1) {
      System.out.println("회원가입 성공");
    } else {
      System.out.println("회원가입 실패");
    }
  }
}