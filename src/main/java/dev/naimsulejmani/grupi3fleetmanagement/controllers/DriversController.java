package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriversController {

    private final DriverService service;

    // @Qualifier("emriIImplementimit") nese kemi me shume se nje implementues te service
    public DriversController(DriverService service) {
        this.service = service;
    }


    @GetMapping("")
    public String drivers(Model model) {
        model.addAttribute("drivers", service.findAll());
        return "drivers/list";
    }

    @GetMapping("/{id}/details")
    public String driverDetails() {
        return "drivers/details";
    }

    @GetMapping("/create")
    public String createDriver(Model model) {
        model.addAttribute("driver", new Driver());
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
