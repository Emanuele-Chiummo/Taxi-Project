import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaxiServicesService {
  getAllCourse() {
    throw new Error('Method not implemented.');
  }

  constructor(private http: HttpClient) { }

  getAllTaxi(): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/taxi') 

  }

  postTaxi(body: any): Observable <any>{
    return this.http.post <any>('http://localhost:8080/api/taxi', body ) 
  }

  getAllDestinations(): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/course') 

  }
}
