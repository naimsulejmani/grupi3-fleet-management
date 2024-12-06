package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "auths/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {

        var searchUser = userService.login(user.getUsername(), user.getPassword());

        if(searchUser==null) {
            return "redirect:/login";
        }

        //me vendose cookie e ri per login


        return "redirect:/";
    }
}
