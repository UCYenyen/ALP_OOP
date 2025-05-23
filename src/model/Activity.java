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
    
    public void doActivity(Person person) {
        if(person.getMoney() < price) {
            System.out.println("You don't have enough money to do this activity.");
            System.out.println();
            return;
        }
        
        System.out.println(person.getName() + " is doing the activity");
        System.out.println();

        person.setPhysicalHealth(person.getPhysicalHealth() + physicalEffect);
        person.setMentalHealth(person.getMentalHealth() + mentalEffect);
        person.setSpiritualHealth(person.getSpiritualHealth() + spiritualEffect);
        person.setMoney(person.getMoney() - price);
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
