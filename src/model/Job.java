package model;

import java.util.*;

public class Job {
    private String name;
    private double salary;

    private LinkedList<Activity> activities = new LinkedList<>();

    private Scanner s = new Scanner(System.in);

    public Job(String name, double salary) {
        this.name = name;
        this.salary = salary;
        switch(this.name) {
            case "Software Engineer":
                activities.add(new Activity("Coding Session", -20, -20, -10, 100, "Work", 4));
                activities.add(new Activity("Code Review", -10, -5, -5, 50, "Work", 2));
                activities.add(new Activity("Debugging", -15, -10, -10, 80, "Work", 3));
                break;
            case "Data Scientist":
                activities.add(new Activity("Analyze Data", -10, -10, -10, 70, "Work", 4));
                activities.add(new Activity("Build ML Model", -15, -15, -10, 120, "Work", 5));
                activities.add(new Activity("Data Cleaning", -8, -8, -8, 50, "Work", 3));
                break;
            case "Doctor":
                activities.add(new Activity("Patient Consultation", -10, -10, -10, 100, "Work", 3));
                activities.add(new Activity("Surgery", -20, -20, -15, 200, "Work", 5));
                activities.add(new Activity("Medical Research", -12, -12, -10, 150, "Work", 4));
                break;
            case "Teacher":
                activities.add(new Activity("Classroom Teaching", -8, -8, -8, 70, "Work", 6));
                activities.add(new Activity("Grade Papers", -10, -10, -10, 60, "Work", 3));
                activities.add(new Activity("Prepare Lesson", -7, -7, -7, 50, "Work", 2));
                break;
            case "Chef":
                activities.add(new Activity("Cook Gourmet Meal", -12, -12, -12, 120, "Work", 5));
                activities.add(new Activity("Create New Recipe", -10, -10, -10, 100, "Work", 3));
                activities.add(new Activity("Kitchen Management", -8, -8, -8, 80, "Work", 4));
                break;
        }
    }
    public int showWorkActivities(Person currentPerson, int currentHour){
        boolean stillWorking = true;
        int duration = 0;
        while (stillWorking) {
            int choice = -1;
            do{
                System.out.println("==== [Work Activities] ====");
                System.out.println("Current Hour: " + currentHour + ":00");
                System.out.println();
                currentPerson.showStatus();

                if(currentPerson.isLostBalance()) {
                    stillWorking = false;
                    return duration;
                }

                System.out.println();
                System.out.printf("%-3s %-25s %-10s %-10s %-10s %-10s %-10s\n", "#", "Name", "Duration", "Salary", "Physical", "Mental", "Spiritual");

                for (int i = 0; i < activities.size(); i++) {
                    Activity a = activities.get(i);
                    System.out.printf("%-3d %-25s %-10d %-10.2f %-10d %-10d %-10d\n",
                        (i + 1),
                        a.getName(),
                        a.getActivityDuration(),
                        a.getMoney(),
                        a.getPhysicalEffect(),
                        a.getMentalEffect(),
                        a.getSpiritualEffect());
                }
                System.out.println("0. Exit");
                System.out.print("Choose an activity : ");
                choice = s.nextInt();
                System.out.println();

                if (choice < 0 || choice > activities.size()) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while(choice < 0 || choice > activities.size());
            
            if(choice == 0){
                if (duration < 8) {
                    System.out.println("You can't go back because you have to work at least 8 hours");
                } else {
                    stillWorking = false;
                }
            } else{
                Activity selectedActivity = activities.get(choice - 1);
                
                duration += selectedActivity.doActivity(currentPerson);
                
                for (int i = 0; i < selectedActivity.getActivityDuration(); i++) {
                    currentHour++;
                    if (currentHour > 24) {
                        currentHour = 1;
                    }
                }
            }
        }
        return duration;
    }
    
    public void createWork() {
        System.out.println("==== [Create Work] ====");
        System.out.print("Enter work name: ");
        String workName = s.next();
        int physicalEffect;
        do {
            System.out.print("Enter physical effect (between -20 and -10) : ");
            physicalEffect = s.nextInt();
            if (physicalEffect < -20 || physicalEffect > -10) {
                System.out.println("Physical effect must be between -20 and -10");
            }
        } while (physicalEffect < -20 || physicalEffect > -10);

        int mentalEffect;
        do {
            System.out.print("Enter mental effect (between -20 and -10) : ");
            mentalEffect = s.nextInt();
            if (mentalEffect < -20 || mentalEffect > -10) {
                System.out.println("Mental effect must be between -20 and -10");
            }
        } while (mentalEffect < -20 || mentalEffect > -10);

        int spiritualEffect;
        do {
            System.out.print("Enter spiritual effect (between -20 and -10) : ");
            spiritualEffect = s.nextInt();
            if (spiritualEffect < -20 || spiritualEffect > -10) {
                System.out.println("Spiritual effect must be between -20 and -10");
            }
        } while (spiritualEffect < -20 || spiritualEffect > -10);
        
        System.out.print("Enter extra money earned: ");
        double extraMoney = s.nextDouble();
        System.out.println("Enter activity duration: ");
        int activityDuration = s.nextInt();

        Activity a = new Activity(workName, physicalEffect, mentalEffect, spiritualEffect, extraMoney, "Work", activityDuration);
        this.activities.add(a);
        System.out.println("Work created successfully.");
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LinkedList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(LinkedList<Activity> activities) {
        this.activities = activities;
    }
}