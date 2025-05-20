package model;

public class Medicine extends Item {
    private int dosage;

    public Medicine(String name, double price, int physicalEffect, int mentalEffect, int spiritualEffect, int dosage) {
        super(name, price, physicalEffect, mentalEffect, spiritualEffect);
        this.dosage = dosage;
    }

    @Override
    public void use(Person person) {

    }
}
