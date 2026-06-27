package learning.patterns.creational.builder;

public class MainApp {
    
    public static void main(String[] args) {
        
        Meal meal = new Meal.Builder()
            .burger(Burger.VEG)
            .fries(Fries.FRENCH_FRIES)
            .drink(Drink.COKE)
            .build();

        System.out.println(meal);

        meal = new Meal.Builder()
            .burger(Burger.HAMBURGER)
            .fries(Fries.POTATO_FRIES)
            .drink(Drink.ICE_TEA)
            .build();

        System.out.println(meal);
        
        meal = new Meal.Builder()
            .burger(Burger.CHEESEBURGER)
            .fries(Fries.ONION_FRIES)
            .drink(Drink.WATER)
            .build();

        System.out.println(meal);

        meal = new Meal.Builder()
            .burger(Burger.VEG)
            .build();

        System.out.println(meal);

        meal = new Meal.Builder()
            .burger(Burger.VEG)
            .fries(Fries.FRENCH_FRIES)
            .build();

        System.out.println(meal);
        
        meal = new Meal.Builder()
            .burger(Burger.VEG)
            .fries(Fries.FRENCH_FRIES)
            .drink(Drink.COKE)
            .build();

        System.out.println(meal);
        
        meal = new Meal.Builder()
            .burger(Burger.VEG)
            .fries(Fries.FRENCH_FRIES)
            .drink(Drink.COKE)
            .build();

        System.out.println(meal);
        
        
    }
    
}
