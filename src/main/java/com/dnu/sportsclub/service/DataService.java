package com.dnu.sportsclub.service;

import com.dnu.sportsclub.model.abstract_class.*; // <-- SỬA Ở ĐÂY
import com.dnu.sportsclub.repository.FileRepository;
import java.util.List;

public class DataService {
    // Khai báo các Repository
    public FileRepository<Member> memberRepo = new FileRepository<>("members.dat");
    public FileRepository<Coach> coachRepo = new FileRepository<>("coaches.dat");
    public FileRepository<Sport> sportRepo = new FileRepository<>("sports.dat");
    public FileRepository<Schedule> scheduleRepo = new FileRepository<>("schedules.dat");
    public FileRepository<Competition> competitionRepo = new FileRepository<>("competitions.dat");

    // Lists in-memory
    public List<Member> members;
    public List<Coach> coaches;
    public List<Sport> sports;
    public List<Schedule> schedules;
    public List<Competition> competitions;

    public DataService() {
        loadAll();
    }

    public void loadAll() {
        members = memberRepo.load();
        coaches = coachRepo.load();
        sports = sportRepo.load();
        schedules = scheduleRepo.load();
        competitions = competitionRepo.load();
    }

    public void saveAll() {
        memberRepo.save(members);
        coachRepo.save(coaches);
        sportRepo.save(sports);
        scheduleRepo.save(schedules);
        competitionRepo.save(competitions);
        System.out.println("Đã lưu dữ liệu thành công!");
    }

    // Helper methods tìm kiếm
    public Coach findCoachById(String id) {
        return coaches.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
    public Member findMemberById(String id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }
}