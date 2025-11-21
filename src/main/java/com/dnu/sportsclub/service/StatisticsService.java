package com.dnu.sportsclub.service;

import com.dnu.sportsclub.model.Competition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsService {

    public void printTop5(List<Competition> competitions) {
        if (competitions.isEmpty()) {
            System.out.println("Chưa có giải đấu nào để thống kê!");
            return;
        }

        System.out.println("\n=== THỐNG KÊ TOP 5 THÀNH VIÊN ===");
        Map<String, Double> totalScores = new HashMap<>();

        for (Competition comp : competitions) {

            Map<String, Double> results = comp.getResults();
            results.forEach((memberId, score) ->
                    totalScores.put(memberId, totalScores.getOrDefault(memberId, 0.0) + score)
            );


            System.out.println("\nBáo cáo thành tích " + comp.getName() + ":");
            System.out.println(comp.getStandings());
        }


        List<Map.Entry<String, Double>> top5 = totalScores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop 5 thành viên (tổng điểm):");
        top5.forEach(entry ->
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " điểm")  // "Điểm" giữ nguyên, đúng tiếng Việt
        );
    }
}