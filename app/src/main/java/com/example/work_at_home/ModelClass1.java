package com.example.work_at_home;

public class ModelClass1{
    String Budget;
    String Description;
    String Email;
    String Time;

    public ModelClass1() {
    }

    public ModelClass1(String description, String time, String budget, String email) {
        this. Budget = budget;
        this. Description = description;
        this. Email = email;
        this. Time = time;

    }

    public String getDescription() {
        return Description;
    }

    public String getTime() {
        return Time;
    }

    public String getBudget() {
        return Budget;
    }

    public String getEmail() {
        return Email;
    }
}
