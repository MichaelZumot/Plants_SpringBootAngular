import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Plant } from "../model/plant.model";

@Injectable({
  providedIn: "root",
})
export class PlantService {
  private backendUrl = "http://localhost:8080/api/plants";
  private plantApiUrl = "https://trefle.io/api/v1/plants"; // Replace with the actual plant API URL

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

  updatePlant(plant: Plant): Observable<void> {
    return this.http.put<void>(`${this.backendUrl}/${plant.id}`, plant);
  }

  updateLastWatered(plantId: number): Observable<void> {
    const url = `${this.backendUrl}/${plantId}/update-last-watered`;
    return this.http.patch<void>(url, {});
  }
  
  searchPlants(query: string): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        "Content-Type": "application/json",
      }),
    };

    console.log("searchPlants query is : ", query);

    const params = { q: query };

    return this.http.get("http://localhost:3000/api/plants/search", {
      headers: httpOptions.headers,
      params,
    });
  }

  getPlantImageUrl(plant: Plant): string {
    if (plant && plant.id !== null && plant.id !== undefined) {
      return `http://localhost:8080/api/images/${plant.id}`;
    } else {
      console.error('Invalid plant or plant id:', plant);
      return 'assets/images/default.png'; // Provide a default image or handle the case accordingly
    }
  }

  getImageUrlString(name: string): string {
    if (name != null || name != "") {
      return `http://localhost:8080/api/images/byName/${name}`;
    } else {
      console.error('Invalid image name:', name);
      return 'assets/resource/mainbg.png'; // Provide a default image or handle the case accordingly
    }
  }
}
