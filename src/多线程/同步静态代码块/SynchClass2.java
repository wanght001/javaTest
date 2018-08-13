package 多线程.同步静态代码块;

public class SynchClass2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadThree threadThree = new ThreadThree();
        Thread thread = new Thread(threadThree);
        thread.start();
        ThreadFour threadFour = new ThreadFour();
        Thread thread2 = new Thread(threadFour);
        thread2.start();
    }
}

class ThreadThree implements Runnable {

    @Override
    public void run() {
        try {
            MyService2.updateA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadFour implements Runnable {

    @Override
    public void run() {
        try {
            MyService2.updateB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyService2 {
    private static int id = 0;

    public static void updateA() throws InterruptedException {
        //同步静态代码块，要用.class文件作为监视器
        synchronized (MyService2.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + id++);
                Thread.sleep(50);
            }
        }
    }

    public static void updateB() throws InterruptedException {
        synchronized (MyService2.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + id++);
                Thread.sleep(100);
            }
        }
    }

}