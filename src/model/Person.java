package model;

import java.util.*;

public class Person {
    protected String name;
    protected double money;
    protected int physicalHealth;
    protected int mentalHealth;
    protected int spiritualHealth;
    protected LinkedList<Item> inventory = new LinkedList<>();
    protected LinkedList<Activity> activities = new LinkedList<>();
    protected Random r = new Random();

    public Person(String name) {
        this.name = name;
        this.money = 50.0;
        this.physicalHealth = r.nextInt(20,41);
        this.mentalHealth = r.nextInt(20,41);
        this.spiritualHealth = r.nextInt(20,41);
        activities.add(new Activity("Meditation", -5,15, 8, 0, "Mental"));
        activities.add(new Activity("Psychologist Consultation", -10, 40, 5, 200, "Mental"));
        activities.add(new Activity("Journaling", -8, 10, 5, 0, "Mental"));
        activities.add(new Activity("Pray", -2, 8, 20, 0, "Spiritual"));
        
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

    public int getPhysicalHealth() {
        return physicalHealth;
    }

    public void setPhysicalHealth(int physicalHealth) {
        this.physicalHealth = physicalHealth;
    }

    public int getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(int mentalHealth) {
        this.mentalHealth = mentalHealth;
    }

    public int getSpiritualHealth() {
        return spiritualHealth;
    }

    public void setSpiritualHealth(int spiritualHealth) {
        this.spiritualHealth = spiritualHealth;
    }

    public LinkedList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(LinkedList<Item> inventory) {
        this.inventory = inventory;
    }

    public LinkedList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(LinkedList<Activity> activities) {
        this.activities = activities;
    }
}
