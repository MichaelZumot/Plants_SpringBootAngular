package mzumot.plantsapp.backend.web;

import mzumot.plantsapp.backend.dto.MedicineDTO;
import mzumot.plantsapp.backend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicheck")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/all")
    public List<MedicineDTO> getAllMedicines() {
        try {
            return medicineService.getAll();
        } catch (Exception e) {
            // Log the exception and return a meaningful error response
            e.printStackTrace();
            throw new RuntimeException("Error fetching medicines", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDTO> getMedicineById(@PathVariable Long id) {
        MedicineDTO medicineDTO = medicineService.getMedicineById(id);
        if (medicineDTO != null) {
            return ResponseEntity.ok(medicineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<MedicineDTO> saveMedicine(@RequestBody MedicineDTO medicineDTO) {
        medicineService.saveMedicine(medicineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicineDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        try {
            System.out.println("Deleting medicine with ID: " + id);
            medicineService.deleteMedicine(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log the exception and return a meaningful error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
