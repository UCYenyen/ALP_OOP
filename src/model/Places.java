package model;

import java.util.*;

public class Places {
    private Random r = new Random();

    private String name;
    private boolean isOpen;
    private int openHour;
    private int closeHour;
    private int discount;

    private LinkedList<Item> itemsToSell = new LinkedList<>();

    public Places(String name, LinkedList<Item> itemsToSell, int currentHour) {
        this.name = name;
        this.openHour = r.nextInt(7, 11);
        this.closeHour = r.nextInt(20, 24);
        this.itemsToSell = itemsToSell;

        System.out.println("buka memek" + openHour);
        System.out.println("tutup memek" + closeHour);

        isOpen = currentHour <= closeHour && currentHour >= openHour;
    }
    public boolean checkIfIsOpen(int currentHour){
        isOpen = currentHour <= closeHour && currentHour >= openHour;
        return isOpen;
    }
    public String getName() {
        return name;
    }
    public void RandomizeItem(){

    }
}
