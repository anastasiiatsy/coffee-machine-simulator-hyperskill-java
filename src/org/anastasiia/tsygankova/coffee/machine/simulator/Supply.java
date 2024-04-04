package org.anastasiia.tsygankova.coffee.machine.simulator;

public class Supply {

    private int water;
    private int milk;
    private int coffee;
    private int money;
    private int cups;

    public int getMoney() {
        return money;
    }

    public int getCups() {
        return cups;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk =milk;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public boolean hasEnoughWater(int neededQty) {
        if (water < neededQty) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        return true;
    }

    public boolean hasEnoughMilk(int neededQty) {
        if (milk < neededQty) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        return true;
    }

    public boolean hasEnoughCoffee(int neededQty) {
        if (coffee < neededQty) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        return true;
    }

    public boolean checkSupply(Coffee coffee) {
        boolean hasEnoughWater = hasEnoughWater(coffee.waterNeeded());
        boolean hasEnoughMilk = hasEnoughMilk(coffee.milkNeeded());
        boolean hasEnoughCoffee = hasEnoughCoffee(coffee.coffeeNeeded());
        if (hasEnoughCoffee && hasEnoughWater && hasEnoughMilk) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
        return false;
    }

    public void updateSupply(Coffee coffee) {
        setWater(getWater() - coffee.waterNeeded());
        setMilk(getMilk() - coffee.milkNeeded());
        setCoffee(getCoffee() - coffee.coffeeNeeded());
        setMoney(getMoney() + coffee.cost());
        setCups(getCups() - 1);
    }
}
