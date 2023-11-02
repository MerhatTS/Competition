package com.example.Competition.Controller;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Users;
import com.example.Competition.Repositories.PlayerRepository;
import com.example.Competition.Repositories.RoleRepository;
import com.example.Competition.Repositories.ScheduleRepository;
import com.example.Competition.Repositories.UserRepository;
import com.example.Competition.Security.UserDetailsImpl;
import com.example.Competition.Services.PlayersService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class PlayersController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    PlayersService playersService;

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping({"/","/index"})
    public String index(Model model){
        playersService.index(model);
        return "index";
    }
    @RequestMapping("/teams")
    public String teams(Model model){
        playersService.teams(model);
        return "teams";
    }

    @RequestMapping("/schedule")
    public String teams(){
        return "schedule";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public  String register_confirm(@RequestParam String login, @RequestParam String password, Model model){
        Users users = new Users();
        users.setLogin(login);
        users.setPassword(new BCryptPasswordEncoder().encode(password));
        users.setRoles(roleRepository.findByName("user"));
        userRepository.save(users);

        return "redirect:/index";

    }

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model){
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        Optional<Players> players = playerRepository.findByUserId(user.getUserId());
        model.addAttribute("players", players.orElseGet(Players::new));
        return "profile";
    }

    @PostMapping("/profile")
    public  String saveProfile(Players players, Authentication authentication, Model model){
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        Optional<Players> playersEntity = playerRepository.findByUserId(user.getUserId());
        if (playersEntity.isPresent()){
            Players save = playersEntity.get();
            save.setName(players.getName());
            save.setAge(players.getAge());
            save.setGender(players.getGender());
            save.setHeight(players.getHeight());
            save.setWeight(players.getWeight());
            save.setInfo(players.getInfo());
            playerRepository.save(save);
        } else {
            players.setUsers(userRepository.findById(user.getUserId()).get());
            playerRepository.save(players);
            model.addAttribute("players", players);
        }
        return "profile";

    }





    @RequestMapping("/manualLogout")
    public String customLogout(Model model, HttpServletRequest request) throws ServletException{
        request.logout();
        return "redirect:/";
    }

}
