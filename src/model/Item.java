package model;

public abstract class Item {
    private String name;
    private double price;
    private double physicalEffect;
    private double mentalEffect;
    private double spiritualEffect;

    public Item(String name, double price, double physicalEffect, double mentalEffect, double spiritualEffect) {
        this.name = name;
        this.price = price;
        this.physicalEffect = physicalEffect;
        this.mentalEffect = mentalEffect;
        this.spiritualEffect = spiritualEffect;
    }

    public abstract void use(Person person);
    
}
