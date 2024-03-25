package mzumot.plantsapp.backend.mappers;

import mzumot.plantsapp.backend.dto.MedicineDTO;
import mzumot.plantsapp.backend.model.Medicine;
import org.mapstruct.Mapping;

public interface MedicineMapper {
    MedicineDTO toDto(Medicine entity);

    @Mapping(target = "id", ignore = true)
    Medicine toEntity(MedicineDTO dto);
}
