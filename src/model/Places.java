package model;

import java.util.*;

public class Places {
    private Random r = new Random();

    private String name;
    private int openHour;
    private int closeHour;
    private int discount;

    private LinkedList<Item> itemsToSell = new LinkedList<>();

    public Places(String name, LinkedList<Item> itemsToSell, int currentHour) {
        this.name = name;
        this.openHour = r.nextInt(7, 11);
        this.closeHour = r.nextInt(20, 24);
        this.itemsToSell = itemsToSell;
    }
    public boolean checkIfIsOpen(int currentHour){
        return currentHour <= closeHour && currentHour >= openHour;
    }
    public String getName() {
        return name;
    }
    public void RandomizeItem(){

    }
}
