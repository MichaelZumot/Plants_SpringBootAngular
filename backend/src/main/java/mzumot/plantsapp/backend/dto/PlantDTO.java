package mzumot.plantsapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mzumot.plantsapp.backend.model.WateringSchedule;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantDTO {
    private Long id;
    private String name;
    private String latinName;
    private String description;
    private String profilePicture;
    private WateringSchedule wateringSchedule;
    private LocalDate lastWatered;
}