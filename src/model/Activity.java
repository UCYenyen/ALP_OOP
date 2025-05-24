package model;

public class Activity {
    private String name;
    private int physicalEffect;
    private int mentalEffect;
    private int spiritualEffect;
    private double price;
    private String category;
    private int activityDuration;

    //for work ini masih belum tentu bener
    private double salary = 0;

    public Activity(String name, int physicalEffect, int mentalEffect, int spiritualEffect, double price, String category, int activityDuration) {
        this.name = name;
        this.physicalEffect = physicalEffect;
        this.mentalEffect = mentalEffect;
        this.spiritualEffect = spiritualEffect;
        this.price = price;
        this.category = category;
        this.activityDuration = activityDuration; 
    }
    public Activity(String name, int physicalEffect, int mentalEffect, int spiritualEffect, double price, String category, int activityDuration, double salary) {
        this.name = name;
        this.physicalEffect = physicalEffect;
        this.mentalEffect = mentalEffect;
        this.spiritualEffect = spiritualEffect;
        this.price = price;
        this.category = category;
        this.activityDuration = activityDuration; 
        this.salary = salary;
    }
    
    public int doActivity(Person person) {
        if(person.getMoney() < price) {
            System.out.println("You don't have enough money to do this activity.");
            System.out.println();
            return 0;
        }
        
        System.out.println(person.getName() + " is doing the activity");
        System.out.println();

        person.setPhysicalHealth(person.getPhysicalHealth() + physicalEffect);
        person.setMentalHealth(person.getMentalHealth() + mentalEffect);
        person.setSpiritualHealth(person.getSpiritualHealth() + spiritualEffect);
        person.setMoney(person.getMoney() - price);

        if (salary > 0) {
            person.setMoney(person.getMoney() + salary);
            System.out.println("You earned $" + salary);
            System.out.println();
        }
        return activityDuration;
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
    public int getActivityDuration() {
        return activityDuration;
    }
    public void setActivityDuration(int activityDuration) {
        this.activityDuration = activityDuration;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
