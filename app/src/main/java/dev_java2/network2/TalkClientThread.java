package dev_java2.network2;

import java.util.StringTokenizer;
import java.util.Vector;

public class TalkClientThread extends Thread {
    TalkClient tc = null;

    public TalkClientThread(TalkClient tc) {
        this.tc = tc;
    }

    // 서버측에서 클라이언트가 접속하면 접속자의 정보를 List<TalkClientThread> add(스레드 생성자)
    // 메시지 청쥐하자마자 클라이언트측에 반복문 돌려 씀 ; 전송함 - broadCasting(String msg)
    @Override
    public void run() {
        boolean isStop = false;
        // run_stop
        while (!isStop) {
            try {
                String msg = "";
                msg = (String) tc.ois.readObject();
                System.out.println("서버에 전송된 msg : " + msg);
                StringTokenizer st = null;
                int protocol = 0;
                if (msg != null) {
                    st = new StringTokenizer(msg, "#");
                    protocol = Integer.parseInt(st.nextToken());
                }
                System.out.println("protocol : " + protocol);
                switch (protocol) {
                    case Protocol.TALK_IN: {
                        String nickName = st.nextToken();
                        tc.jta_display.append(nickName + "님 입장 \n");
                        // JTable은 양식일 뿐
                        // 데이터셋은 DefaultTavleModel이니까 거기서 닉네임 출력
                        Vector<String> v = new Vector<>();
                        v.add(nickName);
                        // 데이터셋 객체에 한 개 로우 추가
                        tc.dtm.addRow(v);
                    }
                        break;
                    default:
                        System.out.println("해당하는 protocol 없음");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
