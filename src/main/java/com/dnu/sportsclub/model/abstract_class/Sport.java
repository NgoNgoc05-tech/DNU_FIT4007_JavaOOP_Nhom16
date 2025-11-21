package main.java.com.dnu.sportsclub.model.abstract_class;

import java.io.Serializable;

public abstract class Sport implements Serializable {
    private String id;
    private String name;
    private String coachId;

    public Sport(String id, String name, String coachId) {
        this.id = id;
        this.name = name;
        this.coachId = coachId;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }
    public abstract String getTrainingDescription();
    @Override
    public String toString() {
        return String.format("Sport[ID=%s, Name=%s, CoachId=%s]", id, name, coachId);
    }
}
