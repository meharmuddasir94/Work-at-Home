package com.example.work_at_home;

public class UserModelClass {
    String email;
    String name;

    public UserModelClass() {
    }
    public UserModelClass(String email, String name) {
        this.email = email;
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
