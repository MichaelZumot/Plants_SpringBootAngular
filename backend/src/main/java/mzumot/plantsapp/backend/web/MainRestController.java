package mzumot.plantsapp.backend.web;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import mzumot.plantsapp.backend.dto.PlantDTO;
import mzumot.plantsapp.backend.mappers.PlantMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mzumot.plantsapp.backend.service.PlantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MainRestController {

    @Autowired
    private PlantService plantService;
    @Autowired
    private PlantMapper plantMapper;

    public MainRestController(PlantService plantsService) {
        this.plantService = plantsService;
    }

    @GetMapping(value = "/plants")
    public List<PlantDTO> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable Long id) {
        PlantDTO plantDTO = plantService.getPlantById(id);
        if (!Objects.isNull(plantDTO)) {
            return ResponseEntity.ok(plantDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
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
    public ResponseEntity<?> updateLastWatered(@PathVariable Long id) {
        Date date  = new Date();
        PlantDTO dto = plantService.getPlantById(id);
        plantService.updateLastWatered(dto);
        return ResponseEntity.ok().build();
    }
}
