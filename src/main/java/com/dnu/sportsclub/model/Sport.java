package com.dnu.sportsclub.model;
import java.io.Serializable;

public abstract class Sport implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id, name, coachId;

    public Sport(String id, String name, String coachId) {
        this.id = id; this.name = name; this.coachId = coachId;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCoachId() { return coachId; }
    @Override public abstract String toString();
}