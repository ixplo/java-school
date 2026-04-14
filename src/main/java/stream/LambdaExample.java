package stream;

import java.util.UUID;
import java.util.function.Supplier;

public class LambdaExample {

    public LambdaExample() {
        System.out.println("New lambda");
    }

    public static void main(String[] args) {
        Supplier<Object> lambda = LambdaExample::new;
        getLambda(UUID::randomUUID);
        System.out.println("--------");
        getLambda(lambda);
    }

    private static void getLambda(Supplier<Object> lambda) {
        System.out.println("Начало метода");
        Object result = lambda.get();
        System.out.println(result);
        System.out.println("Конец метода");
    }

}
