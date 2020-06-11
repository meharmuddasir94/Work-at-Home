package com.example.work_at_home;

public class Singleton {
public static  int value;
private static final Singleton ourInstance = new Singleton();
    public static Singleton getInstance() {
        return ourInstance;
    }
    private Singleton() { }
    public void setText(int value) {
        this.value = value;
    }
    public int getText() {
        return value;
    }
}


