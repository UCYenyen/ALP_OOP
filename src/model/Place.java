package model;

import java.util.*;

public class Place {
    private Random r = new Random();

    private String name;
    private int openHour;
    private int closeHour;
    private Item[] itemsToSell = new Item[10];
    private int travelDuration;

    public Place(String name, Item[] itemsToSell, int travelDuration) {
        this.name = name;
        this.openHour = r.nextInt(7, 11);
        this.closeHour = r.nextInt(20, 24);
        this.itemsToSell = itemsToSell;
        this.travelDuration = travelDuration;
    }

    public boolean checkIfIsOpen(int currentHour){
        return currentHour <= closeHour && currentHour >= openHour;
    }

    public String getName() {
        return name;
    }

    public int getOpenHour() {
        return openHour;
    }

    public int getCloseHour() {
        return closeHour;
    }

    public Item[] getItemsToSell() {
        return itemsToSell;
    }

    public int getTravelDuration() {
        return travelDuration;
    }
}
