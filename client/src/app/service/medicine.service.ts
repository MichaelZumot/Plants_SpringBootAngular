import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {Medicine} from "../model/medicine.model";

@Injectable({
    providedIn: "root",
})
export class MedicineService {
    private backendUrl = "http://localhost:8080/api/medicheck";

    constructor(private http: HttpClient) {}

    getMedicine(): Observable<Medicine[]> {
        return this.http
            .get<Medicine[]>(this.backendUrl, { withCredentials: true })
            .pipe(
                catchError((error) => {
                    console.error('Error fetching medicines:', error);
                    return throwError(error);
                })
            );
    }

    addMedicine(medicine: Medicine): Observable<Medicine> {
        return this.http.post<Medicine>(this.backendUrl, medicine, { withCredentials: true });
    }

    deleteMedicine(id: number): Observable<void> {
        console.log("Deleting medicine with ID", id);
        return this.http.delete<void>(`${this.backendUrl}/${id}`, { withCredentials: true });
    }

    updateMedicine(medicine: Medicine): Observable<void> {
        return this.http.put<void>(`${this.backendUrl}/${medicine.id}`, medicine, { withCredentials: true });
    }
}
