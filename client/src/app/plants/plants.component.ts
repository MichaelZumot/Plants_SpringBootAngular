import { Component, OnInit } from "@angular/core";
import { Plant, WateringSchedule } from "../model/plant.model";
import { PlantService } from "../service/plants.service";

@Component({
  selector: "app-plants",
  templateUrl: "./plants.component.html",
  styleUrls: ["./plants.component.css"],
})
export class PlantsComponent implements OnInit {
  plants: Plant[] = [];
  newPlant: Plant = {
    id: 0,
    name: "",
    latinName: "",
    description: "",
    wateringSchedule: WateringSchedule.BIWEEKLY,
    lastWatered: new Date(),
  };
  wateringSchedules = Object.keys(WateringSchedule);
  imageUrl: string | ArrayBuffer | null = null;

  constructor(private plantService: PlantService) {
    this.imageUrl = null;
  }

  ngOnInit(): void {
    this.fetchPlants();
  }

  fetchPlants(): void {
    this.plantService.getPlants().subscribe(
      (plants) => {
        this.plants = plants;
        console.log("Plants received:", this.plants);
      },
      (error) => {
        console.error("Error fetching plants:", error);
      }
    );
  }

  addPlant(): void {
    this.plantService.addPlant(this.newPlant).subscribe(
      (addedPlant) => {
        if (addedPlant) {
          console.log("Plant added successfully:", addedPlant);
          this.plants.push(addedPlant);
          this.newPlant = {
            id: 0,
            name: "",
            latinName: "",
            description: "",
            wateringSchedule: WateringSchedule.DAILY,
            lastWatered: new Date(),
          };
        } else {
          console.error("Error: Server response is null.");
        }
      },
      (error) => {
        console.error("Error adding plant:", error);
      }
    );
  }

  getPlantImage(plant: Plant): string {
    if (plant && plant.id !== null && plant.id !== undefined) {
      return `http://localhost:8080/api/images/${plant.id}`;
    } else {
      console.error("Invalid plant or plant id:", plant);
      return "assets/images/default.png"; // Provide a default image or handle the case accordingly
    }
  }

  getImageUrlString(name: string): string {
    if (name != null || name != "") {
      return `http://localhost:8080/api/images/${name}`;
    } else {
      console.error("Invalid image name:", name);
      return "assets/images/default.png"; // Provide a default image or handle the case accordingly
    }
  }

  deletePlant(id: number): void {
    this.plantService.deletePlant(id).subscribe(() => {
      // Remove deleted plant from list
      this.plants = this.plants.filter((plant) => plant.id !== id);
      console.log("Deleting plant with ID: ", id);
    });
  }
  getWateringScheduleDescription(schedule: WateringSchedule): string {
    switch (schedule) {
      case WateringSchedule.DAILY:
        return "Daily";
      case WateringSchedule.WEEKLY:
        return "Weekly";
      case WateringSchedule.BIWEEKLY:
        return "Bi-Weekly";
      case WateringSchedule.ASNEEDED:
        return "As needed";
      default:
        return "Unknown";
    }
  }

  onFileChange(event: any): void {
    const file = event.target.files[0];

    if (file && file.type === "image/png") {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageUrl = e.target?.result || null; // Handle the case where e.target?.result is undefined
      };

      reader.readAsDataURL(file);
    } else {
      // Handle invalid file type (if needed)
      console.error("Invalid file type. Please choose a PNG image.");
    }
  }

  updateLastWatered(plant: Plant): void {
    this.plantService.updateLastWatered(plant.id).subscribe(
      () => {
        console.log("Last watered timestamp updated successfully.");
        // Refresh the plant list or update the local data accordingly
      },
      (error) => {
        console.error("Error updating last watered timestamp:", error);
      }
    );
  }
}
