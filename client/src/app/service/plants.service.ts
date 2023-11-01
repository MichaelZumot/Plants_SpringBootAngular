import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plant } from '../model/plant.model';

@Injectable({
  providedIn: 'root',
})
export class PlantService {
  private backendUrl = 'http://localhost:8080/api/plants'; 

  constructor(private http: HttpClient) {}

 
  getPlants(): Observable<any> {
    return this.http.get(this.backendUrl);
  }

  addPlant(newPlant: Plant): Observable<Plant> {
    return this.http.post<Plant>(this.backendUrl, newPlant);
  }

  deletePlant(id: number): Observable<void> {
    console.log("deleting plant with id", id);
    return this.http.delete<void>(`${this.backendUrl}/${id}`);
}

  
}
