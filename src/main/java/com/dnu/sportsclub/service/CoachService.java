package com.dnu.sportsclub.service;

import com.dnu.sportsclub.exception.CoachNotFoundException;
import com.dnu.sportsclub.model.Coach;
import java.util.List;

public record CoachService(List<Coach> coaches) {
    // Methods giữ nguyên (record hỗ trợ methods)
    public void add(Coach coach) {
        if (coach != null) {
            coaches.add(coach);
            System.out.println("Thêm HLV thành công: " + coach.getName());
        }
    }

    public void assignToSport(String coachId, String sportId) {
        Coach foundCoach = findById(coachId);
        if (foundCoach != null) {
            foundCoach.assignSport(sportId);
            System.out.println("Phân công thành công cho HLV: " + foundCoach.getName());
        } else {
            throw new CoachNotFoundException("Không tìm thấy HLV ID: " + coachId);
        }
    }

    private Coach findById(String id) {
        return coaches.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // getAll auto từ record (coaches())
    public List<Coach> getAll() {
        return coaches;
    }
}