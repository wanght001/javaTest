package 多线程.局部变量与实例变量的线程安全;

public class ThreadSafeOfLocalVariable {
    public static void main(String[] args){
        ThreadOne threadOne = new ThreadOne();
        for(int i=0;i<5;i++){
            Thread t =new Thread(threadOne);
            t.start();
        }
    }
}

class ThreadOne implements Runnable{
    //private int count = 5; 实例变量，加上同步标识符会有序
    @Override
    public void run() {
        int count=5; //局部变量
        for (int i=0;i<5;i++)
            System.out.println("当前线程："+Thread.currentThread()+"   count = "+count--);
    }
}
