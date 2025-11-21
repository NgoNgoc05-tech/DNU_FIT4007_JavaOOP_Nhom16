package main.java.com.dnu.sportsclub.model.abstract_class;

public class Football extends Sport {
    public Football(String id, String name, String coachId) {
        super(id, name, coachId);
    }

    @Override
    public String getTrainingScheduleDescription() {
        return "Lịch tập bóng đá: Sân cỏ ngoài trời, yêu cầu giày đinh.";
    }
}
