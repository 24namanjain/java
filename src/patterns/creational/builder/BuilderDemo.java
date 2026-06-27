package patterns.creational.builder;

import core.DemoRunner;
import core.FeatureDemo;
import core.JavaLogger;

public class BuilderDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new BuilderDemo());
    }

    @Override
    public void run() {
        Meal meal = new Meal.Builder()
                .burger(Burger.VEG)
                .fries(Fries.FRENCH_FRIES)
                .drink(Drink.COKE)
                .build();

        JavaLogger.INSTANCE.info(meal.toString());

        meal = new Meal.Builder()
                .burger(Burger.HAMBURGER)
                .fries(Fries.POTATO_FRIES)
                .drink(Drink.ICE_TEA)
                .build();

        JavaLogger.INSTANCE.info(meal.toString());

        meal = new Meal.Builder()
                .burger(Burger.CHEESEBURGER)
                .fries(Fries.ONION_FRIES)
                .drink(Drink.WATER)
                .build();

        JavaLogger.INSTANCE.info(meal.toString());

        meal = new Meal.Builder()
                .burger(Burger.VEG)
                .build();

        JavaLogger.INSTANCE.info(meal.toString());

        meal = new Meal.Builder()
                .burger(Burger.VEG)
                .fries(Fries.FRENCH_FRIES)
                .build();

        JavaLogger.INSTANCE.info(meal.toString());

        meal = new Meal.Builder()
                .burger(Burger.VEG)
                .fries(Fries.FRENCH_FRIES)
                .drink(Drink.COKE)
                .build();

        JavaLogger.INSTANCE.info(meal.toString());
    }
}
