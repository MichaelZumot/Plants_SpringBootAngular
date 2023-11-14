package mzumot.plantsapp.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true) // Ensure uniqueness
    private String name;

    private String latinName;

    private String description;

    private String profilePicture;

    private WateringSchedule wateringSchedule;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_watered")
    private Date lastWatered;

    public Plant(int id, String name) {
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
                " last watered " + getLastWatered() + "'" +"}";
    }

}
