package model;

public class Medicine extends Item {
    private int dosage;
    private String category;

    public Medicine(String name, double price, int dosage, String category) {
        super(name, price);
        this.dosage = dosage;
        this.category = category;

        //#region Physical Effect
        if(category.equals("Physical") && (dosage >= 0 && dosage <= 10)){
            physicalEffect = 2;
        } else if (category.equals("Mental") && (dosage >= 0 && dosage <= 10)){
            physicalEffect = 1;
        } else if (category.equals("Physical") && (dosage > 10 && dosage <= 20)){
            physicalEffect = 4;
        } else if (category.equals("Mental") && (dosage > 10 && dosage <= 20)){
            physicalEffect = 2;
        } else if (category.equals("Physical") && (dosage > 20 && dosage <= 30)){
            physicalEffect = 6;
        } else if (category.equals("Mental") && (dosage > 20 && dosage <= 30)){
            physicalEffect = 3;
        } else if (category.equals("Physical") && (dosage > 30 && dosage <= 40)){
            physicalEffect = 8;
        } else if (category.equals("Mental") && (dosage > 30 && dosage <= 40)){
            physicalEffect = 4;
        } else if (category.equals("Physical") && (dosage > 40 && dosage <= 50)){
            physicalEffect = 10;
        } else if (category.equals("Mental") && (dosage > 40 && dosage <= 50)){
            physicalEffect = 5;
        }
        //#endregion

        //#region Mental Effect
        if(category.equals("Physical") && (dosage >= 0 && dosage <= 10)){
            mentalEffect = 1;
        } else if (category.equals("Mental") && (dosage >= 0 && dosage <= 10)){
            mentalEffect = 2;
        } else if (category.equals("Physical") && (dosage > 10 && dosage <= 20)){
            mentalEffect = 2;
        } else if (category.equals("Mental") && (dosage > 10 && dosage <= 20)){
            mentalEffect = 4;
        } else if (category.equals("Physical") && (dosage > 20 && dosage <= 30)){
            mentalEffect = 3;
        } else if (category.equals("Mental") && (dosage > 20 && dosage <= 30)){
            mentalEffect = 6;
        } else if (category.equals("Physical") && (dosage > 30 && dosage <= 40)){
            mentalEffect = 4;
        } else if (category.equals("Mental") && (dosage > 30 && dosage <= 40)){
            mentalEffect = 8;
        } else if (category.equals("Physical") && (dosage > 40 && dosage <= 50)){
            mentalEffect = 5;
        } else if (category.equals("Mental") && (dosage > 40 && dosage <= 50)){
            mentalEffect = 10;
        }
        //#endregion
        
        spiritualEffect = 0;
    }

    @Override
    public void use(Person person) {
        if(person instanceof SickPerson){
            if(((SickPerson) person).getMedicine() == this){
                person.applyEffect(physicalEffect, mentalEffect, 0);
                person.getInventory().remove(this);
            } else {
                person.applyEffect(-1 * physicalEffect, 0, 0);
                person.getInventory().remove(this);
            }
        } else {
            person.applyEffect(-1 * physicalEffect, 0, 0);
            person.getInventory().remove(this);
        }
        person.showStatus();
    }
    
    @Override
    public void buy(Person person) {
        if(person.getMoney() >= price){
            person.addMoney(-1 * price);
            person.getInventory().add(this);
            System.out.println("Item bought (-$" + price + ")");
            System.out.println();
        } else {
            System.out.println("Not enough money to buy this item.");
            System.out.println();
        }
    }

    public int getDosage() {
        return dosage;
    }

    public String getCategory() {
        return category;
    }
}
