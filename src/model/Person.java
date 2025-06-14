package model;

import java.util.*;

public class Person {
    protected String name;
    protected double money;
    protected int physicalHealth;
    protected int mentalHealth;
    protected int spiritualHealth;
    protected Job job;
    protected boolean lostBalance, achievedBalance;
    protected ArrayList<Item> inventory = new ArrayList<>();
    protected ArrayList<Activity> activities = new ArrayList<>();
    

    protected Random r = new Random();

    public Person(String name, Job job) {
        this.name = name;
        this.money = 200.0;
        this.physicalHealth = r.nextInt(20,41);
        this.mentalHealth = r.nextInt(20,41);
        this.spiritualHealth = r.nextInt(20,41);
        this.job = job;
        this.lostBalance = false;
        this.achievedBalance = false;
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
        System.out.println("=== " + this.name + "'s Status ===");
        System.out.println("Name: " + name);
        System.out.println("Job: " + (job != null ? job.getName() : "Unemployed"));
        System.out.println("Money: " + money);
        System.out.println("Physical Health: " + physicalHealth);
        System.out.println("Mental Health: " + mentalHealth);
        System.out.println("Spiritual Health: " + spiritualHealth);
        System.out.println();

        if (physicalHealth <= 0 || mentalHealth <= 0 || spiritualHealth <= 0) {
            lostBalance = true;
            System.out.println("You have lost your balance! You lose!");
        } else if (physicalHealth >= 100 && mentalHealth >= 100 && spiritualHealth >= 100) {
            achievedBalance = true;
            System.out.println("You have achieved a balanced life! You win!");
        } 
    }

    public void applyEffect(int physicalEffect, int mentalEffect, int spiritualEffect) {
        physicalHealth += physicalEffect;
        mentalHealth += mentalEffect;
        spiritualHealth += spiritualEffect;

        if (physicalHealth > 100) {
            physicalHealth = 100;
        }
        if (mentalHealth > 100) {
            mentalHealth = 100;
        }
        if (spiritualHealth > 100) {
            spiritualHealth = 100;
        }

        if (physicalHealth < 0) {
            physicalHealth = 0;
        }
        if (mentalHealth < 0) {
            mentalHealth= 0;
        }
        if (spiritualHealth < 0) {
            spiritualHealth = 0;
        }
    }

    public void addMoney(double amount) {
        this.money += amount;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public int getPhysicalHealth() {
        return physicalHealth;
    }

    public int getMentalHealth() {
        return mentalHealth;
    }

    public int getSpiritualHealth() {
        return spiritualHealth;
    }

    public Job getJob() {
        return job;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public boolean isLostBalance() {
        return lostBalance;
    }

    public boolean isAchievedBalance() {
        return achievedBalance;
    }
}
