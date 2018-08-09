package 银行转账多线程示例;
import java.util.concurrent.locks.Lock;

public class Bank {
    private final double[] accounts;

    //创建账户对象
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    //转账
    public  void  transfer(int from, int to, double amount) {
            if (accounts[from] < amount) {
                return;
            }
            synchronized(Bank.class) {
            accounts[from] -= amount;
            System.out.println(Thread.currentThread() + "转" + amount + " 从" + from + "号账户到" + to + "号账户");
            accounts[to] += amount;
            System.out.println("总钱数:" + getTotalBalance());
        }
    }

    public double getTotalBalance() {
        double sum = 0d;
        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i];
        }
        return sum;
    }

    public int getAccountSize() {
        return accounts.length;
    }
}
