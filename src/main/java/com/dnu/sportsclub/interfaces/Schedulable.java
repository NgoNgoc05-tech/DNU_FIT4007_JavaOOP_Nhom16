package com.dnu.sportsclub.interfaces;

// Import class Schedule từ package model (theo cấu trúc cây thư mục của bạn)
import com.dnu.sportsclub.model.abstract_class.Schedule;
// Import Exception tùy biến
import com.dnu.sportsclub.exception.ScheduleConflictException;

public interface Schedulable {

    /**
     * Phương thức đăng ký lịch tập mới.
     * * @param schedule Đối tượng lịch cần đăng ký.
     * @throws ScheduleConflictException Ném lỗi nếu phát hiện trùng lịch (HLV bận, Sân bận...).
     */
    void registerSchedule(Schedule schedule) throws ScheduleConflictException;
}