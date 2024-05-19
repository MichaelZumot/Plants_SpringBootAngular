package mzumot.plantsapp.backend.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mzumot.plantsapp.backend.dto.MedicineDTO;
import mzumot.plantsapp.backend.mappers.MedicineMapper;
import mzumot.plantsapp.backend.model.Medicine;
import mzumot.plantsapp.backend.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private MedicineMapper medicineMapper;

    public List<MedicineDTO> getAll() {
        List<Medicine> medicines = medicineRepository.findAll();
        return medicines.stream()
                .map(medicineMapper::toDto)
                .collect(Collectors.toList());
    }

    public MedicineDTO getMedicineById(Long id) {
        Medicine medicine = medicineRepository.findById(id).orElse(null);
        return medicineMapper.toDto(medicine);
    }

    public MedicineDTO saveMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = medicineMapper.toEntity(medicineDTO);
        medicineRepository.save(medicine);
        return medicineMapper.toDto(medicine);
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}
