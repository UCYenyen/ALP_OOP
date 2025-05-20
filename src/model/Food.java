package model;

public class Food extends Item {
    private int nutrition;

    public Food(String name, double price, int physicalEffect, int mentalEffect, int spiritualEffect, int nutrition) {
        super(name, price, physicalEffect, mentalEffect, spiritualEffect);
        this.nutrition = nutrition;
    }

    @Override
    public void use(Person person) {
        
    }
}
