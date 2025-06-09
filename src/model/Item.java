package model;

public abstract class Item {
    protected String name;
    protected double price;
    protected int physicalEffect;
    protected int mentalEffect;
    protected int spiritualEffect;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void use(Person person);
    public abstract void buy(Person person);

    public void sell(Person person){
        person.addMoney(price * 0.8);
        person.getInventory().remove(this);
        System.out.println("Item sold (+$" + (price * 0.8) + ")");
        System.out.println();
        person.showStatus();
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getPhysicalEffect() {
        return physicalEffect;
    }
    public int getMentalEffect() {
        return mentalEffect;
    }

    public int getSpiritualEffect() {
        return spiritualEffect;
    }
}
