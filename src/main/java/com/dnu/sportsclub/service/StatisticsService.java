package com.dnu.sportsclub.service;

import com.dnu.sportsclub.model.abstract_class.Competition; // <-- SỬA Ở ĐÂY
import com.dnu.sportsclub.model.abstract_class.Member;      // <-- SỬA Ở ĐÂY
import java.util.*;

public class StatisticsService {
    private final DataService dataService;

    public StatisticsService(DataService dataService) {
        this.dataService = dataService;
    }

    public void printTop5Members() {
        // 1. Cộng dồn điểm từ tất cả giải đấu
        Map<String, Double> tempScores = new HashMap<>();

        for (Competition c : dataService.competitions) {
            c.getResults().forEach((mId, score) ->
                    tempScores.merge(mId, score, Double::sum)
            );
        }

        // 2. Sort và in ra Top 5 dùng Stream API
        System.out.println("--- TOP 5 THÀNH VIÊN XUẤT SẮC NHẤT ---");
        tempScores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .forEach(e -> {
                    Member m = dataService.findMemberById(e.getKey());
                    String name = (m != null) ? m.getName() : "Unknown (Đã xóa)";
                    System.out.printf("Member: %s | Score: %.1f\n", name, e.getValue());
                });
    }
}