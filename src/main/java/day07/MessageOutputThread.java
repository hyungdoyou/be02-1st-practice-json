package day07;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MessageOutputThread extends Thread {
    Socket socket;

    public MessageOutputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            while(true) {
                for (int i = 0; i < ServerMain.clientList.size(); i++) {
                    Socket client = ServerMain.clientList.get(i);
                    OutputStream os = client.getOutputStream();
                    PrintStream ps = new PrintStream(os);

                    String clientmessage = sc.nextLine();
                    ps.println(clientmessage);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
