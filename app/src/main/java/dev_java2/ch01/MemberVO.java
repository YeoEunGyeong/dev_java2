package dev_java2.ch01;

// 자료 구조의 일부로 사용
// 회원 정보를 관리하기 위한 목적으로 설계 ; 그래서 main 메소드는 필요 없음
public class MemberVO {
  private String mem_id = null;
  private String mem_pw = null;
  private String mem_name = null;

  public String getMem_id() {
    return this.mem_id;
  }

  public void setMem_id(String mem_id) {
    this.mem_id = mem_id;
  }

  public String getMem_pw() {
    return this.mem_pw;
  }

  public void setMem_pw(String mem_pw) {
    this.mem_pw = mem_pw;
  }

  public String getMem_name() {
    return this.mem_name;
  }

  public void setMem_name(String mem_name) {
    this.mem_name = mem_name;
  }

  // public String mem_name = null; 8열과 9열 접근 제한자 비교
  // setter ; write, save

  /////// **수업 내용
  /////// public void setMem_id(String mem_id) { // setter 메소드를 통해서 전역변수를 초기화 >> 5열
    //// setMem_id를 설정하기 위해 파라미터 안에 String 타입 선언 ; id는 string으로 선언 가능
    //// this.mem_id = mem_id;
  ////}

  /////// getter ; read, listn
  /////// public String getMem_id() { // 초기화된 mem_id를 출력하기 위해 getter 사용
    //// return mem_id;
  ////}
  
  public static void main(String[] args) {
    MemberVO memberVO = new MemberVO();
    System.out.println(memberVO.mem_id); // null 출력, 클래스 내부 private 사용 가능
  }
}
