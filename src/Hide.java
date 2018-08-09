public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1); // doh(float)
        b.doh('x');//doh(char)
        b.doh(1.0f); // doh(float)
        b.doh(new Milhouse());
    }
}

class Homer{
    char doh(char c){
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f){
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends  Homer{
    void doh(Milhouse m){
    }
}