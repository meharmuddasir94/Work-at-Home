package com.example.work_at_home;

public class Chat {
    String sender;
    String receviver;
    String  message;

    public Chat() {
    }

    public Chat(String sender, String receviver, String message) {
        this.sender = sender;
        this.receviver = receviver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getReceviver() {
        return receviver;
    }

    public String getMessage() {
        return message;
    }
}
