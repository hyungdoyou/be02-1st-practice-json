package day07;

public class Account {
    int balance = 0;


    // balance읽어서 값을 더하고 저장, 여러 스레드가 동시에 작업하면 레이스 컨디션 상태가 됨
    // 실행 결과가 스레드 세이프 하지 않음
    // synchronized를 사용하면 여러 스레드가 동기화하면서 작업을 진행
    // synchronized는 락을 걸고 푸는 것, 상호 배체
    public synchronized void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void check() {
        System.out.println("현재 잔액은 " + this.balance + "원 입니다");
    }
}
