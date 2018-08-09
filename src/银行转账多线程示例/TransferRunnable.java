package 银行转账多线程示例;


public class TransferRunnable implements Runnable {


    private Bank bank;
    private int fromAccount = 0;
    private double maxAmount = 0;


    public TransferRunnable(Bank b, int fromAccount, double maxAmount) {
        this.bank = b;
        this.fromAccount = fromAccount;
        this.maxAmount = maxAmount;
    }


    @Override
    public void run() {
        double amount = maxAmount * Math.random();
        int toAccount = (int) ((int) bank.getAccountSize() * Math.random());
        bank.transfer(fromAccount, toAccount, amount);
        try {
            Thread.sleep((long) (100L * Math.random()));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}