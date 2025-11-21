package main.java.com.dnu.sportsclub.model.abstract_class;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id, sportId, coachId;
    private LocalDateTime start, end;
    private String status; // SCHEDULED, COMPLETED

    public Schedule(String id, String sportId, String coachId, LocalDateTime start, LocalDateTime end) {
        this.id = id; this.sportId = sportId; this.coachId = coachId;
        this.start = start; this.end = end;
        this.status = "SCHEDULED";
    }

    public String getCoachId() { return coachId; }
    public LocalDateTime getStart() { return start; }
    public LocalDateTime getEnd() { return end; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Lịch [ID: %s | Môn: %s | %s - %s]", id, sportId, start, end);
    }
}