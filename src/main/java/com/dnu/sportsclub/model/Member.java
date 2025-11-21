package com.dnu.sportsclub.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Member extends Person {
    private List<String> sportsJoined;
    private List<String> achievements;

    public Member(String id, String name, String phone) {
        super(id, name, phone, "member@" + id + ".email");  // Fix: 4 args, email default
        this.sportsJoined = new ArrayList<>();
        this.achievements = new ArrayList<>();
    }

    // Getters/Setters
    public List<String> getSportsJoined() { return new ArrayList<>(sportsJoined); }
    public void addSport(String sportId) { sportsJoined.add(sportId); }
    public List<String> getAchievements() { return new ArrayList<>(achievements); }
    public void addAchievement(String ach) { achievements.add(ach); }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sportsJoined=" + sportsJoined +
                '}';
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên thành viên: ");
        setName(scanner.nextLine());
        System.out.print("Nhập số điện thoại: ");
        setPhone(scanner.nextLine());
        System.out.print("Nhập email (optional): ");
        setEmail(scanner.nextLine());
        setId("M" + System.currentTimeMillis() % 10000);
    }
}