package day07;

import java.io.*;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class MessageThreadMain extends Thread {
    Socket socket;

    String id;

    public MessageThreadMain(String id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            String id = bir.readLine();
            System.out.println(id + "님이 입장하셨습니다.");
            ServerMain.socketMap.put(id, socket);

            while (true) {
                String message = bir.readLine();

                if (message.startsWith("to:")) {

                    String content = message.substring(message.indexOf(" ") + 1);
                    Socket client = ServerMain.socketMap.get(message.split(" ")[0].substring(3));

                    OutputStream os = client.getOutputStream();
                    PrintStream ps = new PrintStream(os);
                    ps.println("DM : " + content);

                } else if (message.endsWith(".jpg")) {
                    for (String key : ServerMain.socketMap.keySet()) {
                        if (id.equals(key)) {
                            continue;
                        }
                        Socket client = ServerMain.socketMap.get(key);
                        OutputStream os = client.getOutputStream();
                        //PrintStream ps = new PrintStream(os);
                        //ps.println(message);

                        BufferedOutputStream bos = new BufferedOutputStream(os);
                        FileInputStream fileInputStream = new FileInputStream("c:\\test\\" + message);

                        byte[] bytes = fileInputStream.readAllBytes();
                        for (int i = 0; i < bytes.length; i++) {
                            bos.write(bytes[i]);
                            //System.out.println(bytes[i]);
                        }

                        bos.flush();
                        fileInputStream.close();

                        // 여기까지 보내는 코드
                    }

                } else {
                        for (String key : ServerMain.socketMap.keySet()) {
                            if (id.equals(key)) {
                                continue;
                            }
                            Socket client = ServerMain.socketMap.get(key);
                            OutputStream os = client.getOutputStream();
                            PrintStream ps = new PrintStream(os);
                            ps.println(message);
                            System.out.println("고객이 서버로 보낸 메시지입니다 : " + message);
                        }
                    }
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
