package dev_java2.network3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread2 extends Thread {
    TalkServer2 ts = null;
    Socket client = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    // 현재 서버에 입장한 클라이언트 스레드의 닉네임 저장
    String chatName = null;

    // 생성자
    public TalkServerThread2() {
    }

    public TalkServerThread2(TalkServer2 ts) { // TalkServer2가 TalkServer2에서 this임
        this.ts = ts;
        this.client = ts.socket;
        try {
            oos = new ObjectOutputStream(client.getOutputStream());// 말하기
            ois = new ObjectInputStream(client.getInputStream());// 듣기
            // 100#tomato ; 서버에 접속하자마자
            String msg = (String) ois.readObject();
            ts.jta_log.append(msg + "\n");
            StringTokenizer st = new StringTokenizer(msg, "#");
            st.nextToken();// 100 skip처리
            chatName = st.nextToken();// 토마토 저장
            ts.jta_log.append(chatName + "님이 입장하였습니다.\n");
            for (TalkServerThread2 tst : ts.globalList) {
                this.send(Protocol.TALK_IN + Protocol.separator + tst.chatName);
            }
            // 현재 서버에 입장한 클라이언트 스레드 추가하기
            ts.globalList.add(this);
            this.broadCasting(msg);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
    public void broadCasting(String msg) {
        for (TalkServerThread2 tst : ts.globalList) {
            tst.send(msg);
        }
    }

    // 클라이언트에게 말하기 구현
    public void send(String msg) {
        try {
            oos.writeObject(msg);
        } catch (Exception e) {
            e.printStackTrace();// stack에 쌓여 있는 에러메시지 이력 출력함
        }
    }

    @Override
    public void run() {
        String msg = null;
        boolean isStop = false;
        try {
            // while(true) {//무한루프에 빠질 수 있다.
            run_start: while (!isStop) {
                msg = (String) ois.readObject();
                ts.jta_log.append(msg + "\n");
                ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
                StringTokenizer st = null;
                int protocol = 0;// 100|200|201|202|500
                if (msg != null) {
                    st = new StringTokenizer(msg, "#");
                    protocol = Integer.parseInt(st.nextToken());// 100
                }
                switch (protocol) {
                    case Protocol.MESSAGE: {
                        String nickName = st.nextToken();
                        String message = st.nextToken();
                        broadCasting(Protocol.MESSAGE + Protocol.separator + nickName + Protocol.separator + message);
                    }
                        break;
                    case Protocol.WHISPER: {
                        String nickName = st.nextToken();// 보내는 넘
                        // insert here - 받는 넘
                        String otherName = st.nextToken();// 보내는 넘
                        // 귓속말로 보내진 메시지
                        String msg1 = st.nextToken();
                        for (TalkServerThread2 cst : ts.globalList) {
                            if (otherName.equals(cst.chatName)) {
                                cst.send(Protocol.WHISPER + Protocol.separator + nickName + Protocol.separator
                                        + otherName
                                        + Protocol.separator + msg1);
                                break;
                            }
                        } // end of for
                        this.send(Protocol.WHISPER + Protocol.separator + nickName + Protocol.separator + otherName
                                + Protocol.separator + msg1);
                    }
                        break;
                    case Protocol.CHANGE: {
                        String nickName = st.nextToken();
                        String afterName = st.nextToken();
                        String message = st.nextToken();
                        this.chatName = afterName;
                        broadCasting(Protocol.CHANGE + Protocol.separator + nickName + Protocol.separator + afterName
                                + Protocol.separator + message);
                    }
                        break;
                    case Protocol.TALK_OUT: {
                        String nickName = st.nextToken();
                        ts.globalList.remove(this);
                        broadCasting(Protocol.TALK_OUT + Protocol.separator + nickName);
                    }
                        break run_start;
                }///////////// end of switch
            } ///////////////// end of while
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}