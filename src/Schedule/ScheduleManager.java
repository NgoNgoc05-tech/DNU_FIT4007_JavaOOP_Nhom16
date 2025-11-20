package main.java.com.dnu.sportsclub.manager;

import main.java.com.dnu.sportsclub.model.entity.Schedule;
import main.java.com.dnu.sportsclub.exception.ScheduleConflictException;
import main.java.com.dnu.sportsclub.model.enum_type.ScheduleStatus;
import main.java.com.dnu.sportsclub.repository.FileRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Schedule> scheduleList;

    private static final String FILE_NAME = "schedule.dat";

    public ScheduleManager() {
        this.scheduleList = FileRepository.load(FILE_NAME);
        if (this.scheduleList == null) {
            this.scheduleList = new ArrayList<>();
        }
    }

    public void validateSchedule(Schedule newSchedule) throws ScheduleConflictException {
        LocalDateTime newStart = newSchedule.getStartTime();
        LocalDateTime newEnd = newSchedule.getEndTime();
        String newCoachId = newSchedule.getCoachId();

        for (Schedule existingSchedule : scheduleList) {
            if (existingSchedule.getStatus() == ScheduleStatus.SCHEDULED &&
                    existingSchedule.getCoachId().equals(newCoachId)) {

                LocalDateTime existingStart = existingSchedule.getStartTime();
                LocalDateTime existingEnd = existingSchedule.getEndTime();

                if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
                    throw new ScheduleConflictException("HLV " + newCoachId + " đã trùng lịch tập: " + existingSchedule.getScheduleId());
                }
            }
        }
    }

    // PHƯƠNG THỨC 1 BỊ LỖI: addSchedule
    public void addSchedule(Schedule newSchedule) {
        try {
            validateSchedule(newSchedule);
            scheduleList.add(newSchedule);
            FileRepository.save(scheduleList, FILE_NAME); // Lưu lại
            System.out.println("Thêm lịch tập thành công!");
        } catch (ScheduleConflictException e) {
            System.err.println("LỖI THÊM LỊCH: " + e.getMessage());
        }
    }

    // PHƯƠNG THỨC 2 BỊ LỖI: saveData
    public void saveData() {
        FileRepository.save(scheduleList, FILE_NAME);
    }

    // PHƯƠNG THỨC 3 BỊ LỖI: getScheduleList
    // Cần thiết để Main có thể duyệt danh sách và in ra
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    // ... Các hàm CRUD khác (nếu có) ...
}