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
            ServerSocket serverSocket = new ServerSocket(7777);

            Socket yhd = serverSocket.accept();

            System.out.println(yhd.getInetAddress() + " 주소를 사용하는 고객이 접속하였습니다.");

            // 여기서부터 받는 코드
            System.out.print("고객이 서버로 보낸 메시지입니다 : ");
            InputStream cis = yhd.getInputStream();
            InputStreamReader isr = new InputStreamReader(cis);
            BufferedReader br = new BufferedReader(isr);

            String str = br.readLine();  // str : 고객이 입력한 파일명
            System.out.println(str);
            // 여기까지 받는 코드

            System.out.println();

            //System.out.print("고객이 요청한 파일을 보내주세요 : ");
            // 여기서부터 보내는 코드
            //Scanner sc = new Scanner(System.in);
            //OutputStream cos = yhd.getOutputStream();
            //PrintStream ps = new PrintStream(cos);

            //String test1 = sc.nextLine();
            //ps.println(test1);

            FileInputStream fileInputStream = new FileInputStream("c:\\test\\" + str);
            BufferedOutputStream brs = new BufferedOutputStream(yhd.getOutputStream());
            byte[] bytes = fileInputStream.readAllBytes();
            for(int i=0; i<bytes.length; i++) {
                brs.write(bytes[i]);
                System.out.print((char)bytes[i]);
            }
            // 여기까지 보내는 코드

            serverSocket.close();
            yhd.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
