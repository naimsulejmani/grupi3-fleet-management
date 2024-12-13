package dev.naimsulejmani.grupi3fleetmanagement.infrastructure.mapping;

public interface SimpleMapper<TEntity, TDto> {
    TEntity toEntity(TDto dto);

    TDto toDto(TEntity entity);
}
