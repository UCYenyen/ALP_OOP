package model;

public class Activity {
    private String name;
    private double physicalEffect;
    private double mentalEffect;
    private double spiritualEffect;

    public Activity(String name, double physicalEffect, double mentalEffect, double spiritualEffect) {
        this.name = name;
        this.physicalEffect = physicalEffect;
        this.mentalEffect = mentalEffect;
        this.spiritualEffect = spiritualEffect;
    }
}
