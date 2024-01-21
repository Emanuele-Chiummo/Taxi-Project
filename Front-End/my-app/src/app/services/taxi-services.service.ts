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

  getTaxiIdByDriverId(driverId: number): Observable<number> {
    return this.http.get<number>(`http://localhost:8080/api/taxi/` + driverId);
}

getTaxiById(taxiId: any): Observable<any> {
  return this.http.get<any>('http://localhost:8080/api/taxi/id/' + taxiId);
}

  postTaxi(body: any): Observable <any>{
    return this.http.post <any>('http://localhost:8080/api/taxi', body ) 
  }

  getAllDestinations(): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/course') 

  }

  getAllRequest(): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/request')
  }

  updateRequest(requestId: number, updatePayload: any): Observable<any> {

    return this.http.put<any>('http://localhost:8080/api/request/' + requestId, updatePayload);
  }


  createRequest(body: any){
    return this.http.post <any>('http://localhost:8080/api/request', body )
  }


  

}
