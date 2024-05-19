package mzumot.plantsapp.backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plant")
public class Plant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)

    private String name;
    @Column(name = "latin_name")
    private String latinName;

    @Column(name = "description")
    private String description;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "watering_schedule")
    @Enumerated(EnumType.STRING)

    private WateringSchedule wateringSchedule;
    @Column(name = "last_watered")

    private LocalDate lastWatered;

    public Plant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Plant)) {
            return false;
        }
        Plant plant = (Plant) o;
        return Objects.equals(id, plant.id) && Objects.equals(name, plant.name)
                && Objects.equals(description, plant.description)
                && Objects.equals(wateringSchedule, plant.wateringSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", latinName='" + getLatinName() + "'" +
                ", description='" + getDescription() + "'" +
                ", wateringSchedule='" + getWateringSchedule() + "'" +
                " last watered " + getLastWatered() + "'" + "}";
    }

}
