package day07;

public class DepositThread extends Thread{
    Account account;

    DepositThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized(account) {
            for (int i = 0; i < 1000; i++) {
                account.deposit(100);

            }
            account.check();
        }

    }
}