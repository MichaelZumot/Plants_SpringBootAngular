import { Component } from '@angular/core';
import { PlantService } from '../service/plants.service';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {
  userQuery: string = '';
  searchResults: any[] = []; // Property to store search results


  ngOnInit(): void {
    console.log('XXXXX Search Results:', this.searchResults);
    this.searchResults = [];
  }

  constructor(private plantService: PlantService) {}
  onSearch() {
    console.log("user query is ", this.userQuery);
  
    this.plantService.searchPlants(this.userQuery).subscribe(
      (data) => {
        if (data && data.links && data.links.first) {
          console.log("First link:", data.links.first);
        }
  
        if (data && data.data) {
          this.searchResults = data.data;
          console.log("Data received", data.data);
        }
      },
      (error: any) => {
        console.error(error);
      }
    );
  }
  } 
  