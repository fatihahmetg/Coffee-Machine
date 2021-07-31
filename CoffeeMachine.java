package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static Scanner sc = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static boolean exit = false;

    public static void main(String[] args) {
        while (exit == false) {
            action();
        }
    }

    public static void action() {
        String action = sc.next();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                exit();
                break;
        }
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String variety = sc.next();
        switch (variety) {
            case "1":
                if (cups > 0 && water >= 250 && coffeeBeans >= 16) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    cups--;
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                } else {
                    System.out.println("Sorry");
                }
                break;
            case "2":
                if (cups > 0 && water >= 350 && milk >= 75 && coffeeBeans >= 20) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    cups--;
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                } else {
                    System.out.println("Sorry");
                }
                break;
            case "3":
                if (cups > 0 && water >= 200 && milk >= 100 && coffeeBeans >= 12) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    cups--;
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                } else {
                    System.out.println("Sorry");
                }
                break;
            case "back":
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += sc.nextInt();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void exit() {
        exit = true;
    }

    public static void calculate() {
        int waterCounter = water;
        int milkCounter = milk;
        int coffeeBeansCounter = coffeeBeans;
        int cupCounter = 0;

        while (200 * (cupCounter + 1) <= waterCounter && 50 * (cupCounter + 1) <= milkCounter && 15 * (cupCounter + 1) <= coffeeBeansCounter) {
            cupCounter++;
        }

        if (cupCounter == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupCounter > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (cupCounter - 1) + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupCounter + " cup(s) of coffee");
        }
    }

}

/*
       "System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
*/
