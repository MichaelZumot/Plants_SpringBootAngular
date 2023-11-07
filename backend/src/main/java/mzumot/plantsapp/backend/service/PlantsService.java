package mzumot.plantsapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mzumot.plantsapp.backend.model.Plant;
import mzumot.plantsapp.backend.repository.PlantsRepository;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class PlantsService {

    @Autowired
    private PlantsRepository plantsRepository;
 
    public List<Plant> getAllPlants() {
        return plantsRepository.findAll();
    }

    public Plant getPlantById(int id) {
        return plantsRepository.findById(id).orElse(null);
    }

    public Plant savePlant(Plant plant) {
        return plantsRepository.save(plant);
    }

    public void deletePlant(int id) {
        plantsRepository.deleteById(id);
    }
}
