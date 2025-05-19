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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getPhysicalHealth() {
        return physicalHealth;
    }

    public void setPhysicalHealth(double physicalHealth) {
        this.physicalHealth = physicalHealth;
    }

    public double getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(double mentalHealth) {
        this.mentalHealth = mentalHealth;
    }

    public double getSpiritualHealth() {
        return spiritualHealth;
    }

    public void setSpiritualHealth(double spiritualHealth) {
        this.spiritualHealth = spiritualHealth;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    
}
