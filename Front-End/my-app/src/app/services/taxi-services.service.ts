import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaxiServicesService {
  getAllCourse() {
    return this.http.get <any>('http://localhost:8080/api/course') 
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

  getAllRequestByState(state: string): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/request/pending')
  }

  getMyRequests(taxiId: number): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/request/accepted/' + taxiId)
  }

  updateRequest(requestId: number, updatePayload: any): Observable<any> {

    return this.http.put<any>('http://localhost:8080/api/request/' + requestId, updatePayload);
  }


  createRequest(body: any){
    return this.http.post <any>('http://localhost:8080/api/request', body )
  }

  getAllUser(): Observable <any>{
    return this.http.get <any>('http://localhost:8080/api/user') 

  }

  getTassisti(): Observable<any[]> {
    return this.http.get<any>('http://localhost:8080/api/user/tassisti');
  }

  updateTaxi(taxiId: number, updatePayload: any): Observable<any> {

    return this.http.put<any>('http://localhost:8080/api/taxi/' + taxiId, updatePayload);
  }

  deleteTaxi(taxiId: number): Observable<any> {
    return this.http.delete<any>('http://localhost:8080/api/taxi/' + taxiId);
  }

  


  

}
