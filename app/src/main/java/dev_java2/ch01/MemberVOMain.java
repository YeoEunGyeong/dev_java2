package dev_java2.ch01;

public class MemberVOMain {
  public static void main(String[] args) {
    MemberVO memberVO = new MemberVO();
    String 사용자가입력한아이디 = "winter_ss";
    System.out.println(사용자가입력한아이디);
    // MemberVO 클래스에서 meme_id는 접근제한자를 private 설정하여 외부에서 접근 불가
    // 그래서 setter 메소드를 제공
    // memberVO.mem_id = "taeyeon_ss"; << 오류 ; MemberVO에서 설정된 mem_id가 private 설정 ;
    // 외부 클래스에서 가져올 수 없음
    // String mem_id = memberVO.setMem_id("taeyoen_ss"); << setter으로 불러올 수 없음
    // System.out.println(memberVO.mem_id);
    // private으로 선언된 변수는 클래스 외부에서 사용 불가 ; 보안의 문제 ; 캡슐화
    memberVO.setMem_id("taeyeon_ss");

    String id = memberVO.getMem_id();
    System.out.println(id);
    System.out.println(memberVO.getMem_id());

    // mem_name 경우 접근 제한차를 public이므로 직접 초기화 가능
    // memberVO.mem_name = "김태연";
    // String name = memberVO.mem_name; // null 상태 초기화 필요
    // System.out.println(name);
    // System.out.println(memberVO.mem_name);

    memberVO.setMem_name("김태연"); // setter 메소드를 호출하는 것만으로도 초기화
    System.out.println(memberVO.getMem_name()); // 김태연 출력

    memberVO.setMem_pw("3345");
    // setter 메소드를 호출하면 전역변수인 mem_pw 3345 초기화
    System.out.println(memberVO.getMem_pw());

    //
  }
}
