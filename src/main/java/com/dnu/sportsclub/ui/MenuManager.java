package com.dnu.sportsclub.ui;

import com.dnu.sportsclub.common.DateUtils;
import com.dnu.sportsclub.exception.ScheduleConflictException;
import com.dnu.sportsclub.exception.MemberNotFoundException;
import com.dnu.sportsclub.exception.CoachNotFoundException;
import com.dnu.sportsclub.model.*;
import com.dnu.sportsclub.model.League;
import com.dnu.sportsclub.model.Tournament;
import com.dnu.sportsclub.service.*;
import java.util.List;
import java.util.Scanner;

public class MenuManager {
    private final DataService dataService = new DataService();
    private final ScheduleService scheduleService = new ScheduleService(dataService.schedules);
    private final StatisticsService statsService = new StatisticsService();
    private final MemberService memberService = new MemberService(dataService.members);
    private final CoachService coachService = new CoachService(dataService.coaches);
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        seedData(); // Tạo dữ liệu mẫu

        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ CÂU LẠC BỘ THỂ THAO ===");
            System.out.println("1. Xem danh sách Thành viên");
            System.out.println("2. Thêm HLV & Môn thể thao");
            System.out.println("3. Đặt lịch tập (Kiểm tra trùng)");
            System.out.println("4. Nhập điểm giải đấu");
            System.out.println("5. Thống kê Top 5");
            System.out.println("6. Thêm thành viên mới");
            System.out.println("7. Thêm huấn luyện viên mới");
            System.out.println("8. Phân công HLV cho Môn thể thao");
            System.out.println("9. Tạo giải đấu mới");
            System.out.println("10. Thêm thành viên vào giải đấu");
            System.out.println("0. Lưu và Thoát");
            System.out.print("Chọn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        dataService.members.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Đã thêm HLV Park và Môn Bóng đá (Demo)");
                        dataService.coaches.add(new Coach("C01", "Park Hang Seo", "0909", "Football"));
                        dataService.sports.add(new Football("SP01", "V-League", "C01"));
                        break;
                    case 3:
                        System.out.println("Đang đặt lịch cho HLV C01...");
                        Schedule s = new Schedule("SCH01", "SP01", "C01",
                                DateUtils.nowPlusHours(1), DateUtils.nowPlusHours(3));
                        scheduleService.registerSchedule(s);
                        break;
                    case 4:
                        if (dataService.competitions.isEmpty()) dataService.competitions.add(new League("L01", "Cup Mùa Hè"));
                        Competition c = dataService.competitions.get(0);  // Biến c ở đây (scope chung)
                        if (!dataService.members.isEmpty()) {
                            c.addScore(dataService.members.get(0).getId(), 10.5);
                            System.out.println("Đã cộng điểm cho " + dataService.members.get(0).getName());
                        }
                        break;
                    case 5:
                        statsService.printTop5(dataService.competitions);
                        break;
                    case 6:
                        System.out.print("Nhập tên thành viên: ");
                        String inputName = sc.nextLine();  // Đổi tên tạm để tránh trùng 'name'
                        System.out.print("Nhập số điện thoại: ");
                        String phone = sc.nextLine();
                        Member newMember = new Member("M" + (dataService.members.size() + 1), inputName, phone);
                        memberService.add(newMember);
                        System.out.println("Đã thêm thành viên mới: " + newMember.getName());
                        break;
                    case 7:
                        System.out.print("Nhập tên HLV: ");
                        inputName = sc.nextLine();  // Reuse inputName
                        System.out.print("Nhập số điện thoại: ");
                        phone = sc.nextLine();
                        System.out.print("Nhập chuyên môn: ");
                        String specialty = sc.nextLine();
                        Coach newCoach = new Coach("C" + (dataService.coaches.size() + 1), inputName, phone, specialty);
                        coachService.add(newCoach);
                        System.out.println("Đã thêm HLV mới: " + newCoach.getName());
                        break;
                    case 8:
                        System.out.print("Nhập ID HLV: ");
                        String coachId = sc.nextLine();
                        System.out.print("Nhập ID Môn thể thao: ");
                        String sportId = sc.nextLine();
                        coachService.assignToSport(coachId, sportId);
                        System.out.println("Đã phân công HLV " + coachId + " cho môn " + sportId);
                        break;
                    case 9:
                        System.out.print("Nhập tên giải đấu: ");
                        String compName = sc.nextLine();
                        System.out.print("Loại (League/Tournament): ");
                        String type = sc.nextLine();
                        Competition newComp = type.equalsIgnoreCase("League") ?
                                new League("COMP" + (dataService.competitions.size() + 1), compName) :
                                new Tournament("COMP" + (dataService.competitions.size() + 1), compName);
                        dataService.competitions.add(newComp);
                        System.out.println("Đã tạo giải đấu mới: " + compName);
                        break;
                    case 10:
                        if (dataService.competitions.isEmpty()) {
                            System.out.println("Chưa có giải đấu nào! Hãy tạo trước.");
                            break;
                        }
                        System.out.print("Nhập ID giải đấu: ");
                        String compId = sc.nextLine();
                        System.out.print("Nhập ID thành viên: ");
                        String memId = sc.nextLine();
                        Competition selectedComp = dataService.competitions.stream()  // Fix: Đổi tên thành selectedComp (tránh trùng 'c')
                                .filter(cmp -> cmp.getId().equals(compId)).findFirst().orElse(null);  // cmp thay vì c để tránh nested scope issue
                        if (selectedComp != null && dataService.members.stream().anyMatch(m -> m.getId().equals(memId))) {
                            selectedComp.addMember(memId);
                            System.out.println("Đã thêm thành viên " + memId + " vào giải đấu " + compId);
                        } else {
                            System.out.println("Không tìm thấy giải đấu hoặc thành viên!");
                        }
                        break;
                    case 0:
                        dataService.saveAll();
                        System.out.println("Đã lưu dữ liệu và thoát!");
                        System.exit(0);
                    default: System.out.println("Sai lựa chọn!");
                }
            } catch (ScheduleConflictException e) {
                System.out.println("LỖI: " + e.getMessage());
            } catch (MemberNotFoundException | CoachNotFoundException e) {
                System.out.println("LỖI: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu: Vui lòng nhập số nguyên!");
            } catch (Exception e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }

    private void seedData() {
        if (dataService.members.isEmpty()) {
            dataService.members.add(new Member("M01", "Nguyễn Văn A", "0123"));
            dataService.members.add(new Member("M02", "Trần Thị B", "0456"));
        }
        if (dataService.coaches.isEmpty()) {
            dataService.coaches.add(new Coach("C01", "Park Hang Seo", "0909", "Football"));
        }
        if (dataService.sports.isEmpty()) {
            dataService.sports.add(new Football("SP01", "V-League", "C01"));
        }
        if (dataService.schedules.isEmpty()) {
            Schedule sampleSchedule = new Schedule("SCH01", "SP01", "C01",
                    DateUtils.nowPlusHours(1), DateUtils.nowPlusHours(3));
            dataService.schedules.add(sampleSchedule);
        }
        if (dataService.competitions.isEmpty()) {
            dataService.competitions.add(new League("L01", "Cup Mùa Hè"));
        }
    }
}