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
import org.springframework.web.servlet.view.RedirectView;

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



}
