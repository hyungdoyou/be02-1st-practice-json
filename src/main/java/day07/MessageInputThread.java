package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageInputThread extends Thread {
    Socket socket;

    public MessageInputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            while(true) {
                String message = bir.readLine();
                System.out.println("고객이 서버로 보낸 메시지입니다 : " + message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
