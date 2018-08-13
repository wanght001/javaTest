package 多线程.改变同步位置增加效率;

import java.sql.Time;

/**
 *同步代来的效率低的问题
 */
public class ThreatOfSynch {

    public static void main(String[] args) throws InterruptedException{
        Test test =new Test();

        ThreadOne threadOne =new ThreadOne(test);
        Thread thread1 =new Thread(threadOne);
        ThreadTwo threadTwo =new ThreadTwo(test);
        Thread thread2 =new Thread(threadTwo);
        thread1.start();
        thread2.start();

        Thread.sleep(10000);
        System.out.println("总花费时间：" + validate.count());

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
            test.service();
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
            test.service();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Test {
    static void getData() throws InterruptedException {
        System.out.println("getData");
        Thread.sleep(1000);
    }
    //锁在其中一个方法入口 总花费4000s
    static void updateData() throws InterruptedException {//synchronized
        System.out.println("updateData");
        Thread.sleep(1000);
    }
    static void returnData() throws InterruptedException {
        System.out.println("returnData");
        Thread.sleep(1000);
    }
    //锁在总方法入口，共花费6000s
    public void service() throws InterruptedException {//synchronized
        long startTime = System.currentTimeMillis();
        if (validate.START_TIME==0){
            validate.START_TIME = System.currentTimeMillis();
        }
        getData();
        //调用方法时加上同步日志 花费4000s
        synchronized (this) {
            updateData();
        }
        returnData();
        long endTime = System.currentTimeMillis();
        System.out.println("线程名："+Thread.currentThread().getName()+" 花费时间："+(endTime-startTime));
        if(endTime>validate.END_TIME ) {
            validate.END_TIME= endTime;
        }
    }
}

class validate{
    public static long START_TIME=0;
    public static long END_TIME=0;

    public static long count(){
        return (END_TIME-START_TIME);
    }
}
