package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String login(
            @ModelAttribute User user
            , HttpServletRequest request
            , HttpServletResponse response
            , @RequestParam(value = "returnUrl", required = false) String returnUrl) {
        var searchUser = userService.login(user.getUsername(), user.getPassword());
        if (searchUser == null) {
            return "redirect:/login";
        }
        //me vendose cookie e ri per login
        Cookie cookie = new Cookie("user-id", searchUser.getId().toString());
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setDomain("localhost");

        response.addCookie(cookie);

        HttpSession session = request.getSession();
        session.setAttribute("user", searchUser);
        session.setAttribute("role", "ROLE_ADMIN");

        if (returnUrl != null && !returnUrl.isBlank()) {
            return "redirect:" + returnUrl;
        }

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("user-id", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            session.removeAttribute("role");
            session.invalidate();
        }


        return "redirect:/login";
    }
}











