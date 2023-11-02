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
        Teams teams1 = teamsRepository.findById(1).get();
        model.addAttribute("teams1", teams1.getName());

        Teams teams2 = teamsRepository.findById(2).get();
        model.addAttribute("teams2", teams2.getName());

        Players players1 = playerRepository.findById(1).get();
        model.addAttribute("name1", players1.getName());
        model.addAttribute("age1", players1.getAge());
        model.addAttribute("gender1", players1.getGender());

        Players players2 = playerRepository.findById(2).get();
        model.addAttribute("name2", players2.getName());
        model.addAttribute("age2", players2.getAge());
        model.addAttribute("gender2", players2.getGender());

        Players players3 = playerRepository.findById(3).get();
        model.addAttribute("name3", players3.getName());
        model.addAttribute("age3", players3.getAge());
        model.addAttribute("gender3", players3.getGender());

        Players players4 = playerRepository.findById(4).get();
        model.addAttribute("name4", players4.getName());
        model.addAttribute("age4", players4.getAge());
        model.addAttribute("gender4", players4.getGender());

        Players players5 = playerRepository.findById(5).get();
        model.addAttribute("name5", players5.getName());
        model.addAttribute("age5", players5.getAge());
        model.addAttribute("gender5", players5.getGender());

    }
}

