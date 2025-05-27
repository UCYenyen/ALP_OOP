package logic;

import java.util.*;
import model.*;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    private LinkedList<Person> people = new LinkedList<>();
    private LinkedList<Place> places = new LinkedList<>();

    private Person currentPerson;
    private int currentHour;

    public void init() {
        currentHour = 6;
        Job[] jobs = {
            new Job("Software Engineer", 200),
            new Job("Data Scientist", 180),
            new Job("Doctor", 300),
            new Job("Teacher", 150),
            new Job("Chef", 150)
        };
        
        String[] healthyPersonNames = { "Bryan", "Obie", "Nicho", "Feli", "Clarice", "Jason", "Niki", "Life", "Dharma",
                "Felix" };
        String[] sickPersonNames = { "Richard", "Richardo", "Flabianos", "Rex", "Matthew", "Michael", "Julius", "Jevon",
                "Christoper", "Christian" };
        String[] illness_list = { "Diabetes", "Hypertension", "Asthma", "Arthritis", "Influenza", "GERD", "Pneumonia",
                "Depression", "Anxiety Disorder", "Bipolar Disorder" };
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

        // Initialize healthy person
        for (int i = 0; i < 10; i++) {
            Person p = new Person(healthyPersonNames[i], jobs[r.nextInt(jobs.length)]);
            people.add(p);
        }

        // Initialize sick person
        for (int i = 0; i < 10; i++) {
            SickPerson p = new SickPerson(sickPersonNames[i], jobs[r.nextInt(jobs.length)], illness_list[i], medicines[i]);
            people.add(p);
        }

        // Initialize Pharmacies
        LinkedList<Medicine> usedMedicines = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
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
            if (i == 0) {
                places.add(new Place("Pharmacy A", itemToAdd, 1));
            } else {
                places.add(new Place("Pharmacy B", itemToAdd, 2));
            }
        }

        // Initialize Restaurants
        places.add(new Place("Healthy Restaurant", healthyFoods, 2));
        places.add(new Place("Fast Food Restaurant", fastFoods, 1));
    }

    public void defaultMenu() {
        while(true){
            init();
            int choice = 0;
            do {
                System.out.println("\nWelcome to Game");
                System.out.println("1. Play Game");
                System.out.println("2. Exit Game");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid choice");
                }
            } while (choice < 1 || choice > 2);

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
    }

    private void mainMenu() {
        currentPerson = people.get(r.nextInt(people.size()));
        System.out.println("=== [System] ===");
        System.out.println("Hello, " + currentPerson.getName());
        if (currentPerson instanceof SickPerson) {
            System.out.println("You were destined to bear the sickness : " + ((SickPerson) currentPerson).getIllness());
            System.out.println("Medicine : " + ((SickPerson) currentPerson).getMedicine().getName() + " ("
                    + ((SickPerson) currentPerson).getMedicine().getDosage() + "mg)");
        } else {
            System.out.println("You are a healthy person");
        }
        System.out.println();

        currentPerson.showStatus();

        System.out.println("Choose what you want to do wisely so that you have a balanced life. Good Luck! \n");
        while (true) {
            int choice = 0;
            do {
                System.out.println("=== [Main Menu] ===");
                System.out.println("Current Time: " + currentHour + ":00");
                System.out.println("1. Do activities");
                System.out.println("2. Buy items");
                System.out.println("3. Inventory");
                System.out.println("4. Go to work");
                System.out.println("5. Create new activity");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice");
                }
            } while (choice < 1 || choice > 5);

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
                    printWorkMenu();
                    break;
                case 5:
                    createActivity();
                    break;
            }

            if (currentPerson.getPhysicalHealth() > 100) {
                currentPerson.setPhysicalHealth(100);
            }
            if (currentPerson.getMentalHealth() > 100) {
                currentPerson.setMentalHealth(100);
            }
            if (currentPerson.getSpiritualHealth() > 100) {
                currentPerson.setSpiritualHealth(100);
            }

            if (currentPerson.getPhysicalHealth() < 0) {
                currentPerson.setPhysicalHealth(0);
            }
            if (currentPerson.getMentalHealth() < 0) {
                currentPerson.setMentalHealth(0);
            }
            if (currentPerson.getSpiritualHealth() < 0) {
                currentPerson.setSpiritualHealth(0);
            }

            currentPerson.showStatus();

            if (currentPerson.getPhysicalHealth() == 100 && currentPerson.getMentalHealth() == 100
                    && currentPerson.getSpiritualHealth() == 100) {
                System.out.println("You have achieved a balanced life! You win!");
                return;
            } else if (currentPerson.getPhysicalHealth() == 0 || currentPerson.getMentalHealth() == 0
                    || currentPerson.getSpiritualHealth() == 0) {
                System.out.println("You have lost your balance! You lose!");
                return;
            }
        }
    }

    //#region doActivity Menu 
    private void doActivities() {
        int choice = 0;
        do {
            System.out.println("=== [Activities Menu] ===");
            System.out.println("Current Time: " + currentHour + ":00");
            System.out.println("1. Physical Activity");
            System.out.println("2. Mental Activity");
            System.out.println("3. Spiritual Activity");
            System.out.println("4. Sleep");
            System.out.println("0. Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while (choice < 0 || choice > 4);
        switch (choice) {
            case 0:
                return;
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
                incrementHour(currentPerson.getActivities().get(0).doActivity(currentPerson));
                break;
        }
    }

    private void PhysicalActivity() {
        int choice = 0;
        LinkedList<Activity> physicalAct = new LinkedList<>();

        for (int i = 0; i < currentPerson.getActivities().size(); i++) {
            if (currentPerson.getActivities().get(i).getCategory().equals("Physical")) {
                physicalAct.add(currentPerson.getActivities().get(i));
            }
        }

        do {
            System.out.println("=== [Physical Activity Menu] ===");
            System.out.println("Current Time: " + currentHour + ":00");
            for (int i = 0; i < physicalAct.size(); i++) {
                System.out.println((i + 1) + ". " + physicalAct.get(i).getName());
            }
            System.out.println(0 + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if (choice < 0 || choice > physicalAct.size()) {
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while (choice < 0 || choice > physicalAct.size());

        if (choice == 0) {
            return;
        }

        incrementHour(physicalAct.get(choice - 1).doActivity(currentPerson));
    }

    private void MentalActivity() {
        int choice = 0;
        LinkedList<Activity> mentalAct = new LinkedList<>();

        for (int i = 0; i < currentPerson.getActivities().size(); i++) {
            if (currentPerson.getActivities().get(i).getCategory().equals("Mental")) {
                mentalAct.add(currentPerson.getActivities().get(i));
            }
        }
        do {
            System.out.println("=== [Mental Activity Menu] ===");
            System.out.println("Current Time: " + currentHour + ":00");
            for (int i = 0; i < mentalAct.size(); i++) {
                System.out.println((i + 1) + ". " + mentalAct.get(i).getName());
            }
            System.out.println(0 + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if (choice < 0 || choice > mentalAct.size()) {
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while (choice < 0 || choice > mentalAct.size());

        if (choice == 0) {
            return;
        }

        incrementHour(mentalAct.get(choice - 1).doActivity(currentPerson));
    }

    private void SpiritualActivity() {
        int choice = 0;
        LinkedList<Activity> spritualAct = new LinkedList<>();

        for (int i = 0; i < currentPerson.getActivities().size(); i++) {
            if (currentPerson.getActivities().get(i).getCategory().equals("Spiritual")) {
                spritualAct.add(currentPerson.getActivities().get(i));
            }
        }
        do {
            System.out.println("=== [Spiritual Activity Menu] ===");
            System.out.println("Current Time: " + currentHour + ":00");
            for (int i = 0; i < spritualAct.size(); i++) {
                System.out.println((i + 1) + ". " + spritualAct.get(i).getName());
            }
            System.out.println(0 + ". Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if (choice < 0 || choice > spritualAct.size()) {
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while (choice < 0 || choice > spritualAct.size());

        if (choice == 0) {
            return;
        }

        incrementHour(spritualAct.get(choice - 1).doActivity(currentPerson));
    }

    //#endregion

    //#region buyItems Menu
    private void showPlaces() {
        int choice = 0;
        while (true) {
            do {
                System.out.println("=== [Places Menu] ===");
                System.out.println("Current Time: " + currentHour + ":00");
                System.out.printf("%-4s %-25s %-20s\n", "No.", "Place Name", "Travel Duration (hours)");
                System.out.println("------------------------------------------------------");
                for (int i = 0; i < places.size(); i++) {
                    System.out.printf("%-4d %-25s %-20d\n", 
                        (i + 1), 
                        places.get(i).getName(), 
                        places.get(i).getTravelDuration()
                    );
                }
                System.out.println("------------------------------------------------------");
                System.out.println(0 + ". Back");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if (choice < 0 || choice > places.size()) {
                    System.out.println("Invalid choice");
                }

            } while (choice < 0 || choice > places.size());

            if (choice == 0) {
                return;
            }

            showPlaceDetail(choice - 1);
        }
    }

    private void showPlaceDetail(int placeIndex) {
        int choice = -1;
        Item[] items = places.get(placeIndex).getItemsToSell();
        incrementHour(places.get(placeIndex).getTravelDuration());

        while ((choice != 0 && choice < items.length) || choice > items.length) {
            do {
                System.out.println("=== [Place Detail] ===");
                System.out.println("Current Time: " + currentHour + ":00");
                System.out.println("Your money : $" + currentPerson.getMoney());
                System.out.println("Name : " + places.get(placeIndex).getName());
                System.out.println("Items : ");
                System.out.printf("%-4s %-25s %-15s %-10s\n", "No.", "Name", "Detail", "Price");
                System.out.println("-------------------------------------------------------------");
                for (int i = 0; i < items.length; i++) {
                    String detail = "";
                    if (items[i] instanceof Medicine) {
                        detail = "Dosage: " + ((Medicine) items[i]).getDosage() + "mg";
                    } else if (items[i] instanceof Food) {
                        detail = "Nutrition: " + ((Food) items[i]).getNutrition() + "%";
                    }
                    System.out.printf("%-4d %-25s %-15s %-10.2f\n", (i + 1), items[i].getName(), detail,
                            items[i].getPrice());
                }
                System.out.println("-------------------------------------------------------------");
                System.out.println(0 + ". Back");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if (choice < 0 || choice > items.length) {
                    System.out.println("Invalid choice");
                    System.out.println();
                }
            } while (choice < 0 || choice > items.length);

            if (choice < items.length && choice != 0) {
                items[choice - 1].buy(currentPerson);
            }
        }
        if (choice == 0) {
            return;
        }
    }

    //#endregion

    //#region Inventory Menu
    private void showInventory() {
        int choice;

        if (currentPerson.getInventory().isEmpty()) {
            System.out.println("=== [Inventory] ===");
            System.out.println("Inventory is empty");
            System.out.println();
            return;
        }

        do {
            System.out.println("=== [Inventory] ===");
            System.out.println("1. Show Foods");
            System.out.println("2. Show Medicines");
            System.out.println("0. Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            System.out.println();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid choice");
            }
        } while (choice < 0 || choice > 2);

        switch (choice) {
            case 0:
                return;
            case 1:
                showFoodInventory();
                break;
            case 2:
                showMedicineInventory();
                break;
        }
    }

    private void showFoodInventory() {
        int choice;
        LinkedList<Item> foods = new LinkedList<>();

        for (int i = 0; i < currentPerson.getInventory().size(); i++) {
            if (currentPerson.getInventory().get(i) instanceof Food) {
                foods.add(currentPerson.getInventory().get(i));
            }
        }

        if (foods.isEmpty()) {
            System.out.println("Inventory is empty");
            System.out.println();
            return;
        }

        System.out.println("=========================== [Foods] =============================");
        System.out.printf("%-4s %-25s %-15s %-15s\n", "No.", "Name", "Nutrition(%)", "Expiration (Hours)");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < foods.size(); i++) {
            Food food = (Food) foods.get(i);
            if(food.getHoursBeforeExpired() < 0){
                System.out.printf("%-4d %-25s %-15d %-15s\n", 
                    (i + 1), 
                    food.getName(), 
                    food.getNutrition(), 
                    "[Expired]"
                );
            } else{
                System.out.printf("%-4d %-25s %-15d %-15d\n", 
                    (i + 1), 
                    food.getName(), 
                    food.getNutrition(), 
                    food.getHoursBeforeExpired()
                );
            }
        }

        do {
            System.out.println("\n1. Use Item");
            System.out.println("2. Sell Item");
            System.out.println("0. Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            System.out.println();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid choice");
                System.out.println();
            }
        } while (choice < 0 || choice > 2);
        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.println("Use Item");
                System.out.print("Chosen food : ");
                int itemNumber = s.nextInt();
                if (itemNumber > foods.size()) {
                    System.out.println("Item not found");
                    System.out.println();
                } else {
                    foods.get(itemNumber - 1).use(currentPerson);
                }
                break;
            case 2:
                System.out.println("Sell Item");
                System.out.print("chosen food : ");
                int sellItemNumber = s.nextInt();
                if (sellItemNumber > foods.size()) {
                    System.out.println("Item not found");
                    System.out.println();
                } else {
                    foods.get(sellItemNumber - 1).sell(currentPerson);
                }
                break;
        }
    }

    private void showMedicineInventory() {
        int choice;
        LinkedList<Item> medicines = new LinkedList<>();
        for (int i = 0; i < currentPerson.getInventory().size(); i++) {
            if (currentPerson.getInventory().get(i) instanceof Medicine) {
                medicines.add(currentPerson.getInventory().get(i));
            }
        }

        System.out.println("=== [Medicines] ===");
        for (int i = 0; i < medicines.size(); i++) {
            System.out.println((i + 1) + ". " + medicines.get(i).getName());
        }
        
        if (medicines.isEmpty()) {
            System.out.println("Inventory is empty");
            System.out.println();
            return;
        }

        do {
            System.out.println("\n1. Use Item");
            System.out.println("2. Sell Item");
            System.out.println("0. Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            System.out.println();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid choice");
                System.out.println();
            }
        } while (choice < 0 || choice > 2);
        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.println("Use Item");
                System.out.print("Chosen medicine : ");
                int itemNumber = s.nextInt();
                if (itemNumber > medicines.size()) {
                    System.out.println("medicine not found");
                    System.out.println();
                } else {
                    medicines.get(itemNumber - 1).use(currentPerson);
                }
                break;
            case 2:
                System.out.println("Sell Item");
                System.out.print("chosen medicine : ");
                int sellItemNumber = s.nextInt();
                if (sellItemNumber > medicines.size()) {
                    System.out.println("medicine not found");
                    System.out.println();
                } else {
                    medicines.get(sellItemNumber - 1).sell(currentPerson);
                }
                break;
        }
    }
    //#endregion

    //#region Work Menu
    private void printWorkMenu(){
        int choice = 0;
        do{
            System.out.println("=== [Work Menu] ===");
            System.out.println("Current Time: " + currentHour + ":00");
            System.out.println("1. Do Work");
            System.out.println("2. Create Work Activity");
            System.out.println("0. Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while (choice < 0 || choice > 2);

        if(currentPerson.getJob() == null) {
            System.out.println("You don't have a job yet. Please get a job first.");
            return;
        }

        switch (choice) {
            case 0:
                return;
            case 1:
                incrementHour(currentPerson.getJob().showWorkActivities(currentPerson, currentHour));
                break;
            case 2:
                currentPerson.getJob().createWork();
                break;
        }
    }
    //#endregion

    //#region createActivity Menu
    private void createActivity() {
        int choice = 0;
        do {
            System.out.println("Create Activity Menu");
            System.out.println("1. Create Physical Activity");
            System.out.println("2. Create Mental Activity");
            System.out.println("3. Create Spiritual Activity");
            System.out.println("0. Back");
            System.out.print("Choice : ");
            choice = s.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid choice");
            }
            System.out.println();
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 0:
                return;
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

    private void createPhysicalActivity() {
        System.out.print("Enter activity name : ");
        String name = s.next() + s.nextLine();
        System.out.print("Enter activity price : ");
        double price = s.nextDouble() * -1;
        System.out.print("Enter activity duration (in hours) : ");
        int duration = s.nextInt();
        System.out.print("Enter physical effect : ");
        int physicalEffect = s.nextInt();
        System.out.print("Enter mental effect : ");
        int mentalEffect = s.nextInt();
        System.out.print("Enter spiritual effect : ");
        int spiritualEffect = s.nextInt();

        Activity act = new Activity(name, physicalEffect, mentalEffect, spiritualEffect, price, "Physical", duration);
        currentPerson.getActivities().add(act);
        System.out.println();
    }

    private void createMentalActivity() {
        System.out.print("Enter activity name : ");
        String name = s.next() + s.nextLine();
        System.out.print("Enter activity price : ");
        double price = s.nextDouble() * -1;
        System.out.print("Enter activity duration (in hours) : ");
        int duration = s.nextInt();
        System.out.print("Enter physical effect : ");
        int physicalEffect = s.nextInt();
        System.out.print("Enter mental effect : ");
        int mentalEffect = s.nextInt();
        System.out.print("Enter spiritual effect : ");
        int spiritualEffect = s.nextInt();

        Activity act = new Activity(name, physicalEffect, mentalEffect, spiritualEffect, price, "Mental", duration);
        currentPerson.getActivities().add(act);
        System.out.println();
    }

    private void createSpiritualActivity() {
        System.out.print("Enter activity name : ");
        String name = s.next() + s.nextLine();
        System.out.print("Enter activity price : ");
        double price = s.nextDouble() * -1;
        System.out.print("Enter activity duration (in hours) : ");
        int duration = s.nextInt();
        System.out.print("Enter physical effect : ");
        int physicalEffect = s.nextInt();
        System.out.print("Enter mental effect : ");
        int mentalEffect = s.nextInt();
        System.out.print("Enter spiritual effect : ");
        int spiritualEffect = s.nextInt();

        Activity act = new Activity(name, physicalEffect, mentalEffect, spiritualEffect, price, "Spiritual", duration);
        currentPerson.getActivities().add(act);
        System.out.println();
    }
    //#endregion
    
    private void incrementHour(int duration) {
        for (int i = 0; i < duration; i++) {
            currentHour++;
            if (currentHour > 24) {
                currentHour = 1;
            }
        }
        if(!currentPerson.getInventory().isEmpty()){
            for(Item i : currentPerson.getInventory()){
                if(i instanceof Food){
                    Food f = (Food) i;
                    f.expire(duration);
                }
            }
        }
    }
}

