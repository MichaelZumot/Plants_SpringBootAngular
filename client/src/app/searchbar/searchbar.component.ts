import { Component } from '@angular/core';
import { PlantService } from '../service/plants.service';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent {
  userQuery: string = '';


  constructor(private plantService: PlantService) {}

    onSearch() {
      console.log("user query is ",this.userQuery);
      this.plantService.searchPlants(this.userQuery).subscribe(
        (data) => {
          // Handle the API response
          console.log("Data received", data);
        },
        (error: any) => {
          console.error(error);
        }
      );
    }
  } 
  