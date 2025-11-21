package com.dnu.sportsclub.interfaces;

import com.dnu.sportsclub.model.Schedule;
import com.dnu.sportsclub.exception.ScheduleConflictException;

public interface Schedulable {
    void registerSchedule(Schedule schedule) throws ScheduleConflictException;
}