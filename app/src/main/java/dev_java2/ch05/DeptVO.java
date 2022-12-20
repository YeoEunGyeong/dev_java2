package dev_java2.ch05;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // getter, setter 따로 추가하지 않아도 되는 툴
@Builder // 생성자 파라미터를 유저가 설정한대로 사용 가능
@Setter
@Getter

public class DeptVO {
    int deptno;
    String dname;
    String loc;
}
