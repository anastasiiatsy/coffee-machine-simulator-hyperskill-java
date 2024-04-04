package org.anastasiia.tsygankova.coffee.machine.simulator;

import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scanner;
    private Supply supply;
    private Coffee coffee;

    public CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.supply = new Supply();
    }

    public void printInfo() {
        System.out.println("The coffee machine has:");
        System.out.println(supply.getWater() + " ml of water");
        System.out.println(supply.getMilk() + " ml of milk");
        System.out.println(supply.getCoffee() + " g of coffee beans");
        System.out.println(supply.getCups() + " disposable cups");
        System.out.println("$" + supply.getMoney() + " of money");
        System.out.println("");
    }

    public void initiateMachine() {

        supply.setWater(400);
        supply.setMilk(540);
        supply.setCoffee(120);
        supply.setCups(9);
        supply.setMoney(550);

        while (true) {
            String action = selectAction();

            if (action.equals("exit")) {
                System.exit(-1);
            }else if (action.equals("buy")) {
                buy();
            } else if (action.equals("fill")) {
                fill();
            } else if (action.equals("take")) {
                take();
            } else if (action.equals("remaining")) {
                printInfo();
            }
        }
    }

    public String selectAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        System.out.print("> ");
        return scanner.next();
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        System.out.print("> ");
        String input = scanner.next();
        if (input.equals("back")) {
            return;
        } else {
        prepare(Integer.valueOf(input));
        System.out.println("");
        }
    }

    public void prepare(int coffeeType) {
        if (coffeeType == 1) {
            coffee = new Espresso();
            if (supply.checkSupply(coffee)) {
                supply.updateSupply(coffee);
            }
        } else if (coffeeType == 2) {
            coffee = new Latte();
            if (supply.checkSupply(coffee)) {
                supply.updateSupply(coffee);
            }
        } else if (coffeeType == 3) {
            coffee = new Cappuccino();
            if (supply.checkSupply(coffee)) {
                supply.updateSupply(coffee);
            }
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        System.out.print("> ");
        supply.setWater(supply.getWater() + scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add: ");
        System.out.print("> ");
        supply.setMilk(supply.getMilk() + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        System.out.print("> ");
        supply.setCoffee(supply.getCoffee() + scanner.nextInt());
        System.out.println("Write how many disposable cups you want to add: ");
        System.out.print("> ");
        supply.setCups(supply.getCups() + scanner.nextInt());
    }

    public void take() {
        System.out.println("I gave you $"  + supply.getMoney());
        System.out.println("");
        supply.setMoney(0);
    }
}
