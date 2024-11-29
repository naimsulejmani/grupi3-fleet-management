package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String driverDetails(@PathVariable long id, Model model) {
        var driver = service.findById(id);
        model.addAttribute("driver", driver);
        return "drivers/details";
    }

    @GetMapping("/create")
    public String createDriver(Model model) {
        model.addAttribute("driver", new Driver());
        return "drivers/create";
    }

    @GetMapping("/{id}/edit")
    public String editDriver(@PathVariable long id, Model model) {
        var driver = service.findById(id);
        model.addAttribute("driver", driver);
        return "drivers/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteDriver(@PathVariable long id, Model model) {
        var driver = service.findById(id);
        model.addAttribute("driver", driver);
        return "drivers/delete";
    }

    @PostMapping("/create")
    public String addDriver(@ModelAttribute Driver driver) {
        service.add(driver);
        return "redirect:/drivers";
    }

    @PostMapping("/{id}/edit")
    public String modifyDriver(@ModelAttribute Driver driver, @PathVariable long id, RedirectAttributes redirectAttributes) {

        if (driver.getId() != id) {
            //kjo i dergohet si parameter ne query string
            redirectAttributes.addAttribute("errorId", "DR404");
            //kjo i dergohet si objekt ne html
            redirectAttributes.addFlashAttribute("errorMessage", "Driver ID does not match");
            return "redirect:/drivers";
        }

        service.modify(driver);

        return "redirect:/drivers";
    }

    @PostMapping("/{id}/delete")
    public String removeDriver(@PathVariable long id) {
        service.deleteById(id);
        return "redirect:/drivers";
    }


}
