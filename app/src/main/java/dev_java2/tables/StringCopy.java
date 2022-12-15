package dev_java2.tables;

public class StringCopy {
    public static void main(String[] args) {
        String str = "잠와";
        String str1 = "잠와";
        System.out.println(str == str1); // 주소 번지 동일 ?? true
        System.out.println(str.equals(str1)); // 주소 번지가 가리키는 값이 동일 ??? t
        String str2 = new String("잠와");
        String str3 = new String("잠와");
        System.out.println(str2 == str3); // 주소 번지 동일 ?? false
        System.out.println(str2.equals(str3)); // 주소 번지가 가리키는 값이 동일 ??? t
    }
}
