package dev_java2.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatsServer {
    public static void main(String[] args) {
        String url = "http://192.168.10.47:9000/index.html";
        try { // 예외가 발생할 가능성이 있는 코드 작성
            URL myURL = new URL(url);
            HttpURLConnection con = (HttpURLConnection) myURL.openConnection();
            int responseCode = con.getResponseCode(); // 200, 404, 500 상수값 보여짐
            // System.out.println(responseCode);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = "빈 문자열을 넣어놓으면 NullPointException 피할 수 있으니까";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

/*
 * http 웹 서비스 요청과 응답을 받아옴
 * 웹 서비스를 제공하기 위해서 웹 서버 필요
 * 웹 서비스는 요청으로 시작해 응답으로 끝
 * 
 * 요청을 하고 응답을 받을 시 URL 주소 필요
 * 
 * http://192.168.10.47:9000/index.html > Enter 서버에 전달 > 처리 > 응답
 * http://192.168.10.47:9000/index.html 정보를 객체화 해 줌
 * 
 * 서버가 클라이언트측에 응답을 보내면서 전달되는 상태값 존재
 * 정상 가동 200
 * 페이지 경로가 틀릴 시 404에러
 * 자바 예외처리 ; NullPointException, ClassNotFoundException,
 * ArrayIndexOutOfBoundException 500에러
 */