package model;

import java.util.*;

public class Job {
    private String name;
    private double salary;

    private ArrayList<Activity> activities = new ArrayList<>();

    public Job(String name, double salary) {
        this.name = name;
        this.salary = salary;
        switch(this.name) {
            case "Software Engineer":
                activities.add(new Activity("Coding Session", -10, -10, -5, 100, "Work", 4));
                activities.add(new Activity("Code Review", -5, -2, -2, 50, "Work", 2));
                activities.add(new Activity("Debugging", -8, -5, -5, 80, "Work", 3));
                break;
            case "Data Scientist":
                activities.add(new Activity("Analyze Data", -5, -5, -5, 70, "Work", 4));
                activities.add(new Activity("Build ML Model", -8, -8, -5, 120, "Work", 5));
                activities.add(new Activity("Data Cleaning", -3, -3, -3, 50, "Work", 3));
                break;
            case "Doctor":
                activities.add(new Activity("Patient Consultation", -5, -5, -5, 100, "Work", 3));
                activities.add(new Activity("Surgery", -10, -10, -12, 200, "Work", 5));
                activities.add(new Activity("Medical Research", -6, -6, -5, 150, "Work", 4));
                break;
            case "Teacher":
                activities.add(new Activity("Classroom Teaching", -4, -4, -4, 70, "Work", 6));
                activities.add(new Activity("Grade Papers", -5, -5, -5, 60, "Work", 3));
                activities.add(new Activity("Prepare Lesson", -3, -3, -3, 50, "Work", 2));
                break;
            case "Chef":
                activities.add(new Activity("Cook Gourmet Meal", -6, -6, -6, 120, "Work", 5));
                activities.add(new Activity("Create New Recipe", -5, -5, -5, 100, "Work", 3));
                activities.add(new Activity("Kitchen Management", -4, -4, -4, 80, "Work", 4));
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