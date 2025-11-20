package main.java.com.dnu.sportsclub.model.enum_type;

public enum ScheduleStatus {
    SCHEDULED("Đã lên lịch"),
    COMPLETED("Đã hoàn thành"),
    CANCELLED("Đã hủy");

    private final String description;

    ScheduleStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}