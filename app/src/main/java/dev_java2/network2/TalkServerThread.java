package dev_java2.network2;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
    TalkServer ts = null;
    Socket client = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    // 현재 서버에 입장한 클라이언트 스레드의 닉네임 저장
    String chatName = null;

    // 생성자
    public TalkServerThread() {
    }

    public TalkServerThread(TalkServer ts) {
        this.ts = ts;
        this.client = ts.socket;
        try {
            oos = new ObjectOutputStream(client.getOutputStream()); // 말하기
            ois = new ObjectInputStream(client.getInputStream()); // 듣기
            String msg = (String) ois.readObject();
            ts.jta_log.append(msg + "\n"); // 서버 화면에서 100#토마토 출력
            StringTokenizer st = new StringTokenizer(msg, "#");
            st.nextToken(); // 100 skip 처리
            chatName = st.nextToken(); // 토마토 저장
            ts.jta_log.append(chatName + "님 입장 \n");
            for (TalkServerThread tst : ts.globalList) {
                this.send(Protocol.TALK_IN + Protocol.separator + tst.chatName);
            }
            // 현재 서버에 입장한 클라이언트 스레드 추가
            ts.globalList.add(this);
            this.broadCasting(msg);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // 현재 입장해 있는 친구들 모두에게 메시지 전송 구현
    public void broadCasting(String msg) {
        for (TalkServerThread tst : ts.globalList) {
            tst.send(msg);
        }
    }

    // 클라이언트에게 말하기 구현
    public void send(String msg) {
        try {
            oos.writeObject(msg);
        } catch (Exception e) {
            e.printStackTrace(); // stack에 쌓여있는 에러 메시지 이력 출력 ; 디버깅시 자주 사용!
        }
    }

    @Override
    public void run() {
    }
}
