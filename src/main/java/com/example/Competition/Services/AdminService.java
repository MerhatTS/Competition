package com.example.Competition.Services;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Teams;
import com.example.Competition.Repositories.PlayerRepository;
import com.example.Competition.Repositories.TeamsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class AdminService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamsRepository teamsRepository;

    public void listPlayers(Model model){
        List<Players> players = playerRepository.findAll();
        model.addAttribute("players", players);
    }
    public void changelistPlayers(Integer id){
        Players players = playerRepository.findById(id).get();

        if (players.getAccepted() == null || players.getAccepted() == false){
            players.setAccepted(true);
        }
        playerRepository.save(players);
    }

    public void addTeams(Model model, Teams teams) {
        model.addAttribute("teams",teams);

        if(teams.getName() !=null && !teams.equals("")){
            Teams saveTeams = new Teams();
            saveTeams.setName(teams.getName());

            teamsRepository.save(saveTeams);
            model.addAttribute("teams", saveTeams);
        }else {
            model.addAttribute("teams", teams);
        }
    }

    public void addPlayers(Model model, @PathVariable Integer id) {
        List<Players> players = new ArrayList<>();
        playerRepository.findAll().forEach(x -> {
            if (x.getTeam() == null){
                players.add(x);
            }
        });
        model.addAttribute("players", players);
        model.addAttribute("teamid", id);

    }

    public void savePlayers(Model model, @RequestParam(required = false) List<Integer> pids, @PathVariable Integer id) {
        System.out.println("pids" +pids);
        Teams teams = teamsRepository.findById(id).get();
        Iterable<Players> savePlayers = playerRepository.findAllById(pids);
        for (Players player : savePlayers){
            player.setTeam(teams);
            teams.getPlayers().add(player);
        }
        teamsRepository.save(teams);

    }

    public void adminTeams(Model model) {
        Iterable<Teams> teams = teamsRepository.findAll();
        model.addAttribute("teams",teams);
    }



}
