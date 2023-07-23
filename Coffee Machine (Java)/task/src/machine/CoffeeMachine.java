package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int waterAmountAdded;
    static int milkAmountAdded;
    static int beansAmountAdded;
    static int cupsAmountAdded;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemainingList remainingList = new RemainingList();
        boolean run = true;

        while (run) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "buy":
                    implementBuy(scanner, remainingList);
                    break;
                case "fill":
                    implementFill(scanner, remainingList);
                    break;
                case "take":
                    implementTake(remainingList);
                    break;
                case "remaining":
                    implementRemaining(remainingList);
                    break;
                case "exit":
                    run = false;
                    break;
            }
        }
    }


    private static void implementBuy(Scanner scanner, RemainingList remainingList) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeOptionNumber = scanner.nextLine();

        if (coffeeOptionNumber.equals("back")) {
            return; // If the user chooses "back," simply return without making a purchase.
        }

        // Get the selected CoffeeOption based on the user's input.
        CoffeeOption selectedOption = getCoffeeOption(coffeeOptionNumber);

        if (selectedOption != null) {
            // Check if there are enough resources to make the selected coffee.
            if (isEnoughResources(remainingList, selectedOption)) {
                createCoffeeOption(remainingList, coffeeOptionNumber);
                System.out.println("I have enough resources, making you a coffee!\n");
            } else {
                System.out.println("Sorry, not enough resources!\n");
            }
        } else {
            System.out.println("Invalid input. Please try again.\n");
        }
    }

    private static CoffeeOption getCoffeeOption(String coffeeOptionNumber) {
        int optionNumber = Integer.parseInt(coffeeOptionNumber);
        switch (optionNumber) {
            case 1:
                return CoffeeOption.ESPRESSO;
            case 2:
                return CoffeeOption.LATTE;
            case 3:
                return CoffeeOption.CAPPUCCINO;
            default:
                return null;
        }
    }

    private static boolean isEnoughResources(RemainingList remainingList, CoffeeOption coffeeOption) {
        return remainingList.getWaterRemaining() >= coffeeOption.getWater() &&
                remainingList.getMilkRemaining() >= coffeeOption.getMilk() &&
                remainingList.getBeansRemaining() >= coffeeOption.getBeans() &&
                remainingList.getCupsRemaining() >= coffeeOption.getCups();
    }


    private static void createCoffeeOption(RemainingList remainingList, String coffeeOptionNumber) {
        switch (coffeeOptionNumber) {
            case "1":
                remainingList.setWaterRemaining(remainingList.getWaterRemaining() - CoffeeOption.ESPRESSO.getWater());
                remainingList.setMilkRemaining(remainingList.getMilkRemaining() - CoffeeOption.ESPRESSO.getMilk());
                remainingList.setBeansRemaining(remainingList.getBeansRemaining() - CoffeeOption.ESPRESSO.getBeans());
                remainingList.setCupsRemaining(remainingList.getCupsRemaining() - CoffeeOption.ESPRESSO.getCups());
                remainingList.setMoneyRemaining(remainingList.getMoneyRemaining() + CoffeeOption.ESPRESSO.getCost());
                break;
            case "2":
                remainingList.setWaterRemaining(remainingList.getWaterRemaining() - CoffeeOption.LATTE.getWater());
                remainingList.setMilkRemaining(remainingList.getMilkRemaining() - CoffeeOption.LATTE.getMilk());
                remainingList.setBeansRemaining(remainingList.getBeansRemaining() - CoffeeOption.LATTE.getBeans());
                remainingList.setCupsRemaining(remainingList.getCupsRemaining() - CoffeeOption.LATTE.getCups());
                remainingList.setMoneyRemaining(remainingList.getMoneyRemaining() + CoffeeOption.LATTE.getCost());
                break;
            case "3":
                remainingList.setWaterRemaining(remainingList.getWaterRemaining() - CoffeeOption.CAPPUCCINO.getWater());
                remainingList.setMilkRemaining(remainingList.getMilkRemaining() - CoffeeOption.CAPPUCCINO.getMilk());
                remainingList.setBeansRemaining(remainingList.getBeansRemaining() - CoffeeOption.CAPPUCCINO.getBeans());
                remainingList.setCupsRemaining(remainingList.getCupsRemaining() - CoffeeOption.CAPPUCCINO.getCups());
                remainingList.setMoneyRemaining(remainingList.getMoneyRemaining() + CoffeeOption.CAPPUCCINO.getCost());
                break;
            case "back":
                break;
        }
    }

    private static void implementFill(Scanner scanner, RemainingList remainingList) {
        System.out.println("\nWrite how many ml of water you want to add:");
        waterAmountAdded = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkAmountAdded = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beansAmountAdded = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cupsAmountAdded = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("\n");

        calculateFillAmounts(waterAmountAdded, milkAmountAdded, beansAmountAdded, cupsAmountAdded, remainingList);
    }

    private static void calculateFillAmounts(int waterAmountAdded, int milkAmountAdded, int beansAmountAdded, int cupsAmountAdded, RemainingList remainingList) {
        remainingList.setWaterRemaining(remainingList.getWaterRemaining() + waterAmountAdded);
        remainingList.setMilkRemaining(remainingList.getMilkRemaining() + milkAmountAdded);
        remainingList.setBeansRemaining(remainingList.getBeansRemaining() + beansAmountAdded);
        remainingList.setCupsRemaining(remainingList.getCupsRemaining() + cupsAmountAdded);
    }

    private static void implementTake(RemainingList remainingList) {

        System.out.println("I gave you $" + remainingList.getMoneyRemaining() + "\n");
        remainingList.setMoneyRemaining(0);
    }

    public static void implementRemaining(RemainingList remainingList) {

        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", remainingList.getWaterRemaining(), remainingList.getMilkRemaining(), remainingList.getBeansRemaining(), remainingList.getCupsRemaining(), remainingList.getMoneyRemaining());
    }
}






