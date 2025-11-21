package com.dnu.sportsclub.model;

public class Football extends Sport {
    public Football(String id, String name, String coachId) { super(id, name, coachId); }
    @Override public String toString() { return "Bóng đá: " + name + " (HLV: " + coachId + ")"; }
}