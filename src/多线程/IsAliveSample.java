package 多线程;


public class IsAliveSample {
    public static void main(String[] args) {
        ThreadFive threadFive = new ThreadFive();
        Thread thread = new Thread(threadFive);
        System.out.println("线程名:" + Thread.currentThread().getName());
        System.out.println("线程是否在运行:" + Thread.currentThread().isAlive());
        thread.setName("myThread");// 设置运行线程的名称
        threadFive.setName("threadFive");// 设置实例的名称
        threadFive.myTest();
        thread.start();
    }
}

class ThreadFive extends Thread {
    public void myTest() {
        show();
    }

    private void show() {
        System.out.println("----------begin----------");
        // 这里指的是执行这个线程的名称
        System.out.println("线程名:" + Thread.currentThread().getName());
        System.out.println("线程是否在运行:" + Thread.currentThread().isAlive());
        // this.getName指的是这个实例的名称
        // 由于是继承Thread，Thread本身可以设置名称
        System.out.println("实例名称:" + this.getName());
        System.out.println("实例是否在运行:" + this.isAlive());
        System.out.println("----------end----------");
    }

    @Override
    public void run() {
        super.run();
        show();
    }
}