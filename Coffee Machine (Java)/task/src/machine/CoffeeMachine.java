package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static final int WATER_DEFAULT_QTY = 400;
    public static final int MILK_DEFAULT_QTY = 540;
    public static final int BEANS_DEFAULT_QTY = 120;
    public static final int CUPS_DEFAULT_QTY = 9;
    public static final int MONEY_DEFAULT_QTY = 550;

    static int waterAmountAdded;
    static int milkAmountAdded;
    static int beansAmountAdded;
    static int cupsAmountAdded;
    static int moneyAmountAdded;


    public static void main(String[] args) {
        System.out.println("""
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $550 of money\n""");

        System.out.println("Write action (buy, fill, take): ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "buy":
                int[] buyAmounts = implementBuy();
                printresult(buyAmounts);
                break;
            case "fill":
                int[] fillAmounts = implementFill();
                printresult(fillAmounts);
                break;
            case "take":
                printTakeResult();
                break;
        }

    }

    private static int[] implementBuy() {
        Scanner scanner = new Scanner(System.in);
        int[] filledAmounts = new int[5];
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeOptionNumber = scanner.nextInt();
        switch (coffeeOptionNumber) {
            case 1:
                filledAmounts[0] = WATER_DEFAULT_QTY - CoffeeOption.ESPRESSO.getWater();
                filledAmounts[1] = MILK_DEFAULT_QTY - CoffeeOption.ESPRESSO.getMilk();
                filledAmounts[2] = BEANS_DEFAULT_QTY - CoffeeOption.ESPRESSO.getBeans();
                filledAmounts[3] = CUPS_DEFAULT_QTY - CoffeeOption.ESPRESSO.getCups();
                filledAmounts[4] = MONEY_DEFAULT_QTY + CoffeeOption.ESPRESSO.getCost();
                break;
            case 2:
                filledAmounts[0] = WATER_DEFAULT_QTY - CoffeeOption.LATTE.getWater();
                filledAmounts[1] = MILK_DEFAULT_QTY - CoffeeOption.LATTE.getMilk();
                filledAmounts[2] = BEANS_DEFAULT_QTY - CoffeeOption.LATTE.getBeans();
                filledAmounts[3] = CUPS_DEFAULT_QTY - CoffeeOption.LATTE.getCups();
                filledAmounts[4] = MONEY_DEFAULT_QTY + CoffeeOption.LATTE.getCost();
                break;
            case 3:
                filledAmounts[0] = WATER_DEFAULT_QTY - CoffeeOption.CAPPUCCINO.getWater();
                filledAmounts[1] = MILK_DEFAULT_QTY - CoffeeOption.CAPPUCCINO.getMilk();
                filledAmounts[2] = BEANS_DEFAULT_QTY - CoffeeOption.CAPPUCCINO.getBeans();
                filledAmounts[3] = CUPS_DEFAULT_QTY - CoffeeOption.CAPPUCCINO.getCups();
                filledAmounts[4] = MONEY_DEFAULT_QTY + CoffeeOption.CAPPUCCINO.getCost();
                break;
        }
        return filledAmounts;
    }

    private static int[] implementFill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        waterAmountAdded = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkAmountAdded = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beansAmountAdded = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cupsAmountAdded = scanner.nextInt();
        moneyAmountAdded = 0;

        int[] calculatedFillAmounts = calculateFillAmounts(waterAmountAdded, milkAmountAdded, beansAmountAdded, cupsAmountAdded, moneyAmountAdded);
        return calculatedFillAmounts;
    }

    private static int[] calculateFillAmounts(int waterAmountAdded, int milkAmountAdded, int beansAmountAdded, int cupsAmountAdded, int moneyAmountAdded) {
        int[] filledAmounts = new int[5];
        filledAmounts[0] = WATER_DEFAULT_QTY + waterAmountAdded;
        filledAmounts[1] = MILK_DEFAULT_QTY + milkAmountAdded;
        filledAmounts[2] = BEANS_DEFAULT_QTY + beansAmountAdded;
        filledAmounts[3] = CUPS_DEFAULT_QTY + cupsAmountAdded;
        filledAmounts[4] = MONEY_DEFAULT_QTY + moneyAmountAdded;
        return filledAmounts;
    }

    private static void printresult(int[] printoutAmounts) {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money", printoutAmounts[0], printoutAmounts[1], printoutAmounts[2], printoutAmounts[3], printoutAmounts[4]);
    }

    private static void printTakeResult() {
        System.out.println("I gave you $550");
        System.out.println("");
        System.out.println("""
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $0 of money""");
    }

}






