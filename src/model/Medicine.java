package model;

public class Medicine extends Item {
    private double dosage;

    public Medicine(String name, double price, double physicalEffect, double mentalEffect, double spiritualEffect, double dosage) {
        super(name, price, physicalEffect, mentalEffect, spiritualEffect);
        this.dosage = dosage;
    }

    @Override
    public void use(Person person) {

    }
}
