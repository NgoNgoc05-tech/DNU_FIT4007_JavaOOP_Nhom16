package com.dnu.sportsclub.model;
import com.dnu.sportsclub.common.DateUtils;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id, sportId, coachId;
    private LocalDateTime startTime, endTime;

    public Schedule(String id, String sportId, String coachId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id; this.sportId = sportId; this.coachId = coachId;
        this.startTime = startTime; this.endTime = endTime;
    }

    public String getCoachId() { return coachId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }

    @Override public String toString() {
        return String.format("Lịch [%s]: HLV %s | %s -> %s",
                id, coachId, DateUtils.toString(startTime), DateUtils.toString(endTime));
    }
}