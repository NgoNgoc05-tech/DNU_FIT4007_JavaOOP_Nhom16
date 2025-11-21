package main.java.com.dnu.sportsclub.model.abstract_class;

public class Coach extends Person {
    private String specialization;

    public Coach(String id, String name, String phone, String specialization) {
        super(id, name, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return String.format("Coach [ID: %s, Name: %s, Spec: %s]", id, name, specialization);
    }
}
