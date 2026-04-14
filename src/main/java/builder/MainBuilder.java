package builder;

public class MainBuilder {
    public static void main(String[] args) {
        Apple apple = new AppleBuilder()
                .setWeight(200)
                .setCountry("RU")
                .build();
    }
}
