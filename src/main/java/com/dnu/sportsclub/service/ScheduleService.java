package com.dnu.sportsclub.service;

import com.dnu.sportsclub.exception.ScheduleConflictException;
import com.dnu.sportsclub.interfaces.Schedulable;
import com.dnu.sportsclub.model.abstract_class.Schedule; // <-- SỬA Ở ĐÂY
import java.util.List;

public class ScheduleService implements Schedulable {
    private final List<Schedule> schedules;

    public ScheduleService(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public void registerSchedule(Schedule newSched) throws ScheduleConflictException {
        for (Schedule s : schedules) {
            // Check trùng HLV
            if (s.getCoachId().equals(newSched.getCoachId())) {
                // Logic: (StartA < EndB) && (EndA > StartB) là bị trùng giờ
                if (newSched.getStart().isBefore(s.getEnd()) && newSched.getEnd().isAfter(s.getStart())) {
                    throw new ScheduleConflictException("HLV đang bận trong khung giờ này!");
                }
            }
        }
        schedules.add(newSched);
    }
}