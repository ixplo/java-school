package builder;

import java.util.Comparator;

public class Apple implements Comparable<Apple> {
    public Apple() {
    }

    public Apple(int weight, String country) {
        this.weight = weight;
        this.country = country;
    }

    int weight;
    String country;

    public int getWeight() {
        return weight;
    }

    public String getCountry() {
        return country;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int compareTo(Apple other) {
        return Comparator.comparing(Apple::getWeight).compare(this, other);
    }
}