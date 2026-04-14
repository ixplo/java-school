package oop;

public class MainClass {
    public static void main(String[] args) {
        Animal animal = new Elephant();
        animal.say();
        Animal animal1 = () -> System.out.println("lambda");
        animal1.say();
        ask(new Coder());
        ask(() -> System.out.println("Anonimus animal"));
    }

    static void ask(Animal animal) {
        System.out.println("начало");
        animal.say();
        System.out.println("конец");
    }
}
