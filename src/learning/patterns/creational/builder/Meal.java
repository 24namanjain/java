package learning.patterns.creational.builder;

import java.util.Objects;

public class Meal {

    // Private constructor
    private Meal(Builder builder) {
        this.burger = builder.burger;
        this.fries = builder.fries;
        this.drink = builder.drink;
    }

    // Required fields
    private final Burger burger;

    // Optional fields
    private final Fries fries;
    private final Drink drink;

    // static inner builder class
    public static class Builder {
        private Burger burger;
        private Fries fries;
        private Drink drink;

        public Builder burger(Burger burger) {  
            this.burger = Objects.requireNonNull(burger, "Burger cannot be null");
            return this;
        }

        public Builder fries(Fries fries) {
            this.fries = fries;
            return this;
        }

        public Builder drink(Drink drink) {
            this.drink = drink;
            return this;
        }

        public Meal build() {
            if (burger == null) {
                throw new IllegalStateException("Burger is required");
            }
            return new Meal(this);
        }
    }

    // to string
    @Override
    public String toString() {
        return "Meal{" +
                "burger=" + Objects.requireNonNullElse(burger, "Not specified") +
                ", fries=" + Objects.requireNonNullElse(fries, "Not specified") +
                ", drink=" + Objects.requireNonNullElse(drink, "Not specified") +
                '}';
    }

}
