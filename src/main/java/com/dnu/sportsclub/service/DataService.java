package com.dnu.sportsclub.service;

import com.dnu.sportsclub.common.AppConstants;
import com.dnu.sportsclub.model.*;
import com.dnu.sportsclub.repository.FileRepository;
import java.util.List;

public class DataService {
    public List<Member> members;
    public List<Coach> coaches;
    public List<Sport> sports;
    public List<Schedule> schedules;
    public List<Competition> competitions;

    private final FileRepository repo = new FileRepository();

    public DataService() { loadAll(); }

    public void loadAll() {
        members = repo.load(AppConstants.FILE_MEMBERS);
        coaches = repo.load(AppConstants.FILE_COACHES);
        sports = repo.load(AppConstants.FILE_SPORTS);
        schedules = repo.load(AppConstants.FILE_SCHEDULES);
        competitions = repo.load(AppConstants.FILE_COMPETITIONS);
    }

    public void saveAll() {
        repo.save(AppConstants.FILE_MEMBERS, members);
        repo.save(AppConstants.FILE_COACHES, coaches);
        repo.save(AppConstants.FILE_SPORTS, sports);
        repo.save(AppConstants.FILE_SCHEDULES, schedules);
        repo.save(AppConstants.FILE_COMPETITIONS, competitions);
    }
}