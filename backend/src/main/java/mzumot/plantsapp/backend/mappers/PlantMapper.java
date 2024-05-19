package mzumot.plantsapp.backend.mappers;

import mzumot.plantsapp.backend.dto.PlantDTO;
import mzumot.plantsapp.backend.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantMapper {
    PlantDTO toDto(Plant entity);

    @Mapping(target = "id", ignore = true)
    Plant toEntity(PlantDTO dto);
}
