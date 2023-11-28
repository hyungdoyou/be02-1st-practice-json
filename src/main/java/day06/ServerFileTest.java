package day06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ServerFileTest {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            Socket yhd = serverSocket.accept();

            System.out.println(yhd.getInetAddress() + " 주소를 사용하는 고객이 접속하였습니다.");

            // 여기부터 받는 코드
            System.out.print("고객이 서버로 보낸 메시지입니다 : ");
            InputStream cis = yhd.getInputStream();
            InputStreamReader isr = new InputStreamReader(cis);
            BufferedReader br = new BufferedReader(isr);

            String str = br.readLine();  // str : 고객이 입력한 파일명
            System.out.println(str);
            // 여기까지 받는 코드

            System.out.println();

            // 여기부터 보내는 코드
            OutputStream cos = yhd.getOutputStream();
            BufferedOutputStream brs = new BufferedOutputStream(cos);

            FileInputStream fileInputStream = new FileInputStream("c:\\test\\" + str);
            byte[] bytes = fileInputStream.readAllBytes();
            for(int i=0; i<bytes.length; i++) {
                brs.write(bytes[i]);
                //System.out.println(bytes[i]);
            }
            // 여기까지 보내는 코드

            brs.close(); // 스트림을 안닫아주면 파일이 언제 끝나는지 알 수 없기 때문에 서버에서는 계속 받으려고만 한다.
            br.close();

            serverSocket.close();
            yhd.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
