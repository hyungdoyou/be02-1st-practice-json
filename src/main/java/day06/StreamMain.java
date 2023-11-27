package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamMain {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream("c:\\test\\test01.txt");
            fileOutputStream = new FileOutputStream("c:\\test\\test02.txt");  // test01 파일을 복사한 test02 파일 생성 (그림파일도 복사 가능)

            //FileInputStream fileInputStream = new FileInputStream("c:\\test\\pic01.png");
            //FileOutputStream fileOutputStream = new FileOutputStream("c:\\test\\pic02.png");

            // 이 내용은 사용자가 사진을 업로드하고 싶을때 활용이 가능하다

            // 파일 복사
//            byte[] bytes = fileInputStream.readAllBytes();
//            for(int i=0; i<bytes.length; i++) {
//                fileOutputStream.write(bytes[i]);
//            }
            // 한글 깨짐 확인
            int data = 0;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("그런 파일 없음");
        } catch (IOException e) {
            System.out.println("읽을 수 없음");
        } finally {
            if(fileInputStream != null) {
                fileInputStream.close();    // 스트림을 열었으면 무조건 닫아줘야된다.
            }
            if(fileOutputStream != null) {
                fileOutputStream.close();   // 스트림을 열었으면 무조건 닫아줘야된다.
            }
        }
    }
}
