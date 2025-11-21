package com.dnu.sportsclub.model;

import java.util.Map;

public class League extends Competition {
    public League(String id, String name) {
        super(id, name);
    }

    @Override
    public void updateResult(String winner) {
        // Logic League: Cộng điểm
        addScore(winner, 3.0);  // Ví dụ: 3 điểm thắng
        System.out.println("Cập nhật kết quả League: " + winner + " được 3 điểm!");
    }

    @Override
    public String getStandings() {
        // Test case 9: Báo cáo (dựa scores)
        StringBuilder sb = new StringBuilder("Báo cáo League " + name + ":\n");
        scores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> sb.append(e.getKey()).append(": ").append(e.getValue()).append(" điểm\n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " (League)";
    }
}