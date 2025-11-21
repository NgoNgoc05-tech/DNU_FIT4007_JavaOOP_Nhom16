package main.java.com.dnu.sportsclub.model.abstract_class;

import java.io.Serializable;
public abstract class Sport implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id, name, coachId;

    public Sport(String id, String name, String coachId) {
        this.id = id; this.name = name; this.coachId = coachId;
    }

    public String getId() { return id; }
    public String getCoachId() { return coachId; }

    // Yêu cầu đề bài: override để trả về mô tả lịch tập
    public abstract String getTrainingScheduleDescription();

    @Override
    public String toString() {
        return String.format("Sport [ID: %s, Name: %s, CoachID: %s]", id, name, coachId);
    }
}

