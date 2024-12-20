package dev.naimsulejmani.grupi3fleetmanagement.mappers;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.FuelTransactionDto;
import dev.naimsulejmani.grupi3fleetmanagement.infrastructure.mapping.SimpleMapper;
import dev.naimsulejmani.grupi3fleetmanagement.models.FuelTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Mapper(componentModel = "spring")
public interface FuelTransactionMapper extends SimpleMapper<FuelTransaction, FuelTransactionDto> {
    FuelTransactionMapper INSTANCE = Mappers.getMapper(FuelTransactionMapper.class);

    // add annotation to ignore the id field
    //mapp vehicle.id object to vehicle id

    @Mapping(target = "vehicle.id", source = "vehicleId")
    FuelTransaction toEntity(FuelTransactionDto dto);

    @Mapping(target = "vehicleId", source = "vehicle.id")
    FuelTransactionDto toDto(FuelTransaction entity);

}








