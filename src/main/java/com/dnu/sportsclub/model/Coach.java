package com.dnu.sportsclub.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coach extends Person {
    private String specialty;
    private List<String> assignedSports;

    public Coach(String id, String name, String phone, String specialty) {
        super(id, name, phone, "coach@" + id + ".email");  // Fix: 4 args, email default → Giờ match
        this.specialty = specialty;
        this.assignedSports = new ArrayList<>();
    }

    // Getters/Setters
    @SuppressWarnings("unused")
    public String getSpecialty() { return specialty; }

    @SuppressWarnings("unused")
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    @SuppressWarnings("unused")
    public List<String> getAssignedSports() { return new ArrayList<>(assignedSports); }

    public void assignSport(String sportId) {
        if (!assignedSports.contains(sportId)) {
            assignedSports.add(sportId);
        }
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +  // Giờ email resolve
                ", specialty='" + specialty + '\'' +
                ", assignedSports=" + assignedSports +
                '}';
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên HLV: ");
        setName(scanner.nextLine());
        System.out.print("Nhập số điện thoại: ");
        setPhone(scanner.nextLine());
        System.out.print("Nhập email: ");
        setEmail(scanner.nextLine());
        System.out.print("Nhập chuyên môn: ");
        setSpecialty(scanner.nextLine());
        setId("C" + System.currentTimeMillis() % 10000);
    }
}