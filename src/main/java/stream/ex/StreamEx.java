package stream.ex;

import builder.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(200, "RU"));
        apples.add(new Apple(150, "BE"));
        apples.add(new Apple(250, "UA"));
        apples.add(new Apple(100, "EU"));
        apples.add(new Apple(200, "EU"));

        Stream<Apple> appleStream = apples.stream();
        List<Apple> sortedApples = appleStream
                .sorted((o1, o2) -> o2.getWeight() - o1.getWeight())
                .collect(Collectors.toList());
        System.out.println(sortedApples);
        long count = sortedApples.stream().count();
        System.out.println(count);
    }
}
