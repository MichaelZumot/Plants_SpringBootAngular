import { ChangeDetectionStrategy, Component, NgModule, OnInit } from '@angular/core';
import { Plant, WateringSchedule } from '../model/plant.model';
import { PlantService } from '../service/plants.service';


@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css'],
  changeDetection: ChangeDetectionStrategy.Default,
  providers: [], 

})
export class GalleryComponent implements OnInit {
  plants: Plant[] = [];
  newPlant: Plant = {
    id:0,
    name: '',
    latinName: '',
    description: '',
    wateringSchedule: WateringSchedule.BIWEEKLY,
  };

  wateringSchedules = Object.keys(WateringSchedule);

  constructor(private plantService: PlantService) {}

  ngOnInit(): void {
    this.fetchPlants();
  }

  fetchPlants(): void {
    this.plantService.getPlants().subscribe(
      (plants) => {
        this.plants = plants;
        console.log('Plants received:', this.plants);
      },
      (error) => {
        console.error('Error fetching plants:', error);
      }
    );
  } 


  addPlant(): void {
    this.plantService.addPlant(this.newPlant).subscribe(
      (addedPlant) => {
        if (addedPlant) {
          console.log('Plant added successfully:', addedPlant);
          this.plants.push(addedPlant);
          this.newPlant = {
            id:0,
            name: '',
            latinName: '',
            description: '',
            wateringSchedule: WateringSchedule.DAILY,
          };
        } else {
          console.error('Error: Server response is null.');
        }
      },
      (error) => {
        console.error('Error adding plant:', error);
      }
    );
  }


  getPlantImageUrl(plant: Plant): string {
  
    if (plant && plant.id !== null && plant.id !== undefined) {
      return `assets/images/${plant.id}.png`;
    } else {
      console.error('Invalid plant or plant id:', plant);
      console.log("plant image url is " + "assets/images/${plant.id}.png", )
      return 'assets/images/${plant.id}.png'; 
    }
  }

  deletePlant(id: number): void {

    this.plantService.deletePlant(id).subscribe(() => {
      // Remove the deleted plant from the list
      this.plants = this.plants.filter((plant) => plant.id !== id);
      console.log("Deleting plant with ID: ", id);

    });
  }
  getWateringScheduleDescription(schedule: WateringSchedule): string {
    switch (schedule) {
      case WateringSchedule.DAILY:
        return 'Daily';
      case WateringSchedule.WEEKLY:
        return 'Weekly';
      case WateringSchedule.BIWEEKLY:
        return 'Bi-Weekly';
      case WateringSchedule.ASNEEDED:
        return 'As needed';
      default:
        return 'Unknown';
    }
  }

  
}