package com.example.Competition.RestController;

import com.example.Competition.Entity.Players;
import com.example.Competition.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PlayerRestController {
    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(path = "/test")
    public Iterable<Players> test(){
        Iterable<Players> players = playerRepository.findAllById(List.of(5,1));
        return players;
    }

}
