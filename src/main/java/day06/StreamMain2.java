package day06;

import java.io.*;

public class StreamMain2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;  // 이전꺼는 파일을 바이트 단위로 읽고 한글이 읽히지 않으나, Reader 는 글자 단위로 읽고 한글도 읽힘
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("c:\\test\\test01.txt");
            fileWriter = new FileWriter("c:\\test\\test02.txt");

            //FileInputStream fileInputStream = new FileInputStream("c:\\test\\pic01.png");
            //FileOutputStream fileOutputStream = new FileOutputStream("c:\\test\\pic02.png");

            // 이 내용은 사용자가 사진을 업로드하고 싶을때 활용이 가능하다

            int data = 0;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("그런 파일 없음");
        } catch (IOException e) {
            System.out.println("읽을 수 없음");
        } finally {
            if(fileReader != null) {
                fileReader.close();    // 스트림을 열었으면 무조건 닫아줘야된다.
            }
            if(fileWriter != null) {
                fileWriter.close();   // 스트림을 열었으면 무조건 닫아줘야된다.
            }
        }
    }
}
