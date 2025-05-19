package logic;

import java.lang.reflect.Array;
import java.util.*;
import model.*;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private Random r = new Random();

    private LinkedList<Person> people = new LinkedList<>();
    private Person currentPerson;
    public Menu(){
        randomPerson();
        defaultMenu();
    }

    private void randomPerson(){
        people.clear();
        String[] names = {"John", "Jane", "Bob", "Alice", "Tom", "Jerry", "Mickey", "Donald", "Goofy", "Pluto"};
        for(int i = 0; i < 10; i++){
            String name = names[i];
            double money = r.nextInt(1000);
            double physicalHealth = r.nextInt(100);
            double mentalHealth = r.nextInt(100);
            double spiritualHealth = r.nextInt(100);
            Person p = new Person(name, money, physicalHealth, mentalHealth, spiritualHealth);
            people.add(p);
        }
        currentPerson = people.get(r.nextInt(people.size()));
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
        }while(choice < 1 || choice > 2);

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
        while (true) {
            int choice = 0; 
            do{
                System.out.println("Main Menu");
                System.out.println("1. Do activities");
                System.out.println("2. Buy items");
                System.out.println("3. Inventory");
                System.out.println("4. Create new activity");
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if(choice < 1 || choice > 4){
                    System.out.println("Invalid choice");
                }
            }while(choice < 1 || choice > 4);
            
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
        LinkedList<Item> items = new LinkedList<>();
        LinkedList<Item> foods = new LinkedList<>(); 

        System.out.println("== " + currentPerson.getName() +" Inventory ==");

        if(items.isEmpty() && foods.isEmpty()){
            System.out.println("Inventory is empty");
            System.out.println();
            return;
        }

        for(int i = 0; i < currentPerson.getInventory().size(); i++){
            if(currentPerson.getInventory().get(i) instanceof Food){
                items.add(currentPerson.getInventory().get(i));
            }else if(currentPerson.getInventory().get(i) instanceof Medicine){
                foods.add(currentPerson.getInventory().get(i));
            }
        }

        System.out.println("=== Foods ===");
        for(int i = 0; i < items.size(); i++){
            System.out.println((i+1) + ". " + items.get(i).getName());
        }
        System.out.println();
        
        System.out.println("=== Medicines ===");
        for(int i = 0; i < foods.size(); i++){
            System.out.println((i+1) + ". " + foods.get(i).getName());
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
                if(itemNumber > items.size()){
                    System.out.println("Item not found");
                }else{
                    items.get(itemNumber-1).use(currentPerson);
                }
                break;
            case 2:
                System.out.println("Sell Item");
                System.out.print("Enter item number : ");
                int sellItemNumber = s.nextInt();
                if(sellItemNumber > items.size()){
                    System.out.println("Item not found");
                }else{
                    items.get(sellItemNumber-1).sellItem(currentPerson);
                }
                break;
            case 3:
                
                return;
        }
    }
    //#endregion
    
    //#region activities

    private void doActivities(){
        System.out.println("Activities Menu");
        System.out.println("1. Physical Activity");
        System.out.println("2. Mental Activity");
        System.out.println("3. Spiritual Activity");
    }
    private void createActivity(){
        System.out.println("Create Activity Menu");
        System.out.println("1. Create Physical Activity");
        System.out.println("2. Create Mental Activity");
        System.out.println("3. Create Spiritual Activity");
    }
    private void PhysicalActivity(){
        System.out.println("Physical Activity Menu");
        System.out.println("1. Exercise");
        System.out.println("2. Eat");
        System.out.println("3. Sleep");
    }
    //#endregion
    private void buyItems(){
        System.out.println("Main Menu");
        System.out.println("1. Food");
        System.out.println("2. Drink");
        System.out.println("3. Medicine");
    }
}
