import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plant } from '../model/plant.model';

@Injectable({
  providedIn: 'root',
})
export class PlantService {
  private backendUrl = 'http://localhost:8080/api/plants'; 
  private plantApiUrl = 'https://trefle.io/api/v1/plants'; // Replace with the actual plant API URL

  
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

//Plant API
getPlantApiData(): Observable<any> {
  return this.http.get(this.plantApiUrl);
}

searchPlants(query: string): Observable<any> {
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  console.log("searchPlants query is : ", query);

  const params = { q: query };

  return this.http.get('http://localhost:3000/api/plants/search', { headers: httpOptions.headers, params });
}


}
