public class Test {

    class Person {

        public void say() {
            System.out.println("i am a person");
        }
    }

    class Man extends Person {

        @Override
        public void say() {
            System.out.println("i am a man");
        }
    }

    class Woman extends Person {

        @Override
        public void say() {
            System.out.println("i am a woman");
        }
    }

    public Person getType(Person person) {
        return person;
    }

    public static void main(String[] args) {
//        Person p  = new Test().new Person();
//        p.say();
//        Man m = new Test().new Man();
//        m.say();
//        Woman w = new Test().new Woman();
//        w.say();
        Person p  = new Test().getType(new Test().new Person());
        p.say();
        p = new Test().getType(new Test().new Man());
        p.say();
        p= new Test().getType(new Test().new Woman());
        p.say();
    }

}