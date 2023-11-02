package com.example.Competition.Services;

import com.example.Competition.Entity.Players;
import com.example.Competition.Repositories.PlayerRepository;
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

    public void listPlayers(Model model){
        List<Players> players = playerRepository.findAll();
        model.addAttribute("players", players);

    }
    public void changelistPlayers(Integer id){
        Players players = playerRepository.findById(id).get();

        if (players.getAccepted() == null){
            players.setAccepted(true);
        } else{
            players.setAccepted(false);
        }

        playerRepository.save(players);
    }

}
