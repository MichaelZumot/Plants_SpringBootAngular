import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
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

  getPlantImage(plant: Plant): string {
    if (plant && plant.id !== null && plant.id !== undefined) {
      return `http://localhost:8080/api/images/${plant.id}`;
    } else {
      console.error('Invalid plant or plant id:', plant);
      return 'assets/images/default.png'; // Provide a default image or handle the case accordingly
    }
  }

  getImageUrlString(name: string): string {
    if (name != null || name != "") {
      return `http://localhost:8080/api/images/${name}`;
    } else {
      console.error('Invalid image name:', name);
      return 'assets/images/default.png'; // Provide a default image or handle the case accordingly
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

  onFileChange(event: any): void {
    const file = event.target.files[0];
  
    if (file && file.type === 'image/png') {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageUrl = e.target?.result || null; // Handle the case where e.target?.result is undefined
      };
  
      reader.readAsDataURL(file);
    } else {
      // Handle invalid file type (if needed)
      console.error('Invalid file type. Please choose a PNG image.');
    }
  }

  onSubmit(): void {
    // Add logic to save the image to the server or perform other actions
    // For example, you can use HttpClient to send the image to the server

    // const formData = new FormData();
    // formData.append('plantImage', file);

    // this.http.post('your-backend-endpoint', formData).subscribe(response => {
    //   console.log('Image uploaded successfully', response);
    // });
  }
}