package day07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 메인 서버 클래스 생성
public class ServerMain {
    // clientList를 다른 클래스에서 접근 가능토록 static으로 선언해줌
    static List<Socket> clientList = new ArrayList<Socket>();
    static List<String> clientId = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        try {
            // 서버 소켓 생성(포트 번호 : 7777)
            int port = 5555;
            ServerSocket serverSocket = new ServerSocket(port);

            // 클라이언트 소켓들을 저장할 수 있는 리스트 생성

            while(true) {
                Socket socket = serverSocket.accept();
                clientList.add(socket);

                System.out.println("Connected Clients: " + clientList);

                Thread message = new MessageThreadMain(socket);
                message.start();

                Thread image = new ImageThreadMain(socket);
                image.start();
            }
            // 클라이언트 메시지 처리 스레드

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
