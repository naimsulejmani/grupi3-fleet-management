package dev.naimsulejmani.grupi3fleetmanagement.services.impls;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.FuelTransactionDto;
import dev.naimsulejmani.grupi3fleetmanagement.mappers.FuelTransactionMapper;
import dev.naimsulejmani.grupi3fleetmanagement.models.FuelTransaction;
import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.FuelTransactionRepository;
import dev.naimsulejmani.grupi3fleetmanagement.services.FuelTransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTransactionServiceImpl implements FuelTransactionService {
    private final FuelTransactionRepository repository;
    private final FuelTransactionMapper mapper;

    public FuelTransactionServiceImpl(FuelTransactionRepository repository
            , @Qualifier("fuelTransactionMapperImpl") FuelTransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FuelTransactionDto add(FuelTransactionDto entity) {
        FuelTransaction fuelTransaction = mapper.toEntity(entity);
        FuelTransaction savedFuelTransaction = repository.save(fuelTransaction);
        return mapper.toDto(savedFuelTransaction);
    }

    @Override
    public List<FuelTransactionDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public FuelTransactionDto findById(Long id) {
        var optionalFuelTransaction = repository.findById(id);
        if (optionalFuelTransaction.isEmpty()) {
            throw new EntityNotFoundException("FuelTransaction with id " + id + " not found");
        }
        return mapper.toDto(optionalFuelTransaction.get());
    }

    @Override
    public FuelTransactionDto modify(Long id, FuelTransactionDto entity) {
        if (id != entity.getId()) {
            throw new IllegalArgumentException("Id does not match");
        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("FuelTransaction with id " + id + " not found");
        }

        FuelTransaction fuelTransaction = mapper.toEntity(entity);
        FuelTransaction savedFuelTransaction = repository.save(fuelTransaction);
        return mapper.toDto(savedFuelTransaction);
    }

    @Override
    public void removeById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("FuelTransaction with id " + id + " not found");
        }
        repository.deleteById(id);

    }
}
