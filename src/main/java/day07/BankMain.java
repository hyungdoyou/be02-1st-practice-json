package day07;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();


        for(int i=0; i<10; i++) {
            Thread withdraw = new DepositThread(account);

            withdraw.start();
        }

        Thread.sleep(5000);
        System.out.println("마지막");
        account.check();
    }
}
