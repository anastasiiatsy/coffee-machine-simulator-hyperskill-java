package org.anastasiia.tsygankova.coffee.machine.simulator;

public class Cappuccino extends Coffee {

    public int cost() {
        return 6;
    }

    public int id() {
        return 3;
    }

    public int waterNeeded() {
        return 200;
    }

    public int milkNeeded() {
        return 100;
    }

    public int coffeeNeeded() {
        return 12;
    }
}
