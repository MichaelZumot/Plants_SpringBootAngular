package mzumot.plantsapp.backend.service;

import java.util.Date;
import java.util.List;

import mzumot.plantsapp.backend.model.WateringSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mzumot.plantsapp.backend.model.Plant;
import mzumot.plantsapp.backend.repository.PlantRepository;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class PlantsService {

    @Autowired
    private PlantRepository plantsRepository;

    public List<Plant> getAllPlants() {
        return plantsRepository.findAll();
    }

    public Plant getPlantById(Long id) {
        return plantsRepository.findById(id).orElse(null);
    }

    public Plant savePlant(Plant plant) {
        return plantsRepository.save(plant);
    }

    public void deletePlant(Long id) {
        plantsRepository.deleteById(id);
    }

    public void updateLastWatered(Long plantId, Date lastWatered) {
        plantsRepository.updateLastWatered(plantId, lastWatered);
    }

    public WateringSchedule mapStringToEnum(String wateringScheduleString) {
        // Implement your logic to map the string to the enum
        switch (wateringScheduleString) {
            case "DAILY":
                return WateringSchedule.DAILY;
            case "WEEKLY":
                return WateringSchedule.WEEKLY;
            case "BIWEEKLY":
                return WateringSchedule.BIWEEKLY;
            case "ASNEEDED":
                return WateringSchedule.ASNEEDED;
            default:
                throw new IllegalArgumentException("Invalid watering schedule: " + wateringScheduleString);
        }
    }
}
