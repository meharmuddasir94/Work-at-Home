package com.example.work_at_home;

public class ModelClass {
    String Description;
    String Time;
    String Budget;
    String Category;

    public ModelClass() {
    }

    public ModelClass(String description, String time, String budget, String category) {
        this.Description = description;
        this.Time = time;
        this.Budget = budget;
        this.Category = category;
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

    public String getCategory() {
        return Category;
    }
}
