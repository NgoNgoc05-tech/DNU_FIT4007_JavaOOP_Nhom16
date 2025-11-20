package main.java.com.dnu.sportsclub.model.entity;

import main.java.com.dnu.sportsclub.model.enum_type.ScheduleStatus;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scheduleId;
    private String sportName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String coachId;
    private ScheduleStatus status;

    // Constructor
    public Schedule(String scheduleId, String sportName, LocalDateTime startTime, LocalDateTime endTime, String coachId) {
        this.scheduleId = scheduleId;
        this.sportName = sportName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.coachId = coachId;
        this.status = ScheduleStatus.SCHEDULED;
    }

    public String getScheduleId() { return scheduleId; } // Thêm getter cho ID
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public String getCoachId() { return coachId; }
    public ScheduleStatus getStatus() { return status; }
    public void setStatus(ScheduleStatus status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("ID: %s | Môn: %s | Thời gian: %s -> %s | HLV: %s | Trạng thái: %s",
                scheduleId, sportName, startTime.toLocalTime(), endTime.toLocalTime(), coachId, status.getDescription());
    }
}