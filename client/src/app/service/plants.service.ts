import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable, throwError} from "rxjs";
import {Plant} from "../model/plant.model";

@Injectable({
    providedIn: "root",
})
export class PlantService {
    private backendUrl = "http://localhost:8080/api/plants";
    private plantApiUrl = "https://trefle.io/api/v1/plants";

    constructor(private http: HttpClient) {
    }

    getPlants(): Observable<Plant[]> {
        return this.http.get<any[]>(this.backendUrl, { withCredentials: true })
            .pipe(
                map(plants => plants as Plant[]), // Type assertion here
                catchError(error => {
                    console.error('Error fetching plants:', error);
                    return throwError(error);
                })
            );
    }

    addPlant(newPlant: Plant): Observable<Plant> {
        return this.http.post<Plant>(this.backendUrl, newPlant, {withCredentials: true});
    }

    deletePlant(id: number): Observable<void> {
        console.log("deleting plant with id", id);
        return this.http.delete<void>(`${this.backendUrl}/${id}`, {withCredentials: true});
    }

    // Plant API
    getPlantApiData(): Observable<any> {
        return this.http.get<any>(this.plantApiUrl);
    }

    updatePlant(plant: Plant): Observable<void> {
        return this.http.put<void>(`${this.backendUrl}/${plant.id}`, plant, {withCredentials: true});
    }

    updateLastWatered(plant:Plant): Observable<void> {
        const url = `${this.backendUrl}/${plant}/update-last-watered`;
        console.log("url sent:", url);
        return this.http.patch<void>(url, {}, {withCredentials: true});
    }

    searchPlants(query: string): Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                "Content-Type": "application/json",
                "Accept": "application/json",
            }),
            params: {q: query},
            withCredentials: true,
        };

        console.log("searchPlants query is : ", query);

        return this.http.get<any>("http://localhost:3000/api/plants/search", httpOptions);
    }

    getPlantImageUrl(plant: Plant): string {
        if (plant && plant.id !== null && plant.id !== undefined) {
            return `http://localhost:8080/api/images/${plant.id}`;
        } else {
            console.error('Invalid plant or plant id:', plant);
            return 'assets/images/default.png';
        }
    }

    getImageUrlString(name: string): string {
        if (name) {
            return `http://localhost:8080/api/images/byName/${name}`;
        } else {
            console.error('Invalid image name:', name);
            return 'assets/resource/mainbg.png';
        }
    }
}
