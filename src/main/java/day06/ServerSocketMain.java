package day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {
    public static void main(String[] args) {
        // 소켓은 서버 소켓과 클라이언트 소켓 2가지가 있다.
        try {
            // 포트를 LISTEN 상태로 변경 ( 왜? 라고 묻는다면 ServerSocket 클래스를 만든 사람이 그렇게 만들었기 때문이다. 이걸 파헤치려면 한참 걸린다 그냥 받아들여라)
            ServerSocket serverSocket = new ServerSocket(9999);   // 서버

            Socket clientSocket = serverSocket.accept();  // 클라이언트
            // 디버깅 해보고 cmd 창에서 netstat -ano | find "9999" 해보면 9999 포트가 리스닝으로 변경된 것을 확인할 수 있다.

            System.out.println(clientSocket.getInetAddress() + " 접속함");

            InputStream cis = clientSocket.getInputStream();

            int num = cis.read();
            System.out.println(num);

            OutputStream cos = clientSocket.getOutputStream();
            cos.write(200);

            serverSocket.close();
            clientSocket.close();

        } catch (IOException e) {  // 스트림 관련된 것들은 입출력에 대한 예외처리가 필요하다.
            throw new RuntimeException(e);
        }
    }
}
