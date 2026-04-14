package lambda;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        Consumer<String> anotherConsumer = s -> System.out.println(s);
        Consumer<String> anotherOtherConsumer = s -> {
            System.out.println(s);
        };
        Consumer<String> otherConsumer = s -> {
            System.out.println(s);
            System.out.println();
        }; // почему здесь точка с запятой?
        Consumer<String> lastConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        // все consumer одинаковые, кроме третьего
        run(anotherConsumer);
    }

    static void run(Consumer<String> function) {
        function.accept("test");
    }
}
