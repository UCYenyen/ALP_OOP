package model;

public class Food extends Item {
    private double nutrition;

    public Food(String name, double price, double physicalEffect, double mentalEffect, double spiritualEffect, double nutrition) {
        super(name, price, physicalEffect, mentalEffect, spiritualEffect);
        this.nutrition = nutrition;
    }

    @Override
    public void use(Person person) {
        
    }
}
