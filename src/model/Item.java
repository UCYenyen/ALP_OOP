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
    public void sellItem(Person person){
        person.setMoney(person.getMoney() + price);
        person.getInventory().remove(this);
        System.out.println("Item sold (+$" + (price * 0.8) + ")");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPhysicalEffect() {
        return physicalEffect;
    }

    public double getMentalEffect() {
        return mentalEffect;
    }

    public double getSpiritualEffect() {
        return spiritualEffect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhysicalEffect(double physicalEffect) {
        this.physicalEffect = physicalEffect;
    }

    public void setMentalEffect(double mentalEffect) {
        this.mentalEffect = mentalEffect;
    }

    public void setSpiritualEffect(double spiritualEffect) {
        this.spiritualEffect = spiritualEffect;
    }
    
}
