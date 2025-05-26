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


    public int doWork(Person person) {
        int choice = -1;
        int duration = 0;
        while (choice != 0) {
            do {
                System.out.println("=== [Work] ===");
                System.out.printf("%-3s %-20s %-10s %-10s %-15s %-15s %-15s%n",
                        "No", "Work Name", "Duration", "Salary", "Physical Effect", "Mental Effect",
                        "Spiritual Effect");
                for (int i = 0; i < activities.size(); i++) {
                    Activity act = activities.get(i);
                    System.out.printf("%-3d %-20s %-10d %-10.2f %-15d %-15d %-15d%n",
                            (i + 1),
                            act.getName(),
                            act.getActivityDuration(),
                            act.getSalary(),
                            act.getPhysicalEffect(),
                            act.getMentalEffect(),
                            act.getSpiritualEffect());
                }
                System.out.print("Choice : ");
                choice = s.nextInt();
                System.out.println();
                if (choice < 0 || choice > activities.size()) {
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
                }
            } while (choice < 0 || choice > activities.size());

            if (choice == 0) {
                return duration;
            }
            Activity selectedActivity = activities.get(choice - 1);
            duration = selectedActivity.doActivity(person);

            if (duration > 0) {
                person.setMoney(person.getMoney() + selectedActivity.getSalary());
                System.out.println("You earned $" + selectedActivity.getSalary());
                System.out.println();
            } else {
                System.out.println("You did not earn any money from this activity.");
                System.out.println();
            }
        }
        return duration;
    }

    public void createWork() {
        System.out.println("==== [Create Work] ====");
        System.out.print("Enter work name: ");
        String workName = s.next();
        System.out.println("Enter physical effect: ");
        int physicalEffect = s.nextInt();
        System.out.println("Enter mental effect: ");
        int mentalEffect = s.nextInt();
        System.out.println("Enter spiritual effect: ");
        int spiritualEffect = s.nextInt();
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