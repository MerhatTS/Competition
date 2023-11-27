package com.example.Competition.Services;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Schedule;
import com.example.Competition.Entity.Teams;
import com.example.Competition.Repositories.PlayerRepository;
import com.example.Competition.Repositories.ScheduleRepository;
import com.example.Competition.Repositories.TeamsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Getter
@Setter
public class PlayersService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamsRepository teamsRepository;

    public void index(Model model) {
        Iterable<Schedule> schedules = scheduleRepository.findAll();
        model.addAttribute("schedules", schedules);
    }

    public void teams(Model model) {
        Iterable<Teams> teams = teamsRepository.findAll();
        model.addAttribute("teams", teams);
    }
}

