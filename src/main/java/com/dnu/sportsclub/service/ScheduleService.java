package com.dnu.sportsclub.service;

import com.dnu.sportsclub.exception.ScheduleConflictException;
import com.dnu.sportsclub.interfaces.Schedulable;
import com.dnu.sportsclub.model.Schedule;
import java.util.List;

public class ScheduleService implements Schedulable {
    private final List<Schedule> existingSchedules;

    public ScheduleService(List<Schedule> existingSchedules) {
        this.existingSchedules = existingSchedules;
    }

    @Override
    public void registerSchedule(Schedule newSched) throws ScheduleConflictException {
        for (Schedule s : existingSchedules) {
            // Logic: Nếu trùng HLV và thời gian đè lên nhau
            if (s.getCoachId().equals(newSched.getCoachId())) {
                if (newSched.getStartTime().isBefore(s.getEndTime()) &&
                        newSched.getEndTime().isAfter(s.getStartTime())) {
                    throw new ScheduleConflictException("HLV " + s.getCoachId() + " đang bận!");
                }
            }
        }
        existingSchedules.add(newSched);
        System.out.println("Đăng ký lịch thành công!");
    }
}