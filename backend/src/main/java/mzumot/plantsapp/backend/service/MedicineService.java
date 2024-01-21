package mzumot.plantsapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mzumot.plantsapp.backend.model.Medicine;
import mzumot.plantsapp.backend.repository.MedicineRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MedicineService{
    @Autowired
    private MedicineRepository medicineRepository;

     public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }
}
