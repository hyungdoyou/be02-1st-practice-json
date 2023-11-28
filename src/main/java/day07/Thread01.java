package day07;

// 자바에서 스레드를 만들기 위한 방법
// 1. Thread 클래스를 상속받아서 구현
// 2. Runnable 인터페이스를 구현해서 사용
public class Thread01 extends Thread {
    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            System.out.println("새로운 스레드에서 실행 : " + i);
        }
    }
}
