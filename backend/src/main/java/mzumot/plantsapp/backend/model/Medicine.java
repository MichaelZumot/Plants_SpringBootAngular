package mzumot.plantsapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @Column(name = "quantity")
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
