package stream;

import builder.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Apple> numbers = new ArrayList<>();
        numbers.add(new Apple(200, "RU"));
        numbers.add(new Apple(150, "BE"));
        numbers.add(new Apple(250, "UA"));
        numbers.add(new Apple(100, "EU"));
        numbers.add(new Apple(200, "EU"));

        numbers.forEach(apple -> System.out.println(apple.getWeight() + " " + apple.getCountry()));
        System.out.println("------------");
        numbers.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));
        numbers.forEach(apple -> System.out.println(apple.getWeight() + " " + apple.getCountry()));

    }

}
