package day06;

import java.io.*;

public class StreamMain3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=null;
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);  // BufferedInputStream : 보조 역할

        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream("c:\\test\\test01.txt");
            fileOutputStream = new FileOutputStream("c:\\test\\test02.txt");

            int data = 0;
            while ((data = bis.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("그런 파일 없음");
        } catch (IOException e) {
            System.out.println("읽을 수 없음");
        } finally {
            if(fileInputStream != null) {
                fileInputStream.close();
            }
            if(fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
