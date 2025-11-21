package main.java.com.dnu.sportsclub.model.abstract_class;

public class Member extends Person {
    private double totalScore; // Dùng để tính Top 5 thành tích

    public Member(String id, String name, String phone) {
        super(id, name, phone);
        this.totalScore = 0;
    }

    public void addScore(double score) { this.totalScore += score; }
    public double getTotalScore() { return totalScore; }

    @Override
    public String toString() {
        return String.format("Member [ID: %s, Name: %s, Score: %.1f]", id, name, totalScore);
    }
}
