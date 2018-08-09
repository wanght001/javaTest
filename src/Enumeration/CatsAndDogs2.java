package Enumeration;


import java.util.*;

class Cat2 {
    private int catNumber;
    Cat2(int i) {
        catNumber = i;
    }
    void print() {
        System.out.println("Cat number " +catNumber);
    }
}
class Dog2 {
    private int dogNumber;
    Dog2(int i) {
        dogNumber = i;
    }
    void print() {
        System.out.println("Dog number " +dogNumber);
    }
}
public class CatsAndDogs2 {
    public static void main(String[] args) {
        Vector a = new Vector();
        a.addElement(new Dog2(0));
        for(int i = 1; i < 7; i++)
            a.addElement(new Cat2(i));
// Not a problem to add a dog to cats:
        Enumeration e = a.elements();
        while(e.hasMoreElements())
            ((Dog2)e.nextElement()).print();
// Dog is detected only at run-time
    }
}