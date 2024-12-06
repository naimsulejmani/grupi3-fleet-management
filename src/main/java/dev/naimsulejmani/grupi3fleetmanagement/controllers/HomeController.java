package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class HomeController {

    @GetMapping("")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
                if (cookie.getName().equals("name")) {
                    return "redirect:/drivers";
                }
            }
        }

        Cookie cookie = new Cookie("name", UUID.randomUUID().toString());
        cookie.setMaxAge(60); //1 year
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
        return "index";
    }
}
