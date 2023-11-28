package day07;

public class Thread02 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            System.out.println("새로운 스레드2 에서 실행 : " + i);
        }
    }
}
