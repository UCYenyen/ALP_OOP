package model;

import java.util.*;

public class Person {
    protected String name;
    protected double money;
    protected int physicalHealth;
    protected int mentalHealth;
    protected int spiritualHealth;
    protected Job job;
    protected LinkedList<Item> inventory = new LinkedList<>();
    protected LinkedList<Activity> activities = new LinkedList<>();

    protected Random r = new Random();

    public Person(String name, Job job) {
        this.name = name;
        this.money = 200.0;
        this.physicalHealth = r.nextInt(20,41);
        this.mentalHealth = r.nextInt(20,41);
        this.spiritualHealth = r.nextInt(20,41);
        this.job = job;
        activities.add(new Activity("Sleep", 10, 10, 0, 0, "Other", r.nextInt(6,9)));
        activities.add(new Activity("Meditation", -5,15, 8, 0, "Mental", 1));
        activities.add(new Activity("Psychologist Consultation", -10, 40, 5, -200, "Mental", 3));
        activities.add(new Activity("Write Journal", -8, 10, 5, 0, "Mental", 1));
        activities.add(new Activity("Listen to Music", -10, 8, 5, 0, "Mental", 1));
        activities.add(new Activity("Aerobic Dance", 20, 10, -10, 0, "Physical", 2));
        activities.add(new Activity("Swim", 15, 10, -10, 0, "Physical", 2));
        activities.add(new Activity("Play Golf", 30, 10, -10, -150, "Physical", 3));
        activities.add(new Activity("Pray", -2, 8, 20, 0, "Spiritual", 1));
        activities.add(new Activity("Read Holy Book", -5, 10, 15, 0, "Spiritual", 1));
    }

    public void showStatus() {
        System.out.println("== " + this.name + "'s Status ==");
        System.out.println("Name: " + name);
        System.out.println("Job: " + (job != null ? job.getName() : "Unemployed"));
        System.out.println("Money: " + money);
        System.out.println("Physical Health: " + physicalHealth);
        System.out.println("Mental Health: " + mentalHealth);
        System.out.println("Spiritual Health: " + spiritualHealth);
        System.out.println();
    }

    public void applyEffect(int physicalEffect, int mentalEffect, int spiritualEffect) {
        this.physicalHealth += physicalEffect;
        this.mentalHealth += mentalEffect;
        this.spiritualHealth += spiritualEffect;
    }

    public void addMoney(double amount) {
        this.money += amount;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
