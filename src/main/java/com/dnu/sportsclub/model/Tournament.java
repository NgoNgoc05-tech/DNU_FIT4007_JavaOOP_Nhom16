package com.dnu.sportsclub.model;

import java.util.HashMap;
import java.util.Map;

public class Tournament extends Competition {
    private Map<String, Integer> rankings;  // ID -> rank (cho top 5)

    public Tournament(String id, String name) {
        super(id, name);
        this.rankings = new HashMap<>();
    }

    @Override
    public void updateResult(String winner) {
        // Logic: Cập nhật ranking cho winner
        rankings.put(winner, rankings.getOrDefault(winner, 0) + 1);
        System.out.println("Cập nhật kết quả Tournament: " + winner + " thắng!");
    }

    @Override
    public String getStandings() {
        // Test case 9: Báo cáo thành tích
        StringBuilder sb = new StringBuilder("Báo cáo Tournament " + name + ":\n");
        rankings.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> sb.append(e.getKey()).append(": Rank ").append(e.getValue()).append("\n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " (Tournament)";
    }
}