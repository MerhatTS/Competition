package com.example.Competition.RestController;

import com.example.Competition.Entity.Players;
import com.example.Competition.Repositories.PlayerRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PlayerRestController {
    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(path = "/pid")
    public Optional<Players> test(){
        return playerRepository.findById(5);
    }

    @RequestMapping(path = "/pall")
    public Iterable<Players> test2(){
        Iterable<Players> playersALL = playerRepository.findAll();
        return playersALL;
    }

    @RequestMapping(path = "/ok3")
    public Optional<Players> test3(
            @RequestParam("id") Integer id,
            @RequestParam(value = "name", required = false, defaultValue = "Rono") String name
    ){
        System.out.println(id+ " : " + name);
        return playerRepository.findById(id);
    }

    @RequestMapping(path = "/ok2/{id}")
    public Optional<Players> test4(
            @PathVariable("id") Integer id,
            @RequestParam(value = "name", required = false, defaultValue = "Ronaldo") String name
    ){
        System.out.println(id+ " : " + name);
        return playerRepository.findById(id);
    }

    @GetMapping(path = "/okg")
    public Optional<Players> test5(Players params){
        System.out.println(params.getId() + " : " + params.getName() + " : " + params.getAge());
        return playerRepository.findById(params.getId());
    }

    @PostMapping(path = "/okp")
    public Optional<Players> test6(@RequestBody Players params){
        System.out.println(params.getId() + " : " + params.getName() + " : " + params.getAge());
        return playerRepository.findById(params.getId());
    }

}
