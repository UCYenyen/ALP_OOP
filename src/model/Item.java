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
        person.setMoney(person.getMoney() + (price * 0.8));
        person.getInventory().remove(this);
        System.out.println("Item sold (+$" + (price * 0.8) + ")");
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
