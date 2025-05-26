package model;

public class Activity {
    private String name;
    private int physicalEffect;
    private int mentalEffect;
    private int spiritualEffect;
    private double money;
    private String category;
    private int activityDuration;

    public Activity(String name, int physicalEffect, int mentalEffect, int spiritualEffect, double money, String category, int activityDuration) {
        this.name = name;
        this.physicalEffect = physicalEffect;
        this.mentalEffect = mentalEffect;
        this.spiritualEffect = spiritualEffect;
        this.money = money;
        this.category = category;
        this.activityDuration = activityDuration; 
    }
    
    public int doActivity(Person person) {
        if(money <= 0){ // Daily activity can be free or cost money
            if(person.getMoney() < money) {
                System.out.println("You don't have enough money to do this activity.");
                System.out.println();
                return 0; // durasi aktivitas 0 jika tidak bisa dilakukan
            }
        } 

        System.out.println(person.getName() + " is doing the activity");
        System.out.println();

        person.applyEffect(physicalEffect, mentalEffect, spiritualEffect);
        person.addMoney(money);
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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
}
