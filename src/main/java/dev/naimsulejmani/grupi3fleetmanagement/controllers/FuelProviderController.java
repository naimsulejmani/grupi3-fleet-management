package dev.naimsulejmani.grupi3fleetmanagement.controllers;


import dev.naimsulejmani.grupi3fleetmanagement.models.FuelProvider;
import dev.naimsulejmani.grupi3fleetmanagement.services.FuelProviderService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fuel-providers")
public class FuelProviderController {

    private final FuelProviderService service;

    public FuelProviderController(FuelProviderService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("fuelProviders", service.findAll());
        return "fuel-providers/index";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("fuelProvider", new FuelProvider());
        return "fuel-providers/new";
    }

    @PostMapping("/new")
    public String store(@ModelAttribute FuelProvider fuelProvider) {
        service.save(fuelProvider);
        return "redirect:/fuel-providers";
    }

    @GetMapping("/{id}/details")
    public String getDetails(@PathVariable Long id, Model model) {
        model.addAttribute("fuelProvider", service.findById(id));
        return "fuel-providers/details";
    }

}













