package com.example.Competition.Controller;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Schedule;
import com.example.Competition.Entity.Users;
import com.example.Competition.Repositories.RoleRepository;
import com.example.Competition.Repositories.ScheduleRepository;
import com.example.Competition.Repositories.UserRepository;
import com.example.Competition.Services.PlayersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping({"/","/index"})
    public String index(Model model){
        playersService.index(model);
        return "index";
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

    @GetMapping("/register")
    public String profile(){
        return "register";
    }

    @PostMapping("/register")
    public  String profile_confirm(@RequestParam String login, @RequestParam String password, Model model){
        Users users = new Users();
        users.setLogin(login);
        users.setPassword(new BCryptPasswordEncoder().encode(password));
        users.setRoles(roleRepository.findByName("user"));
        userRepository.save(users);

        return "redirect:/index";

    }





    @RequestMapping("/manualLogout")
    public String customLogout(Model model, HttpServletRequest request) throws ServletException{
        request.logout();
        return "redirect:/";
    }

}
