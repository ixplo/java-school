package builder;

public class AppleBuilder {
    private Apple apple;
    public AppleBuilder() {
        apple = new Apple();
    }

    public AppleBuilder setWeight(int weight) {
        apple.setWeight(weight);
        return this;
    }

    public AppleBuilder setCountry(String country) {
        apple.setCountry(country);
        return this;
    }

    public Apple build() {
        return apple;
    }
}
