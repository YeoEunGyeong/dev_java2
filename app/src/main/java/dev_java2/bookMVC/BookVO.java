package dev_java2.bookMVC;

import lombok.Data;

@Data
public class BookVO { // Ctrl + Shift + Y ; 소문자로 변경
    private int bk_no;
    private String bk_title;
    private int bk_price;
    private String bk_date;
    private String bk_publish;
    private String bk_info;
    private String bk_author;
}
