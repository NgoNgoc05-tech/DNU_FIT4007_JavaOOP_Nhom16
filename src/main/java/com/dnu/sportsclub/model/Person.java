package com.dnu.sportsclub.model;

import java.util.Scanner;

public abstract class Person {
    protected String id;
    protected String name;
    protected String phone;
    protected String email;  // Email optional

    public Person(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email != null ? email : "";
    }

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public abstract String toString();

    public abstract void inputData(Scanner scanner);
}