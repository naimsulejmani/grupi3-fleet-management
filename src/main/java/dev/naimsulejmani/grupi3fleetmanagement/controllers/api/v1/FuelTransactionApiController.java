package dev.naimsulejmani.grupi3fleetmanagement.controllers.api.v1;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.FuelTransactionDto;
import dev.naimsulejmani.grupi3fleetmanagement.services.FuelTransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fuel-transactions")
public class FuelTransactionApiController {
    private final FuelTransactionService service;

    public FuelTransactionApiController(FuelTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FuelTransactionDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
        //return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        //return ResponseEntity.status(200).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody FuelTransactionDto fuelTransactionDto) {
        //fuel-transactions/10
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(fuelTransactionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @Valid @RequestBody FuelTransactionDto fuelTransactionDto) {
        return ResponseEntity.ok(service.modify(id, fuelTransactionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.removeById(id);
        return ResponseEntity.ok().build();
    }

}












