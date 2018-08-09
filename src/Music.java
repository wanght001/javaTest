class Note{
    private int value;
    private Note(int val){
        value = val;
    }
    public static final Note middleC = new Note(0), cSharp = new Note(1), cFlat = new Note(2);
}

class Instrument{
    public void play(Note n){
        System.out.println("Instrument.play()");
    }
}

class Wind extends Instrument{
    public void play(Note n){
        System.out.println("Wind.play()");
    }
}
public class Music {
    public static void tune(Instrument i){
        i.play(Note.cSharp);
    }
    public static void main(String args[]){
        Wind flute = new Wind();
        tune(flute);//原方法tune中的参数应该是一个Instrument类型的，现在用它的子类的对象flute作为方法tune的参数。说明对象flute发生了句柄的转换，转换成了超类Instrument的句柄。
    }
}