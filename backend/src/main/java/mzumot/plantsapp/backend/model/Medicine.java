package mzumot.plantsapp.backend.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate expiryDate;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Plant)) {
            return false;
        }
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) && Objects.equals(name, medicine.name)
                && Objects.equals(name, medicine.name)
                && Objects.equals(expiryDate, medicine.expiryDate)
                && Objects.equals(quantity, medicine.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, quantity);
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", expiryDate='" + getExpiryDate() + "'" +
                ", quantity='" + getQuantity();
    }
}
