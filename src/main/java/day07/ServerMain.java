package day07;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 메인 서버 클래스 생성
public class ServerMain {
    // clientList를 다른 클래스에서 접근 가능토록 static으로 선언해줌
    static Map<String, Socket> socketMap = new HashMap<String, Socket>();

    public static void main(String[] args) throws IOException {
        try {
            // 서버 소켓 생성
            int port = 6666;
            ServerSocket serverSocket = new ServerSocket(port);

            // 클라이언트 소켓들을 저장할 수 있는 리스트 생성

            while(true) {
                Socket socket = serverSocket.accept();

                Thread message = new MessageThreadMain("id", socket);
                message.start();
            }
            // 클라이언트 메시지 처리 스레드

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
