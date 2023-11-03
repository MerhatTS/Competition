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

        if (players.getAccepted() == null){
            players.setAccepted(true);
        }
        playerRepository.save(players);
    }

    public void addTeams(Model model, Teams teams) {
        model.addAttribute("teams",teams);

        if(teams.getName() !=null && teams.equals("")){
            Teams addTeams = new Teams();
            addTeams.setName(teams.getName());

            teamsRepository.save(addTeams);
            model.addAttribute("teams", addTeams);
        }else {
            model.addAttribute("teams", teams);
        }

    }

    public void adminTeams(Model model, Teams teams) {
        model.addAttribute("teams",teams);

        teamsRepository.findAll();

    }

}
