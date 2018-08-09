//: Leaf.java
// Simple use of the "this" keyword
public class Leaf {
    private int i = 0;
    Leaf increment() {
        i++;
        return this;
    }
    void print() {
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        Leaf x = new Leaf();
        //increment()通过this 关键字返回当前对象的句柄
        x.increment().increment().increment().print();
    }
}