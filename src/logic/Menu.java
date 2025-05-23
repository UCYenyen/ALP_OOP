package logic;

import java.util.*;
import model.*;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    private LinkedList<Person> people = new LinkedList<>();
    private Person currentPerson;

    private int currentHour = 6;

    private LinkedList<Place> places = new LinkedList<>();

    

    public Menu(){
        String[] healthyPersonNames = {"Bryan", "Obie", "Nicho", "Feli", "Clarice", "Jason", "Niki", "Life", "Dharma", "Felix"};
        String[] sickPersonNames = {"Richard", "Richardo", "Flabianos", "Rex", "Matthew", "Michael", "Julius", "Jevon", "Christoper", "Christian"};
        String [] illness_list = {"Diabetes", "Hypertension", "Asthma", "Arthritis", "Influenza", "GERD", "Pneumonia", "Depression", "Anxiety Disorder", "Bipolar Disorder"};
        Medicine[] medicines = {
            new Medicine("Metformin", 30, 30, "Physical"),
            new Medicine("Amlodipine", 10, 20, "Physical"),
            new Medicine("Seretide", 25, 30, "Physical"),
            new Medicine("Lameson", 10, 8, "Physical"),
            new Medicine("Paracetamol", 5, 10, "Physical"),
            new Medicine("Omeprazole", 30, 40, "Physical"),
            new Medicine("Amoksisilin", 70, 30, "Physical"),
            new Medicine("Zypras", 60, 10, "Mental"),
            new Medicine("Brintelix", 50, 10, "Mental"),
            new Medicine("Olanzapine", 80, 20, "Mental"),

            new Medicine("Metformin", 40, 40, "Physical"),
            new Medicine("Amlodipine", 20, 40, "Physical"),
            new Medicine("Seretide", 50, 50, "Physical"),
            new Medicine("Lameson", 20, 16, "Physical"),
            new Medicine("Paracetamol", 10, 20, "Physical"),
            new Medicine("Omeprazole", 55, 50, "Physical"),
            new Medicine("Amoksisilin", 80, 40, "Physical"),
            new Medicine("Zypras", 90, 20, "Mental"),
            new Medicine("Brintelix", 80, 20, "Mental"),
            new Medicine("Olanzapine", 100, 30, "Mental")
        };

        // Healthy foods
        Food[] healthyFoods = {
            new Food("Salad", 10, 90, 2),
            new Food("Sushi", 25, 85, 15),
            new Food("Fruit Salad", 8, 80, 5),
            new Food("Grilled Chicken Breast", 20, 75, 10),
            new Food("Steamed Broccoli", 5, 95, 1),
            new Food("Oatmeal", 7, 85, 2),
            new Food("Quinoa Bowl", 15, 80, 8),
            new Food("Greek Yogurt", 6, 70, 2),
            new Food("Avocado Toast", 12, 75, 5),
            new Food("Smoothie Bowl", 10, 80, 4),
            new Food("Vegetable Soup", 8, 85, 3),
            new Food("Grilled Salmon", 25, 90, 15),
            new Food("Brown Rice", 7, 70, 2),
            new Food("Boiled Eggs", 6, 80, 2),
            new Food("Roasted Sweet Potato", 9, 75, 3)
        };

        // Fast foods
        Food[] fastFoods = {
            new Food("Pizza", 20, 30, 10),
            new Food("Burger", 15, 25, 5),
            new Food("Fried Chicken", 18, 20, 8),
            new Food("French Fries", 8, 10, 2),
            new Food("Hot Dog", 12, 15, 4),
            new Food("Potato Chips", 5, 8, 1),
            new Food("Chocolate", 3, 5, 1),
            new Food("Ice Cream", 6, 10, 2),
            new Food("Donut", 4, 7, 1),
            new Food("Pasta", 20, 30, 10),
            new Food("Steak", 30, 40, 20),
            new Food("Fried Rice", 15, 25, 7),
            new Food("Sandwich", 12, 35, 5),
            new Food("Nachos", 10, 15, 3),
            new Food("Taco", 11, 20, 4)
        };

        //Initialize healthy person
        for(int i = 0; i < 10; i++){
            String name = healthyPersonNames[i];
            Person p = new Person(name);
            people.add(p);
        }
        //Initialize sick person
        for(int i = 0; i < 10; i++){
            String name = sickPersonNames[i];
            String illness = illness_list[i];
            SickPerson p = new SickPerson(name, illness, medicines[i]);
            people.add(p);
        }

        // Initialize Pharmacies
        LinkedList<Medicine> usedMedicines = new LinkedList<>();

        for(int i = 0; i < 2; i ++){
            int added = 0;
            Item[] itemToAdd = new Item[10];
            while (added < 10) {
                int idx = r.nextInt(medicines.length);
                Medicine med = medicines[idx];
                if (!usedMedicines.contains(med)) {
                    itemToAdd[added] = med;
                    usedMedicines.add(med);
                    added++;
                }
            }
            if(i == 0){
                places.add(new Place("Pharmacy A", itemToAdd));
            } else {
                places.add(new Place("Pharmacy B", itemToAdd));
            }
        }

        // Initialize Restaurants
        places.add(new Place("Healthy Restaurant", healthyFoods));
        places.add(new Place("Fast Food Restaurant", fastFoods));

        defaultMenu();
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
                System.out.println("5. Create new activity");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if(choice < 1 || choice > 5){
                    System.out.println("Invalid choice");
                }
            } while(choice < 1 || choice > 5);
            
            switch (choice) {
                case 1:
                    doActivities();
                    break;
                case 2:
                    showPlaces();
                    break;
                case 3:
                    showInventory();
                    break;
                case 4:
                    System.out.println("Go to work");
                    break;
                case 5:
                    createActivity();
                    break;
            }
        }
    }
    private void showPlaces(){
        int choice = 0;
        do{
            System.out.println("Places Menu");
            for(int i = 0; i < places.size(); i++){
                System.out.println((i+1) + ". " + places.get(i).getName());
            }
            System.out.println((places.size()+1) + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            System.out.println();
            if(choice < 1 || choice > places.size()+1){
                System.out.println("Invalid choice");
            }
        }while(choice < 1 || choice > places.size() +1);
        
        showPlaceDetail(choice-1);
    }
    private void showPlaceDetail(int placeIndex){
        System.out.println("Place Detail");
        System.out.println("Name : " + places.get(placeIndex).getName());
        System.out.println("Items : ");
        Item[] items = places.get(placeIndex).getItemsToSell();
        System.out.printf("%-4s %-25s %-15s %-10s\n", "No.", "Name", "Detail", "Price");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < items.length; i++) {
            String detail;
            if (items[i] instanceof Medicine) {
            detail = "Dosage: " + ((Medicine) items[i]).getDosage();
            } else if (items[i] instanceof Food) {
            detail = "Nutrition: " + ((Food) items[i]).getNutrition();
            } else {
            detail = "-";
            }
            System.out.printf("%-4d %-25s %-15s %-10.2f\n", (i + 1), items[i].getName(), detail, items[i].getPrice());
        }
        System.out.println();
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
                    medicines.get(sellItemNumber-1).sell(currentPerson);
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
    private void OtherActivity(){
        int choice = 0;
        LinkedList<Activity> otherAct = new LinkedList<>();
        
        for(int i = 0; i < currentPerson.getActivities().size(); i++){
            if(currentPerson.getActivities().get(i).getCategory().equals("Physical")){
                otherAct.add(currentPerson.getActivities().get(i));
            }
        }
        do{
            System.out.println("Physical Activity Menu");
            for(int i = 0; i < otherAct.size(); i++){
                System.out.println((i+1) + ". " + otherAct.get(i).getName());
            }
            System.out.println((otherAct.size()+1) + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if(choice < 1 || choice > otherAct.size()+1){
                System.out.println("Invalid choice");
            }
            System.out.println();
        }while(choice < 1 || choice > otherAct.size() +1);

        if(choice == otherAct.size()+1){
            return;
        }

        otherAct.get(choice-1).doActivity(currentPerson);
    
        currentPerson.showStatus();

        // incrementHour();
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
