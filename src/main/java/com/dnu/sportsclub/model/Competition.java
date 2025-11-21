package com.dnu.sportsclub.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Competition {
    protected String id;
    protected String name;
    protected String date;
    protected List<String> members;
    protected Map<String, Double> scores;  // ID -> score

    public Competition(String id, String name) {
        this.id = id;
        this.name = name;
        this.date = "2025-11-21";  // Default
        this.members = new ArrayList<>();
        this.scores = new HashMap<>();
    }

    // Getters/Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getMembers() { return new ArrayList<>(members); }

    // Fix: Thêm getResults() cho thống kê (test case 9-10)
    public Map<String, Double> getResults() {
        return new HashMap<>(scores);  // Trả copy map scores (encapsulation)
    }

    public void addMember(String memberId) {
        if (!members.contains(memberId)) {
            members.add(memberId);
        }
    }

    public void addScore(String memberId, double score) {
        scores.put(memberId, scores.getOrDefault(memberId, 0.0) + score);
    }

    // Abstract methods (polymorphism)
    public abstract void updateResult(String winner);
    public abstract String getStandings();

    @Override
    public String toString() {
        return "Competition{id='" + id + "', name='" + name + "', members=" + members.size() + "}";
    }
}