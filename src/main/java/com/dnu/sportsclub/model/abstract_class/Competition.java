package main.java.com.dnu.sportsclub.model.abstract_class;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Competition implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String id;
    protected String name;
    protected LocalDate startDate;
    protected String status;//"UPCOMING", "ONGOING", "FINISHED"
    //Danh sách Id các thành viên tham gia
    protected List<String> participantIds;
    //Bẩng điểm: key là Menber, value là ddieermd số
    protected Map<String, Integer> scores;

    public  Competition(String id, String name, LocalDate startDate, String status)
    {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.status = "UPCOMING";
        this.participantIds = new ArrayList<>();
        this.scores = new HashMap<>();
    }
    //Methods quản lý cơ bản
    public void addParticipant(String menberId)
    {
        if (!participantIds.contains(menberId))
        {
            participantIds.add(menberId);
            scores.put(menberId, 0);//Điểm ban đau là không
        }
    }
    public void updateScore(String menberId, int score)
    {
        if (scores.containsKey(menberId)){
            scores.put(menberId, scores.get(menberId) + score);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public abstract String toString();
}
