package mzumot.plantsapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mzumot.plantsapp.backend.model.Plant;

@Repository
public interface PlantsRepository extends JpaRepository<Plant, Long> {
 
   

 }
