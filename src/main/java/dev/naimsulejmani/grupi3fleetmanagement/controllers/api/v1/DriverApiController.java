package dev.naimsulejmani.grupi3fleetmanagement.controllers.api.v1;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverApiController {
    private final DriverService service;

    public DriverApiController(DriverService service) {
        this.service = service;
    }

    //ketu duhet gjithqysh me paginations nese ka shume records, nese ka pak records nuk ka nevoje
    // @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size
    @GetMapping
    public List<Driver> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Driver findById( @PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Driver add(@RequestBody Driver driver) {
        return service.add(driver);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }


    @PutMapping("/{id}")
    public Driver update(@PathVariable Long id, @RequestBody Driver driver) {
        if(id!=driver.getId()){
            throw new IllegalArgumentException ("Driver id does not match the id in the path");
        }
        return service.modify(driver);
    }

    @PatchMapping("/{id}")
    public Driver patch(@PathVariable Long id, @RequestBody Driver driver) {
        return service.modify(driver);
    }

    @GetMapping("/default")
    public Driver defaultDriver() {
        return new Driver();
    }

}
