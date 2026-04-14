package stream.support;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Maths {
    public static long factorial(long n) {
        return LongStream
                .rangeClosed(2, n)
                .reduce(1, (x, y) -> x * y);
    }

    public static long fibonacci(long n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static List<Integer> generate(int series) {
        return Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(series)
                .map(i -> i[0])
                .collect(toList());
    }
}
