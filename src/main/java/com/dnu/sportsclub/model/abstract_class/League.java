package main.java.com.dnu.sportsclub.model.abstract_class;

public abstract class League extends Competition {
    public League(String id, String name) { super(id, name); }
    @Override
    public String getType() { return "Đấu vòng tròn (League)"; }
}
