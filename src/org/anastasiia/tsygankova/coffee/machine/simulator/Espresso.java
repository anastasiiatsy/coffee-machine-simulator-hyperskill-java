package org.anastasiia.tsygankova.coffee.machine.simulator;

public class Espresso extends Coffee {

    public int cost() {
        return 4;
    }

    public int id() {
        return 1;
    }

    public int waterNeeded() {
        return 250;
    }

    public int milkNeeded() {
        return 0;
    }

    public int coffeeNeeded() {
        return 16;
    }
}
