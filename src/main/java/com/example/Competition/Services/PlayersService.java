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

import java.util.List;
import java.util.Optional;

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

    public void index(Model model){

        Schedule schedule1 = scheduleRepository.findById(9).get();
        model.addAttribute("idDate1", schedule1.getDate());
        model.addAttribute("schedule1", schedule1.getSecondTeam());
        model.addAttribute("schedule2", schedule1.getFirstTeam());


        Schedule schedule2 = scheduleRepository.findById(10).get();
        model.addAttribute("idDate2", schedule2.getDate());
        model.addAttribute("schedule3", schedule2.getSecondTeam());
        model.addAttribute("schedule4", schedule2.getFirstTeam());

        Schedule schedule3 = scheduleRepository.findById(11).get();
        model.addAttribute("idDate3", schedule3.getDate());
        model.addAttribute("schedule5", schedule3.getSecondTeam());
        model.addAttribute("schedule6", schedule3.getFirstTeam());

        Schedule schedule4 = scheduleRepository.findById(12).get();
        model.addAttribute("idDate4", schedule4.getDate());
        model.addAttribute("schedule7", schedule4.getSecondTeam());
        model.addAttribute("schedule8", schedule4.getFirstTeam());
    }

    public void teams(Model model){
        Iterable<Teams>  teams = teamsRepository.findAll();
        Iterable<Players> players = playerRepository.findAll();
        model.addAttribute("teams", teams);
        model.addAttribute("players", players);


    }
}
