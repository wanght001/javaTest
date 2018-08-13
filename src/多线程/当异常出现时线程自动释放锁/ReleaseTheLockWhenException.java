package 多线程.当异常出现时线程自动释放锁;

public class ReleaseTheLockWhenException {
    public static void main(String[] args) {
        Test test =new Test();

        ThreadOne threadOne =new ThreadOne(test);
        Thread thread1 =new Thread(threadOne);
        thread1.start();

        ThreadTwo threadTwo =new ThreadTwo(test);
        Thread thread2 =new Thread(threadTwo);
        thread2.start();
    }
}

class ThreadOne implements Runnable{
    private Test test;
    public ThreadOne(Test test) {
        this.test=test;
    }

    @Override
    public void run() {
        try {
            test.service1();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ThreadTwo implements Runnable{
    private Test test;

    public ThreadTwo(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.service2();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Test{
    //当异常出现时自动释放锁
    public synchronized void service1() throws InterruptedException{
        System.out.println("service1 begin");
        //人造异常
        {
            String a = null;
            a.toUpperCase();
        }
        System.out.println("service1 end");
    }
    public void service2() throws InterruptedException{
        System.out.println("service2 begin");
        Thread.sleep(1000);
        System.out.println("service2 end");
    }
}

