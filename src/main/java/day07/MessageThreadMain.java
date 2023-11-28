package day07;

import java.io.*;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class MessageThreadMain extends Thread{
    Socket socket;

    public MessageThreadMain(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            //boolean flag = true;

            while(true) {
                String message = bir.readLine();
                if(message.endsWith(".jpeg")) {
                    // 여기부터 보내는 코드
                    OutputStream cos = socket.getOutputStream();
                    BufferedOutputStream brs = new BufferedOutputStream(cos);

                    FileInputStream fileInputStream = new FileInputStream("c:\\test\\" + message);
                    byte[] bytes = fileInputStream.readAllBytes();
                    for(int i=0; i<bytes.length; i++) {
                        brs.write(bytes[i]);
                        //System.out.println(bytes[i]);
                    }
                    //brs.close();

                    // 여기까지 보내는 코드
                }
                else {

                    System.out.println("고객이 서버로 보낸 메시지입니다 : " + message);
                    for (int i = 0; i < ServerMain.clientList.size(); i++) {
                        Socket client = ServerMain.clientList.get(i);
                        OutputStream os = client.getOutputStream();
                        PrintStream ps = new PrintStream(os);
                        ps.println(message);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
