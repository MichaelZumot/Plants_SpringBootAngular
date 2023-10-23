package mzumot.plantsapp.backend.repository;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import mzumot.plantsapp.backend.model.WateringSchedule;
import mzumot.plantsapp.backend.model.Plant;

@Component // Add this annotation to explicitly declare the class as a Spring bean
public class DatabaseInitializer {
    PlantsRepository plantsRepository;

    public DatabaseInitializer(PlantsRepository plantsRepository) {
        this.plantsRepository=plantsRepository;

    }

    @PostConstruct
    public void initialize() {
      
        Plant plant1 = new Plant(1L,"Dragon spider", "Dracaena marginata", "Arrived in August 2023. Important to note that its oots are sensitive, watering once a week", "1" , WateringSchedule.ASNEEDED);
        Plant plant2 = new Plant(2L,"Sabri", "Haworthia attenuata", "a cool chill dude, minimal watering and all is good !", "2", WateringSchedule.ASNEEDED);
        Plant plant3 = new Plant(3L,"Golden Pothos", "Eppipremnum aureum", "An absolute delight! Grows fast, very low maintenance, can be moduled.", "3",  WateringSchedule.WEEKLY);
        Plant plant4 = new Plant(4L,"Butch", "Smallus GreenusTree", "very low maintanence!", "4", WateringSchedule.WEEKLY);
        Plant plant5 = new Plant(5L,"Monstera", "Monstea Delicosa", "beautiful plant with air roots. Must be watered regularly!" , "5", WateringSchedule.WEEKLY);
        Plant plant6 = new Plant(6L,"Mother Spider Plant", "Spider Plant", "Gift from Elise, been around since 2021. buds can be replanted." , "6", WateringSchedule.WEEKLY);
        Plant plant7 = new Plant(7L,"Terrarium", "Bamboo terrarium", "Bought from a woman who made it. low maintenace be replanted." , "7", WateringSchedule.WEEKLY);
      plantsRepository.saveAll(Arrays.asList(plant1, plant2, plant3, plant4, plant5, plant6, plant7));

    }
}


