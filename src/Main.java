package main.java.com.dnu.sportsclub;

import main.java.com.dnu.sportsclub.model.entity.Schedule;
import main.java.com.dnu.sportsclub.manager.ScheduleManager;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("        CHƯƠNG TRÌNH QUẢN LÝ LỊCH TẬP       ");
        System.out.println("==========================================");

        System.out.println("--- 1. KHỞI TẠO MANAGER ---");
        ScheduleManager manager = new ScheduleManager();
        System.out.println("Số lượng lịch tập hiện tại: " + manager.getScheduleList().size());
        System.out.println("------------------------------------------\n");

        LocalDateTime start1 = LocalDateTime.of(2025, 12, 5, 14, 0);
        LocalDateTime end1 = LocalDateTime.of(2025, 12, 5, 16, 0);
        Schedule s1 = new Schedule("S001", "Bóng đá", start1, end1, "C001");

        LocalDateTime start2 = LocalDateTime.of(2025, 12, 5, 17, 0);
        LocalDateTime end2 = LocalDateTime.of(2025, 12, 5, 19, 0);
        Schedule s2 = new Schedule("S002", "Bóng chuyền", start2, end2, "C002");

        LocalDateTime start3 = LocalDateTime.of(2025, 12, 5, 15, 0);
        LocalDateTime end3 = LocalDateTime.of(2025, 12, 5, 17, 0);
        Schedule s3_conflict = new Schedule("S003", "Yoga", start3, end3, "C001");

        System.out.println("--- 2. THỬ NGHIỆM THÊM LỊCH TẬP ---");
        manager.addSchedule(s1);
        manager.addSchedule(s2);
        System.out.println("------------------------------------------");

        System.out.println("--- 3. THỬ NGHIỆM THÊM LỊCH BỊ TRÙNG (S003) ---");
        manager.addSchedule(s3_conflict); // Sẽ in ra lỗi
        System.out.println("------------------------------------------\n");

        System.out.println("--- 4. DANH SÁCH LỊCH TẬP HIỆN TẠI (" + manager.getScheduleList().size() + ") ---");
        for (Schedule s : manager.getScheduleList()) {
            System.out.println(s);
        }
        System.out.println("==========================================");

        manager.saveData();
    }
}