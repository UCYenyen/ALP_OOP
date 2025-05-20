package model;

public class Activity {
    private String name;
    private int physicalEffect;
    private int mentalEffect;
    private int spiritualEffect;
    private double price;
    private String category;

    public Activity(String name, int physicalEffect, int mentalEffect, int spiritualEffect, double price, String category) {
        this.name = name;
        this.physicalEffect = physicalEffect;
        this.mentalEffect = mentalEffect;
        this.spiritualEffect = spiritualEffect;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhysicalEffect() {
        return physicalEffect;
    }

    public void setPhysicalEffect(int physicalEffect) {
        this.physicalEffect = physicalEffect;
    }

    public int getMentalEffect() {
        return mentalEffect;
    }

    public void setMentalEffect(int mentalEffect) {
        this.mentalEffect = mentalEffect;
    }

    public int getSpiritualEffect() {
        return spiritualEffect;
    }

    public void setSpiritualEffect(int spiritualEffect) {
        this.spiritualEffect = spiritualEffect;
    }
}
