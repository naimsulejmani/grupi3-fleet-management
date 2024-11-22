package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriversController {
    private final String FOLDER_NAME = "drivers";

    @GetMapping("")
    public String drivers() {
        return FOLDER_NAME + "/list";
    }

    @GetMapping("/{id}/details")
    public String driverDetails() {
        return FOLDER_NAME + "/details";
    }

    @GetMapping("/create")
    public String createDriver() {
        return FOLDER_NAME + "/create";
    }

    @GetMapping("/{id}/edit")
    public String editDriver() {
        return FOLDER_NAME + "/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteDriver() {
        return FOLDER_NAME + "/delete";
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
