package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static final int WATER_AMOUNT = 200;
    public static final int MILK_AMOUNT = 50;
    public static final int COFFEE_BEANS_AMOUNT = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();

        calculateAmounts(cupsOfCoffee);
    }

    private static void calculateAmounts(int cupsOfCoffee) {
        int amountOfWater = WATER_AMOUNT * cupsOfCoffee;
        int amountOfMilk = MILK_AMOUNT * cupsOfCoffee;
        int amountOfBeans = COFFEE_BEANS_AMOUNT * cupsOfCoffee;

        System.out.printf("For %d cups of coffee you will need:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans", cupsOfCoffee,amountOfWater, amountOfMilk, amountOfBeans);
    }
}
