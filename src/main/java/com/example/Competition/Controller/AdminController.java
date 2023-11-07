package com.example.Competition.Controller;

import com.example.Competition.Entity.Players;
import com.example.Competition.Entity.Teams;
import com.example.Competition.Repositories.PlayerRepository;
import com.example.Competition.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/admin/listPlayers")
    public String Players(Model model){
        adminService.listPlayers(model);
        return ("admin/listPlayers");
    }
    @RequestMapping("/admin/listPlayers/{id}")
    public RedirectView Players(@PathVariable Integer id){
        adminService.changelistPlayers(id);
        return new RedirectView("/index");
    }

    @RequestMapping("/admin/addTeams")
    public String addTeams(Teams teams, Model model){
        adminService.addTeams(model, teams);
        return "admin/addTeams";
    }

    @RequestMapping("/admin/adminTeams")
    public String adminTeams(Model model){
        adminService.adminTeams(model);
        return "admin/adminTeams";
    }

    @GetMapping("/admin/addPlayers/{id}")
    public String addPlayers(Model model, @PathVariable Integer id){
        adminService.addPlayers(model, id);
        return "admin/addPlayers";
    }

    @PostMapping("/admin/addPlayers/{id}")
    public String savePayers(Model model, @RequestParam(required = false) List<Integer> pids, @PathVariable Integer id) {
        adminService.savePlayers(model, pids, id);
        return "redirect:/admin/addPlayers/"+id;
    }



}
