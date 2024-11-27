package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriversController {

    @GetMapping("")
    public String drivers() {
        return "drivers/list";
    }

    @GetMapping("/{id}/details")
    public String driverDetails() {
        return "drivers/details";
    }

    @GetMapping("/create")
    public String createDriver() {
        return "drivers/create";
    }

    @GetMapping("/{id}/edit")
    public String editDriver() {
        return "drivers/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteDriver() {
        return "drivers/delete";
    }

    @PostMapping("/create")
    public String addDriver() {
        return "redirect:/drivers";
    }

    @PostMapping("/{id}/edit")
    public String modifyDriver() {
        return "redirect:/drivers";
    }

    @PostMapping("/{id}/delete")
    public String removeDriver() {
        return "redirect:/drivers";
    }


}
