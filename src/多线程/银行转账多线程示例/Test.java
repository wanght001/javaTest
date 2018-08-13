package 多线程.银行转账多线程示例;

public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank(100, 1000);
        for (int i = 0; i < 3; i++) {
            TransferRunnable transferRunnable = new TransferRunnable(bank, i,
                    1000);
            Thread thread1 = new Thread(transferRunnable);
            thread1.start();
        }
    }
}
