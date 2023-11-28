package day06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            //Socket yhd = serverSocket.accept();
            Socket yhd = serverSocket.accept();

            System.out.println(yhd.getInetAddress() + " 주소를 사용하는 고객이 접속하였습니다.");


            // 여기서부터 보내는 코드
            System.out.print("고객에게 보낼 메시지를 입력하세요 : ");
            Scanner sc = new Scanner(System.in);
            OutputStream cos = yhd.getOutputStream();
            PrintStream ps = new PrintStream(cos);

            String test1 = sc.nextLine();
            ps.println(test1);
            //int test1 = sc.nextInt();
            //cos.write(test1);
            // 여기까지 보내는 코드

            System.out.println();

            // 여기서부터 받는 코드
            System.out.print("고객이 서버로 보낸 메시지입니다 : ");
            InputStream cis = yhd.getInputStream();
            InputStreamReader isr = new InputStreamReader(cis);
            BufferedReader br = new BufferedReader(isr);

            String str = br.readLine();
            System.out.println(str);

            //int num = cis.read();
            //System.out.println(num);
            // 여기까지 받는 코드

            serverSocket.close();
            yhd.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
