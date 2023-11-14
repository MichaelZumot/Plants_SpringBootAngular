import { Component, OnInit } from "@angular/core";
import { Plant, WateringSchedule } from "../model/plant.model";
import { PlantService } from "../service/plants.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  plants: Plant[] = [];
  newPlant: Plant = {
    id: 0,
    name: "",
    latinName: "",
    description: "",
    wateringSchedule: WateringSchedule.BIWEEKLY,
    lastWatered:new Date()
  };

  wateringSchedules = Object.keys(WateringSchedule);

  constructor(private plantService: PlantService) {}

  ngOnInit(): void {}

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
            lastWatered:new Date()
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

  getWateringScheduleDescription(schedule: number): string {
    switch (schedule) {
      case 1:
        return "Daily";
      case 2:
        return "Weekly";
      case 3:
        return "Bi-Weekly";
      case 4:
        return "As needed";
      default:
        return "Unknown";
    }
  }

  getHomeImage(name: string): string {
    return this.plantService.getImageUrlString(name);
  }
}
