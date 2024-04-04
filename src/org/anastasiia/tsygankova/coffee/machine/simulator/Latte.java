package org.anastasiia.tsygankova.coffee.machine.simulator;

public class Latte extends Coffee {

    public int cost() {
        return 7;
    }

    public int id() {
        return 2;
    }

    public int waterNeeded() {
        return 350;
    }


    public int milkNeeded() {
        return 75;
    }

    public int coffeeNeeded() {
        return 20;
    }
}
