package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriversController {


    @GetMapping("")
    public String drivers() {
        return "drivers/list";
    }
}
