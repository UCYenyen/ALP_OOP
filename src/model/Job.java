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
        initializeDefaultActivities();
    }

    private void initializeDefaultActivities() {
        switch(this.name) {
            // Healthy person jobs
            case "Software Engineer":
                activities.add(new Activity("Coding Session", -15, 20, -5, 0, "Work", 4, 200));
                activities.add(new Activity("Code Review", -10, 15, 5, 0, "Work", 2, 100));
                break;
            case "Data Scientist":
                activities.add(new Activity("Analyze Data", -15, 20, -5, 0, "Work", 5, 250));
                activities.add(new Activity("Build ML Model", -10, 25, 0, 0, "Work", 3, 180));
                break;
            case "Doctor":
                activities.add(new Activity("Patient Consultation", -10, 15, 10, 0, "Work", 3, 300));
                activities.add(new Activity("Surgery", -20, 25, 15, 0, "Work", 5, 500));
                break;
            case "Teacher":
                activities.add(new Activity("Classroom Teaching", -5, 10, 15, 0, "Work", 6, 150));
                activities.add(new Activity("Grade Papers", -15, 5, -5, 0, "Work", 3, 80));
                break;
            case "Nurse":
                activities.add(new Activity("Patient Care", 5, -5, 15, 0, "Work", 8, 180));
                activities.add(new Activity("Administer Medication", -5, 10, 10, 0, "Work", 2, 90));
                break;
            case "Accountant":
                activities.add(new Activity("Financial Analysis", -15, 10, -5, 0, "Work", 6, 170));
                activities.add(new Activity("Tax Preparation", -15, 15, -10, 0, "Work", 5, 220));
                break;
            case "Chef":
                activities.add(new Activity("Cook Gourmet Meal", 10, 5, 10, 0, "Work", 5, 160));
                activities.add(new Activity("Create New Recipe", 5, 15, 10, 0, "Work", 3, 120));
                break;
            case "Graphic Designer":
                activities.add(new Activity("Design Project", -10, 15, 5, 0, "Work", 4, 190));
                activities.add(new Activity("Client Meeting", -5, 5, -5, 0, "Work", 2, 80));
                break;
            case "Salesperson":
                activities.add(new Activity("Client Meeting", -5, -5, -10, 0, "Work", 3, 200));
                activities.add(new Activity("Sales Pitch", -10, 5, -5, 0, "Work", 2, 150));
                break;
            case "Marketing Specialist":
                activities.add(new Activity("Campaign Planning", -10, 10, -5, 0, "Work", 5, 210));
                activities.add(new Activity("Market Research", -15, 15, -5, 0, "Work", 4, 170));
                break;
                
            // Sick person jobs
            case "Unemployed":
                activities.add(new Activity("Job Search", -5, -10, -15, 0, "Work", 4, 20));
                activities.add(new Activity("Update Resume", -5, 5, 0, 0, "Work", 2, 0));
                break;
            case "Freelancer":
                activities.add(new Activity("Client Project", -10, 15, 5, 0, "Work", 6, 180));
                activities.add(new Activity("Networking", -10, 0, -5, 0, "Work", 3, 50));
                break;
            case "Part-time Worker":
                activities.add(new Activity("Shift Work", -5, -10, -5, 0, "Work", 4, 80));
                activities.add(new Activity("Training", -5, 5, 0, 0, "Work", 2, 40));
                break;
            case "Consultant":
                activities.add(new Activity("Client Presentation", -10, 10, -5, 0, "Work", 4, 250));
                activities.add(new Activity("Strategic Planning", -10, 20, 0, 0, "Work", 5, 300));
                break;
            case "Retired":
                activities.add(new Activity("Mentoring Session", -5, 5, 15, 0, "Work", 3, 50));
                activities.add(new Activity("Advisory Meeting", -5, 10, 10, 0, "Work", 2, 70));
                break;
            case "Student":
                activities.add(new Activity("Study Session", -10, 15, -5, 0, "Work", 5, 0));
                activities.add(new Activity("Take Exam", -15, -5, -10, 0, "Work", 3, 0));
                break;
            case "Intern":
                activities.add(new Activity("Training Day", -5, 10, -5, 0, "Work", 8, 60));
                activities.add(new Activity("Assistant Work", -5, 5, 0, 0, "Work", 4, 40));
                break;
            case "Volunteer":
                activities.add(new Activity("Community Service", 5, 5, 20, 0, "Work", 4, 0));
                activities.add(new Activity("Charity Event", 10, 10, 25, 0, "Work", 6, 0));
                break;
            case "Researcher":
                activities.add(new Activity("Lab Work", -10, 20, 5, 0, "Work", 6, 150));
                activities.add(new Activity("Write Paper", -15, 15, 0, 0, "Work", 5, 120));
                break;
            case "Artist":
                activities.add(new Activity("Creative Session", -5, 10, 15, 0, "Work", 5, 100));
                activities.add(new Activity("Exhibition", -10, 5, 20, 0, "Work", 4, 150));
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
        System.out.print("Enter extra money earned: ");
        double workSalary = s.nextDouble();
        System.out.println("Enter physical effect: ");
        int physicalEffect = s.nextInt();
        System.out.println("Enter mental effect: ");
        int mentalEffect = s.nextInt();
        System.out.println("Enter spiritual effect: ");
        int spiritualEffect = s.nextInt();
        System.out.println("Enter activity duration: ");
        int activityDuration = s.nextInt();

        Activity a = new Activity(workName, physicalEffect, mentalEffect, spiritualEffect, 0, workName,
                activityDuration, workSalary);
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