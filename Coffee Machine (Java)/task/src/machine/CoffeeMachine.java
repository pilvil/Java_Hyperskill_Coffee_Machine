package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static final int WATER_QTY_PER_CUP = 200;
    public static final int MILK_QTY_PER_CUP = 50;
    public static final int BEANS_QTY_PER_CUP = 15;

    static int waterAmountAvailable;
    static int milkAmountAvailable;
    static int BeansAmountAvailable;
    static int smallestCupQuantity;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        waterAmountAvailable = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkAmountAvailable = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        BeansAmountAvailable = scanner.nextInt();

        int extraCups = calculateAmounts();
        printResult(extraCups, smallestCupQuantity);
    }

    private static int calculateAmounts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();

        int waterCups = waterAmountAvailable / WATER_QTY_PER_CUP;
        int milkCups = milkAmountAvailable / MILK_QTY_PER_CUP;
        int beanCups = BeansAmountAvailable / BEANS_QTY_PER_CUP;

        smallestCupQuantity = waterCups;

        if (milkCups < smallestCupQuantity) {
            smallestCupQuantity = milkCups;
        }
        if (beanCups < smallestCupQuantity) {
            smallestCupQuantity = beanCups;
        }

        int extraCups = smallestCupQuantity - cupsOfCoffee;
        return extraCups;

    }

    private static void printResult(int extraCups, int smallestCupQuantity) {

        if (extraCups > 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else if (extraCups == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can make only " + smallestCupQuantity + " cup(s) of coffee");
        }
    }

}
