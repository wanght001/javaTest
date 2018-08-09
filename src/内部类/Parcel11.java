package 内部类;

public class Parcel11 {
    class Contents {
        private int i = 11;
        public int value() { return i; }
    }
    class Destination2 {
        private String label;
        Destination2(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
    public static void main(String[] args) {
        Parcel11 p = new Parcel11();
// Must use instance of outer class
// to create an instances of the inner class:
        Parcel11.Contents c = p.new Contents();
        System.out.println(c.value());
        Parcel11.Destination2 d =p.new Destination2("Tanzania");
        System.out.println(d.label);
    }
}