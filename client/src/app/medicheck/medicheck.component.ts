import {Component, OnInit} from "@angular/core";
import {Medicine} from "../model/medicine.model"; // Update the import statement
import {MedicineService} from "../service/medicine.service"; // Update the import statement

@Component({
    selector: "app-medicheck",
    templateUrl: "./medicheck.component.html",
    styleUrls: ["./medicheck.component.css"]
})
export class MedicheckComponent implements OnInit {
    medicines: Medicine[] = [];
    newMedicine: Medicine = {
        id: 0,
        name: "",
        expiryDate: new Date(),
        quantity: 0,
    };

    constructor(private medicineService: MedicineService) {
    } // Update the service type

    ngOnInit(): void {
        this.fetchMedicines();
    }

    fetchMedicines(): void {
        this.medicineService.getMedicine().subscribe(
            (response: Medicine[] | any) => {
                if (Array.isArray(response)) {
                    this.medicines = response;
                    console.log("Medicines received:", this.medicines);
                } else if (
                    typeof response === "object" &&
                    response._embedded &&
                    Array.isArray(response._embedded.medicines)
                ) {
                    this.medicines = response._embedded.medicines;
                    console.log("Medicines received:", this.medicines);
                } else {
                    console.error(
                        "Invalid response format. Expected an array or an object with '_embedded.medicines' property."
                    );
                }
            },
            error => {
                console.error("Error fetching medicines:", error);
            }
        );
    }

    addMedicine(): void {
        this.medicineService.addMedicine(this.newMedicine).subscribe(
            addedMedicine => {
                if (addedMedicine) {
                    console.log("Medicine added successfully:", addedMedicine);
                    this.medicines.push(addedMedicine);
                    this.newMedicine = {
                        id: 0,
                        name: "",
                        expiryDate:new Date(),
                        quantity:0
                    };
                } else {
                    console.error("Error: Server response is null.");
                }
            },
            error => {
                console.error("Error adding medicine:", error);
            }
        );
    }

    deleteMedicine(id: number): void {
        this.medicineService.deleteMedicine(id).subscribe(() => {
            this.medicines = this.medicines.filter(
                medicine => medicine.id !== id
            );
            console.log("Deleting medicine with ID:", id);
        });
    }
}