package model;

import java.util.*;

public class Person {
    private String name;
    private double money;
    private double physicalHealth;
    private double mentalHealth;
    private double spiritualHealth;
    private ArrayList<Item> inventory;

    public Person(String name, double money, double physicalHealth, double mentalHealth, double spiritualHealth) {
        this.name = name;
        this.money = money;
        this.physicalHealth = physicalHealth;
        this.mentalHealth = mentalHealth;
        this.spiritualHealth = spiritualHealth;
        this.inventory = new ArrayList<>();
    }
}
