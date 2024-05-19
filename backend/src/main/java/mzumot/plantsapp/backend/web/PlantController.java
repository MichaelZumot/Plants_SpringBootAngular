package mzumot.plantsapp.backend.web;

import mzumot.plantsapp.backend.dto.PlantDTO;
import mzumot.plantsapp.backend.mappers.PlantMapper;
import mzumot.plantsapp.backend.model.Plant;
import mzumot.plantsapp.backend.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;


    @GetMapping("/all")
    public ResponseEntity<List<PlantDTO>> getAllPlants() {
        try {
            List<PlantDTO> plantDTOs = plantService.getAllPlants();
            return ResponseEntity.ok(plantDTOs);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        try {
            return ResponseEntity.ok("wtf is going on ?");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error testing", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable Long id) {
        PlantDTO plantDTO = plantService.getPlantById(id);
        if (!Objects.isNull(plantDTO)) {
            return ResponseEntity.ok(plantDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<PlantDTO> savePlant(@RequestBody PlantDTO plant) {
        plantService.savePlant(plant);
        return ResponseEntity.status(HttpStatus.CREATED).body(plant);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        try {
            System.out.println("Deleting plant with ID: " + id);
            plantService.deletePlant(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}/update-last-watered")
    public ResponseEntity<Void> updateLastWatered(@PathVariable Long id) {
        PlantDTO dto = plantService.getPlantById(id);
        plantService.updateLastWatered(dto);
        return ResponseEntity.ok().build();
    }
}
