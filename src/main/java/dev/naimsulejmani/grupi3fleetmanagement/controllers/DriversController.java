package dev.naimsulejmani.grupi3fleetmanagement.controllers;

import dev.naimsulejmani.grupi3fleetmanagement.helpers.FileHelper;
import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/drivers")
public class DriversController {

    private final DriverService service;
    private final FileHelper fileHelper;

    // @Qualifier("emriIImplementimit") nese kemi me shume se nje implementues te service
    public DriversController(DriverService service, FileHelper fileHelper) {
        this.service = service;
        this.fileHelper = fileHelper;
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
        model.addAttribute("from", LocalDate.now().minusYears(65));
        model.addAttribute("today", LocalDate.now());
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
    public String addDriver(@Valid @ModelAttribute Driver driver, BindingResult bindingResult
            , RedirectAttributes redirectAttributes,
                            @RequestParam("photoFile") MultipartFile photoFile,
                            @SessionAttribute("user") User user
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return "drivers/create";
        }
        System.out.println("Photo file: " + photoFile.getOriginalFilename());


        if (!photoFile.isEmpty()) {
            try {
                var fileName = fileHelper.uploadFile("target/classes/static/assets/img/drivers"
                        , photoFile.getOriginalFilename()
                        , photoFile.getBytes());
                driver.setPhoto("/assets/img/drivers/" + fileName);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            User user = (User) session.getAttribute("user");
//            System.out.println("User: " + user);
//            // driver.setCreatedBy(user.getEmail());
//        }


        var newDriver = service.add(driver);

        if (newDriver == null) {
            bindingResult.rejectValue("personalNo", "error.driver", "Driver already exists with that personal number");
            bindingResult.rejectValue("email", "error.driver", "Driver already exists with that email");
            return "drivers/create";
//            redirectAttributes.addFlashAttribute("errorMessage", "Driver already exists with that email or personal number");
//            return "redirect:/drivers";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Driver added successfully");
        return "redirect:/drivers";
    }

    @PostMapping("/{id}/edit")
    public String modifyDriver(
            @ModelAttribute Driver driver, @PathVariable long id, RedirectAttributes redirectAttributes,
            @RequestParam("photoFile") MultipartFile photoFile) {

        if (driver.getId() != id) {
            //kjo i dergohet si parameter ne query string
            redirectAttributes.addAttribute("errorId", "DR404");
            //kjo i dergohet si objekt ne html
            redirectAttributes.addFlashAttribute("errorMessage", "Driver ID does not match");
            return "redirect:/drivers";
        }

        if (!photoFile.isEmpty()) {
            try {
                var fileName = fileHelper.uploadFile("target/classes/static/assets/img/drivers"
                        , photoFile.getOriginalFilename()
                        , photoFile.getBytes());
                driver.setPhoto("/assets/img/drivers/" + fileName);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
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
