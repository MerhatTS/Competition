package com.example.Competition.Controller;

import com.example.Competition.Entity.Players;
import com.example.Competition.Repositories.PlayerRepository;
import com.example.Competition.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/admin/listPlayers/{id}")
    public String Players(@PathVariable Integer id, Model model){
        adminService.listPlayers(model, id);
        return "admin/listPlayers";
    }

}
