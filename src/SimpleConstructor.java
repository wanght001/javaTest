public class SimpleConstructor {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            new Rock(i);

        c a = new c();
        System.out.println(a.i);
        a.count();
        System.out.println(a.i);
    }
}

class Rock {
    Rock(int i) {
        System.out.println(
                "Creating Rock number " + i);
    }
}

class c{
    int i;
    void count(){
        i=7;
    }
}