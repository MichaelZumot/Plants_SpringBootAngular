package mzumot.plantsapp.backend.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mzumot.plantsapp.backend.model.Plant;
import mzumot.plantsapp.backend.service.PlantsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = "http://localhost:4200")
public class MainRestController {

    @Autowired
    private PlantsService plantsService;

    public MainRestController(PlantsService plantsService) {
        this.plantsService = plantsService;
    }

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantsService.getAllPlants();
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
        Plant plant = plantsService.getPlantById(id);
        if (plant != null) {
            return ResponseEntity.ok(plant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Plant> savePlant(@RequestBody Plant plant) {
        Plant savedPlant = plantsService.savePlant(plant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable int id) {
        try {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX DELETING PLANT WITH ID: " + id);
            plantsService.deletePlant(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
