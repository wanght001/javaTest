package 初始化静态内部类和成员内部类;

public class StaticTest{
    public static void main(String[] args){
        // 初始化Bean1
        StaticTest test =new StaticTest();
        StaticTest.Bean1 bean1 =test.new Bean1();
        bean1.I++;
        // 初始化Bean2
        StaticTest.Bean2 bean2 = new StaticTest.Bean2();
        bean2.J++;
        //初始化Bean3
        Bean b = new Bean();
        Bean.Bean3 bean3  = b.new Bean3();
        bean3.k++;
    }
    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }
}