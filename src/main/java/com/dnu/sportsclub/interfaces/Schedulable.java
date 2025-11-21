package com.dnu.sportsclub.interfaces;

<<<<<<< HEAD

import java.time.LocalDate;
import java.time.LocalTime;

public interface Schedulable {

    String getScheduleId();

    LocalDate getScheduleDate();

    LocalTime getStartTime();

    LocalTime getEndTime();
=======
import com.dnu.sportsclub.model.Schedule;
import com.dnu.sportsclub.exception.ScheduleConflictException;

public interface Schedulable {
    void registerSchedule(Schedule schedule) throws ScheduleConflictException;
>>>>>>> Quy
}