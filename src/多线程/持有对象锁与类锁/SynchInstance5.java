package 多线程.持有对象锁与类锁;

public class SynchInstance5 {
    public static void main(String[] args)throws InterruptedException {
        testnum testnum =new testnum();
        for (int i=0; i<2;i++) {
            ThreadFive threadFive = new ThreadFive(testnum);
            Thread thread = new Thread(threadFive);
            thread.start();
        }
    }
}

class ThreadFive implements Runnable{
    private int j=2;
    private testnum testnum;

    public ThreadFive(testnum testnum) {
        this.testnum = new testnum();
    }

    @Override
    public void run() {
        while (j>0){
            try {
                if (j % 2 == 0) {
                    testnum.test1();
                } else {
                    testnum.test2();
                }
                j--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class testnum{
    //对象锁
    public synchronized void test1() throws InterruptedException {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " test1 " +i);
            Thread.sleep(100);
        }
    }
    //类锁
    public synchronized void test2() throws InterruptedException{
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " test2 " +i);
            Thread.sleep(100);
        }
    }
}