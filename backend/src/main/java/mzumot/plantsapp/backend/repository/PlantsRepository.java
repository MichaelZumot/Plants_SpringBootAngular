package mzumot.plantsapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import mzumot.plantsapp.backend.model.Plant;

@Repository
public interface PlantsRepository extends JpaRepository<Plant, Integer> {
 
    List<Plant> findAll();


 }
