package logic;

import java.util.*;
import model.*;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    private LinkedList<Person> people = new LinkedList<>();
    private Person currentPerson;

    private int currentHour = 6;

    // Places
    private LinkedList<Places> places = new LinkedList<>();

    public Menu(){
        initializePerson();
        defaultMenu();
    }

    private void initializePerson(){
        String[] healthyPersonNames = {"Bryan", "Obie", "Nicho", "Feli", "Clarice", "Jason", "Niki", "Life", "Dharma", "Felix"};
        for(int i = 0; i < 10; i++){
            String name = healthyPersonNames[i];
            Person p = new Person(name);
            people.add(p);
        }
        String[] sickPersonNames = {"Richard", "Richardo", "Flabianos", "Rex", "Matthew", "Michael", "Julius", "Jevon", "Christoper", "Christian"};
        String [] illness_list = {"Diabetes", "Hypertension", "Asthma", "Arthritis", "Influenza", "GERD", "Pneumonia", "Depression", "Anxiety Disorder", "Bipolar Disorder"};
        for(int i = 0; i < 10; i++){
            String name = sickPersonNames[i];
            String illness = illness_list[i];
            SickPerson p = new SickPerson(name, illness);
            people.add(p);
        }
    }
    private void initializePlaces(){
        Item[] pharmacyStoreItems = {
            new Medicine("Paracetamol", 10, 10, 0, 0, 1000),
            new Medicine("Insulin", 20, 0, 0, 0, 5000), // For Diabetes
            new Medicine("Amlodipine", 15, 0, 0, 0, 4000), // For Hypertension
            new Medicine("Salbutamol", 10, 0, 0, 0, 3500), // For Asthma
            new Medicine("Ibuprofen", 10, 0, 0, 0, 3000), // For Arthritis
            new Medicine("Oseltamivir", 10, 0, 0, 0, 2500), // For Influenza
            new Medicine("Antacid", 5, 0, 0, 0, 2000), // For GERD
            new Medicine("Azithromycin", 15, 0, 0, 0, 6000), // For Pneumonia
            new Medicine("Sertraline", 0, 20, 0, 0, 7000), // For Depression
            new Medicine("Alprazolam", 0, 15, 0, 0, 6500), // For Anxiety Disorder
            new Medicine("Lithium", 0, 25, 0, 0, 8000) // For Bipolar Disorder
        };
        Item[] supermarketItems = {
            new Food("Bread", 5, 2, 1, 0, 1500),
            new Food("Rice", 8, 1, 0, 0, 2000),
            new Food("Eggs", 6, 2, 0, 0, 2500),
            new Food("Milk", 4, 3, 1, 0, 3000),
            new Food("Apple", 2, 1, 2, 0, 1200),
            new Food("Banana", 2, 1, 2, 0, 1000),
            new Food("Chicken", 10, 3, 0, 0, 5000),
            new Food("Beef", 12, 2, 0, 0, 6000),
            new Food("Vegetables", 1, 2, 3, 0, 1800),
            new Food("Orange Juice", 1, 1, 2, 0, 2000),
            new Food("Water", 0, 0, 1, 0, 500),
            new Food("Cheese", 3, 2, 1, 0, 3500),
            new Food("Yogurt", 2, 2, 1, 0, 2500),
            new Food("Cereal", 4, 1, 1, 0, 2200),
            new Food("Chocolate", 3, 1, 0, 0, 2000),
            new Food("Instant Noodles", 5, 1, 0, 0, 1200),
            new Food("Potato Chips", 2, 1, 0, 0, 1500),
            new Food("Cookies", 3, 1, 0, 0, 1800),
            new Food("Butter", 2, 2, 0, 0, 1600),
            new Food("Jam", 2, 1, 1, 0, 1400)
        };
        // Item[] restaurantItems = {new Food("Pizza")};

        places.add(new Places("Supermarket", supermarketItems, currentHour));
        places.add(new Places("Pharmacy", pharmacyStoreItems, currentHour));
        // places.add(new Places("Restaurant", restaurantItems, currentHour));
    }


    private void defaultMenu(){
        int choice = 0;

        do{
            System.out.println("Welcome to Game");
            System.out.println("1. Play Game");
            System.out.println("2. Exit Game");
            System.out.print("Choice : ");
            choice = s.nextInt();
            System.out.println();
            if(choice < 1 || choice > 2){
                System.out.println("Invalid choice");
            }
        } while(choice < 1 || choice > 2);

        switch (choice) {
            case 1:
                mainMenu();
                break;
            case 2:
                System.out.println("Goodbye");
                System.exit(0);
                break;
        }
    }

    private void mainMenu(){
        currentPerson = people.get(r.nextInt(people.size()));
        System.out.println("Hello, " + currentPerson.getName());
        if(currentPerson instanceof SickPerson){
            System.out.println("You were destined to bear the sickness : " + ((SickPerson) currentPerson).getIllness());
        } else {
            System.out.println("You are a healthy person");
        }
        System.out.println();

        currentPerson.showStatus();

        System.out.println("Choose what you want to do wisely so that you have a balanced life. Good Luck! \n"); 
        while (true) {
            int choice = 0; 
            do{
                System.out.println("Main Menu");
                System.out.println("1. Do activities");
                System.out.println("2. Buy items");
                System.out.println("3. Inventory");
                System.out.println("4. Go to work");
                System.out.println("4. Create new activity");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if(choice < 1 || choice > 4){
                    System.out.println("Invalid choice");
                }
            } while(choice < 1 || choice > 4);
            
            switch (choice) {
                case 1:
                    doActivities();
                    break;
                case 2:
                    break;
                case 3:
                    showInventory();
                    break;
                case 4:
                    createActivity();
                    break;
            }
        }
    }
    //#region inventory
    private void showInventory() {
        LinkedList<Item> medicines = new LinkedList<>();
        LinkedList<Item> foods = new LinkedList<>(); 

        System.out.println("== " + currentPerson.getName() +" Inventory ==");

        if(medicines.isEmpty() && foods.isEmpty()){
            System.out.println("Inventory is empty");
            System.out.println();
            return;
        }

        for(int i = 0; i < currentPerson.getInventory().size(); i++){
            if(currentPerson.getInventory().get(i) instanceof Food){
                foods.add(currentPerson.getInventory().get(i));
            } else if(currentPerson.getInventory().get(i) instanceof Medicine){
                medicines.add(currentPerson.getInventory().get(i));
            }
        }

        System.out.println("=== Foods ===");
        for(int i = 0; i < foods.size(); i++){
            System.out.println((i+1) + ". " + foods.get(i).getName());
        }
        System.out.println();

        System.out.println("=== Medicines ===");
        for(int i = 0; i < medicines.size(); i++){
            System.out.println((i+1) + ". " + medicines.get(i).getName());
        }
        
        System.out.println("1. Use Item");
        System.out.println("2. Sell Item");
        System.out.println("3. Back");
        System.out.print("Choice : ");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Use Item");
                System.out.print("Enter item number : ");
                int itemNumber = s.nextInt();
                if(itemNumber > medicines.size()){
                    System.out.println("Item not found");
                } else{
                    medicines.get(itemNumber-1).use(currentPerson);
                }
                break;
            case 2:
                System.out.println("Sell Item");
                System.out.print("Enter item number : ");
                int sellItemNumber = s.nextInt();
                if(sellItemNumber > medicines.size()){
                    System.out.println("Item not found");
                } else{
                    medicines.get(sellItemNumber-1).sellItem(currentPerson);
                }
                break;
            case 3:
                buyItems();
                return;
        }
    }
    //#endregion
    
    //#region activities

    private void doActivities(){
        int choice = 0;
        do{
            System.out.println("Activities Menu");
            System.out.println("1. Physical Activity");
            System.out.println("2. Mental Activity");
            System.out.println("3. Spiritual Activity");
            System.out.println("4. Other Activity");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if(choice < 1 || choice > 3){
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while(choice < 1 || choice > 3);
        switch (choice) {
            case 1:
                PhysicalActivity();
                break;
            case 2:
                MentalActivity();
                break;
            case 3:
                SpiritualActivity();
                break;
            case 4:
                OtherActivity();
                break;
        }

    }
    private void createActivity(){
        int choice = 0;
        do{
            System.out.println("Create Activity Menu");
            System.out.println("1. Create Physical Activity");
            System.out.println("2. Create Mental Activity");
            System.out.println("3. Create Spiritual Activity");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if(choice < 1 || choice > 3){
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while(choice < 1 || choice > 3);
        
        switch(choice){
            case 1: 
                createPhysicalActivity();
                break;
            case 2:
                createMentalActivity();
                break;
            case 3:
                createSpiritualActivity();
                break;
        }
    }

    private void createPhysicalActivity(){
        System.out.print("Enter activity name : ");
        String name = s.next() + s.nextLine();
        System.out.print("Enter activity price : ");
        double price = s.nextDouble();
        System.out.print("Enter physical effect : ");
        int physicalEffect = s.nextInt();
        System.out.print("Enter mental effect : ");
        int mentalEffect = s.nextInt();
        System.out.print("Enter spiritual effect : ");
        int spiritualEffect = s.nextInt();

        Activity act = new Activity(name, physicalEffect, mentalEffect, spiritualEffect, price, "Physical");
        currentPerson.getActivities().add(act);
    }

    private void createMentalActivity(){
        System.out.print("Enter activity name : ");
        String name = s.next() + s.nextLine();
        System.out.print("Enter activity price : ");
        double price = s.nextDouble();
        System.out.print("Enter physical effect : ");
        int physicalEffect = s.nextInt();
        System.out.print("Enter mental effect : ");
        int mentalEffect = s.nextInt();
        System.out.print("Enter spiritual effect : ");
        int spiritualEffect = s.nextInt();

        Activity act = new Activity(name, physicalEffect, mentalEffect, spiritualEffect, price, "Mental");
        currentPerson.getActivities().add(act);
    }

    private void createSpiritualActivity(){
        System.out.print("Enter activity name : ");
        String name = s.next() + s.nextLine();
        System.out.print("Enter activity price : ");
        double price = s.nextDouble();
        System.out.print("Enter physical effect : ");
        int physicalEffect = s.nextInt();
        System.out.print("Enter mental effect : ");
        int mentalEffect = s.nextInt();
        System.out.print("Enter spiritual effect : ");
        int spiritualEffect = s.nextInt();

        Activity act = new Activity(name, physicalEffect, mentalEffect, spiritualEffect, price, "Spiritual");
        currentPerson.getActivities().add(act);
    }
    
    private void PhysicalActivity(){
        int choice = 0;
        LinkedList<Activity> physicalAct = new LinkedList<>();
        
        for(int i = 0; i < currentPerson.getActivities().size(); i++){
            if(currentPerson.getActivities().get(i).getCategory().equals("Physical")){
                physicalAct.add(currentPerson.getActivities().get(i));
            }
        }
        do{
            System.out.println("Physical Activity Menu");
            for(int i = 0; i < physicalAct.size(); i++){
                System.out.println((i+1) + ". " + physicalAct.get(i).getName());
            }
            System.out.println((physicalAct.size()+1) + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if(choice < 1 || choice > physicalAct.size()+1){
                System.out.println("Invalid choice");
            }
            System.out.println();
        }while(choice < 1 || choice > physicalAct.size() +1);

        if(choice == physicalAct.size()+1){
            return;
        }

        physicalAct.get(choice-1).doActivity(currentPerson);
        
        currentPerson.showStatus();

        incrementHour();
    }
    private void MentalActivity(){
        int choice = 0;
        LinkedList<Activity> mentalAct = new LinkedList<>();
        
        for(int i = 0; i < currentPerson.getActivities().size(); i++){
            if(currentPerson.getActivities().get(i).getCategory().equals("Mental")){
                mentalAct.add(currentPerson.getActivities().get(i));
            }
        }
        do{
            System.out.println("Mental Activity Menu");
            for(int i = 0; i < mentalAct.size(); i++){
                System.out.println((i+1) + ". " + mentalAct.get(i).getName());
            }
            System.out.println((mentalAct.size()+1) + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if(choice < 1 || choice > mentalAct.size()+1){
                System.out.println("Invalid choice");
            }
            System.out.println();
        }while(choice < 1 || choice > mentalAct.size() +1);

        if(choice == mentalAct.size()+1){
            return;
        }

        mentalAct.get(choice-1).doActivity(currentPerson);

        currentPerson.showStatus();

        incrementHour();
    }
    private void SpiritualActivity(){
        int choice = 0;
        LinkedList<Activity> spritualAct = new LinkedList<>();
        
        for(int i = 0; i < currentPerson.getActivities().size(); i++){
            if(currentPerson.getActivities().get(i).getCategory().equals("Spiritual")){
                spritualAct.add(currentPerson.getActivities().get(i));
            }
        }
        do{
            System.out.println("Spiritual Activity Menu");
            for(int i = 0; i < spritualAct.size(); i++){
                System.out.println((i+1) + ". " + spritualAct.get(i).getName());
            }
            System.out.println((spritualAct.size()+1) + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if(choice < 1 || choice > spritualAct.size()+1){
                System.out.println("Invalid choice");
            }
            System.out.println();
        }while(choice < 1 || choice > spritualAct.size() +1);

        if(choice == spritualAct.size()+1){
            return;
        }

        spritualAct.get(choice-1).doActivity(currentPerson);

        currentPerson.showStatus();

        incrementHour();
    }
    //#endregion
    private void buyItems(){
        System.out.println("Main Menu");
        System.out.println("1. Food");
        System.out.println("2. Drink");
        System.out.println("3. Medicine");
        System.out.println();

        incrementHour();
    }

    private void incrementHour(){
        currentHour++;
        if(currentHour >= 24){
            currentHour = 1;
        }
    }
}
