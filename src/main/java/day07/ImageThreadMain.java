package day07;

import java.io.*;
import java.net.Socket;

public class ImageThreadMain extends Thread {
    Socket socket;

    public ImageThreadMain(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 여기부터 받는 코드
        try {
            InputStream cis = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(cis);
            BufferedReader br = new BufferedReader(isr);

            String str = br.readLine();  // str : 고객이 입력한 파일명
            // 여기까지 받는 코드
            if(str.endsWith(".jpeg")) {

                // 여기부터 보내는 코드
                for(int i=0; i<ServerMain.clientList.size(); i++) {
                    Socket client = ServerMain.clientList.get(i);
                    OutputStream os = client.getOutputStream();
                    BufferedOutputStream brs = new BufferedOutputStream(os);

                    FileInputStream fileInputStream = new FileInputStream("c:\\test\\" + str);
                    byte[] bytes = fileInputStream.readAllBytes();
                    for(int j=0; j<bytes.length; j++) {
                        brs.write(bytes[j]);
                    }

                    //brs.close();
                }
                // 여기까지 보내는 코드
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
