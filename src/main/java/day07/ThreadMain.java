package day07;

public class ThreadMain {

    // 여러 스레드를 이용해서 동시에 여러 작업을 수행
    // 장점 : 작업 속도가 빨라진다. 비동기 작업이 가능하다.
    // 단점 : 문맥 교환(Context Switch) 이 많이 발생하면 오히려 작업속도가 느려질 수 있다.
    //       동기화가 어려워진다, 스레드를 세이프(차례대로 실행했을때의 결과와 동시에 실행했을때의 결과가 같은 것) 하지 않을 수 있다.
    //       여러 스레드가 동시에 작업하면 ? 레이스 컨디션 상태 라고 한다.
    // 스레드 세이프하게 하려면? synchronized 를 달아준다.
    // 하지만 이것을 사용한다는 것은 한 스레드에서 작업중이면 그것을 잠궈놓아서 다른쪽에서 읽지 못하도록 하는 설정이다. (상호 배제)
    // 따라서, 오히려 동시에 작업하는 것도 아니고, 작업이 늘어나는것(잠구는 작업, 잠금해제방법) 이지만 어쩔 수 없다.

    public static void main(String[] args) {
        // 스레드 객체 생성
        Thread thread01 = new Thread01(); // 다형성

        // start() 메서드로 스레드를 실행하고, 스레드 안에 run() 을 실행토록 함
        thread01.start();

        // 러너블 스레드 생성
        Runnable runnable02 = new Thread02(); // 다형성
        Thread thread02 = new Thread(runnable02);
        thread02.start();

        // 메인 스레드와 새로운 스레드가 동시에 작업을 처리함
        for(int i=0; i<10000; i++) {
            System.out.println("메인 스레드에서 실행 : " + i);
        }
    }
}
