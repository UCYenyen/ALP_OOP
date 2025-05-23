package model;

public class Food extends Item {
    private int nutrition;
    private int hoursBeforeExpired;

    public Food(String name, double price, int nutrition, int hoursBeforeExpired) {
        super(name, price);
        this.nutrition = nutrition;
        this.hoursBeforeExpired = hoursBeforeExpired;

        //#region Physical Effect
        if (nutrition >= 0 && nutrition <= 10) {
            physicalEffect = 1;
        } else if (nutrition > 10 && nutrition <= 20) {
            physicalEffect = 2;
        } else if (nutrition > 20 && nutrition <= 30) {
            physicalEffect = 3;
        } else if (nutrition > 30 && nutrition <= 40) {
            physicalEffect = 4;
        } else if (nutrition > 40 && nutrition <= 50) {
            physicalEffect = 5;
        } else if (nutrition > 50 && nutrition <= 60) {
            physicalEffect = 6;
        } else if (nutrition > 60 && nutrition <= 70) {
            physicalEffect = 7;
        } else if (nutrition > 70 && nutrition <= 80) {
            physicalEffect = 8;
        } else if (nutrition > 80 && nutrition <= 90) {
            physicalEffect = 9;
        } else if (nutrition > 90 && nutrition <= 100) {
            physicalEffect = 10;
        }
        //#endregion

        //#region Mental Effect
        if(nutrition >= 0 && nutrition <= 20) {
            mentalEffect = 1;
        } else if (nutrition > 20 && nutrition <= 40) {
            mentalEffect = 2;
        } else if (nutrition > 40 && nutrition <= 60) {
            mentalEffect = 3;
        } else if (nutrition > 60 && nutrition <= 80) {
            mentalEffect = 4;
        } else if (nutrition > 80 && nutrition <= 100) {
            mentalEffect = 5;
        }
        //#endregion
        
        spiritualEffect = 0;
    }

    @Override
    public void use(Person person) {
        if(hoursBeforeExpired >= 0){
            person.setPhysicalHealth(person.getPhysicalHealth() + physicalEffect);
            person.setMentalHealth(person.getMentalHealth() + mentalEffect);
            person.getInventory().remove(this);
        } else {
            person.setPhysicalHealth(person.getPhysicalHealth() - physicalEffect);
            person.getInventory().remove(this);
        }
    }
    @Override
    public void buy(Person person) {
        if (person.getMoney() >= price) {
            person.setMoney(person.getMoney() - price);
            Food itemToAdd = new Food(this.name, price, this.nutrition, this.hoursBeforeExpired);
            person.getInventory().add(itemToAdd);
            System.out.println("Item bought (-$" + price + ")");
            System.out.println();
        } else {
            System.out.println("Not enough money to buy this item.");
            System.out.println();
        }
    }

    public int getNutrition() {
        return nutrition;
    }

    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }

    public int getHoursBeforeExpired() {
        return hoursBeforeExpired;
    }

    public void setHoursBeforeExpired(int hoursBeforeExpired) {
        this.hoursBeforeExpired = hoursBeforeExpired;
    }
}
