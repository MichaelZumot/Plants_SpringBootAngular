package mzumot.plantsapp.backend.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mzumot.plantsapp.backend.dto.PlantDTO;
import mzumot.plantsapp.backend.mappers.PlantMapper;
import mzumot.plantsapp.backend.model.Plant;
import mzumot.plantsapp.backend.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;
    @Autowired
    private PlantMapper plantMapper;


    public PlantDTO getPlantById(Long id) {
        Plant plant = plantRepository.findById(id).orElse(null);
        return plantMapper.toDto(plant);
    }

    public PlantDTO savePlant(PlantDTO plantDTO) {
        Plant plant = plantMapper.toEntity(plantDTO);
        plantRepository.save(plant);
        return plantMapper.toDto(plant);
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }

    public void updateLastWatered(PlantDTO plantDTO) {
        Plant plantToUpdate = plantMapper.toEntity(plantDTO);
        plantToUpdate.setLastWatered(plantDTO.getLastWatered());
        plantRepository.save(plantToUpdate);
    }

    public List<PlantDTO> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        return plants.stream()
                .map(plantMapper::toDto)
                .collect(Collectors.toList());
    }
}