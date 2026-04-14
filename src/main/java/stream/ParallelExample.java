package stream;

import metric.Execution;
import stream.support.Maths;
import stream.support.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static stream.support.Maths.factorial;
import static stream.support.Maths.fibonacci;

public class ParallelExample {
    final static int MAX_SIZE = 48;
    final static List<User> USERS = new ArrayList<User>() {{
        Stream.iterate(0, n -> n + 1)
                .limit(MAX_SIZE)
                .forEach(id -> add(new User("User" + id, id)));
    }};
    static List<Long> timings = new ArrayList<>();

    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);
        // не напечатается
        Execution execution = () -> System.out.println("Анонимный класс");

        // генерация с помощью stream чисел Фибоначчи
        List<Integer> fibo = Maths.generate(MAX_SIZE);
        System.out.println(fibo);

        // передаем в качестве лямбды результат выполнения метода
        execute(() -> USERS.forEach(printFactorial()));
        System.out.println("--- reverse");
        execute(() -> USERS.stream()
                .sorted(Collections.reverseOrder())
                .forEach(printFactorial()));

        System.out.println("--- fibonacci parallel stream calculating...");
        execute(() -> USERS.parallelStream().forEach(user -> fibonacci(user.getId())));
        System.out.println("--- fibonacci stream calculating...");
        execute(() -> USERS.stream().forEach(user -> fibonacci(user.getId())));
        System.out.println("--- fibonacci calculating...");
        execute(() -> {
            for (User user : USERS) {
                fibonacci(user.getId());
            }
        });
        timings.forEach(ParallelExample::print);
    }

    private static Consumer<User> printFactorial() {
        return user -> System.out.println(user.getName() + " factorial: " + factorial(user.getId()));
    }

    private static void print(long time) {
        System.out.println("Time, ms: " + time);
    }

    private static void execute(Execution logic) {
        long start = System.nanoTime();
        logic.apply();
        long stop = System.nanoTime();
        long time = (stop - start) / 1_000_000;
        timings.add(time);
    }

    public Stream<User> getUsers() {
        return USERS.stream();
    }
}

