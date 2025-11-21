package com.dnu.sportsclub.interfaces;


import java.time.LocalDate;
import java.time.LocalTime;

public interface Schedulable {

    String getScheduleId();

    LocalDate getScheduleDate();

    LocalTime getStartTime();

    LocalTime getEndTime();
}