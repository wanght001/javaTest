package 多线程.锁的可重入性;

public class ReGetInTheLock {
    public static void main(String[] args) {
        MyTest myTest =new MyTest();
        for (int i=0;i<5;i++){
            ThreadOne threadOne =new ThreadOne(myTest);
            Thread thread =new Thread(threadOne);
            thread.start();
        }
    }
}

class ThreadOne implements Runnable{
    private MyTest myTest;
    public ThreadOne(MyTest myTest) {
        this.myTest = myTest;
    }

    @Override
    public void run() {
        myTest.service_1();
    }
}

class MyTest{
    //加sleep没加锁是乱序的 加了锁之后就是有序的了
    public synchronized void service_1(){
        System.out.println(Thread.currentThread().getName()+"service_1 begin");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service_2();
        System.out.println("service_1 end");
    }
    public void service_2(){
        System.out.println("service_2 begin");
        service_3();
        System.out.println("service_2 end");
    }
    public void service_3(){
        System.out.println("service_3 begin");
        System.out.println("service_3 end");

    }
}