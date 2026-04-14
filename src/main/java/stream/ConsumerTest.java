package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Consumer<String> stringConsumer = x -> {
            System.out.println(list);
            System.out.println("xxx");
        };
        Consumer<String> classConsumer = new ConsumerImpl();
        print("Hello", stringConsumer);
        print("Hello", classConsumer);
        print("Hello", string -> System.out.println("Lambda " + string));
    }

    private static int getNumber() {
            return 0;
    }

    private static void print(String text, Consumer<String> consumer) {
        consumer.accept(text);
    }
}
