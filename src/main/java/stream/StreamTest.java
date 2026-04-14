package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest {
    static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "User1");
        map.put(2, "User2");
        map.put(3, "User3");
    }

    public static void main(String[] args) {
        map.forEach((k, v) -> System.out.println(k + " " + v)); //обход мапы уже не такой громоздкий

        List<String> list = new ArrayList<>();
        list.stream().filter("a"::equals); //одно и то же
        Stream.of(list).filter("a"::equals); //просто разные способы

        System.out.println("abc4".chars().count()); //вот, как можно быстро работать со строками

        int[] array = {3, 5};
        System.out.println(Arrays.stream(array).average()); //для массивов не нужно писать отдельных методов
        System.out.println(Arrays.stream(new int[0]).average()
                .orElseGet(() -> array[0]));

        Stream<Integer> numbers = Stream.iterate(0, n -> n + 10);
        numbers.forEach(integer -> System.out.println(integer)); // бесконечный стрим
        // сюда не дойдем, а то бы сломалось, т.к. стрим одноразовый
        numbers.limit(5).forEach(System.out::println); // 0, 10, 20, 30, 40

    }
}
