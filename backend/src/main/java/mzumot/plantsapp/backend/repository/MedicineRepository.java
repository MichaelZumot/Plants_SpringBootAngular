package mzumot.plantsapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mzumot.plantsapp.backend.model.Medicine;

@Repository
public interface MedicineRepository  extends JpaRepository<Medicine, Long> {

 
}
