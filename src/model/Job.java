package model;

import java.util.*;

public class Job {
    private String name;
    private double salary;

    private ArrayList<Activity> activities = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
}