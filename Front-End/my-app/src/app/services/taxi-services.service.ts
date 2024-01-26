import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaxiServicesService {

  //Course Service

  getAllCourse() {
    return this.http.get<any>('http://localhost:8080/api/course')
  }

  updateCourse(courseId: number, updatePayload: any): Observable<any> {
    return this.http.put<any>('http://localhost:8080/api/course/' + courseId, updatePayload);
  }

  constructor(private http: HttpClient) { }

  getAllTaxi(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/taxi')
  }

  hasTaxi(driverId: number): Observable<boolean> {
    return this.http.get<boolean>('http://localhost:8080/api/taxi/hasTaxi/' + driverId);

  }

  deactivateTaxi(taxiId: number): Observable<any> {
    return this.http.put<any>('http://localhost:8080/api/taxi/deactivate/' + taxiId, null);
  }

  getTaxiIdByDriverId(driverId: number): Observable<number> {
    return this.http.get<number>(`http://localhost:8080/api/taxi/` + driverId);
  }

  getTaxiById(taxiId: any): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/taxi/id/' + taxiId);
  }

  postTaxi(body: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/taxi', body)
  }

  getAllDestinations(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/course')

  }

  getAllRequest(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/request')
  }

  getAllRequestByState(state: string): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/request/pending')
  }

  getMyRequests(taxiId: number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/request/accepted/' + taxiId)
  }

  updateRequest(requestId: number, updatePayload: any): Observable<any> {

    return this.http.put<any>('http://localhost:8080/api/request/' + requestId, updatePayload);
  }


  createRequest(body: any) {
    return this.http.post<any>('http://localhost:8080/api/request', body)
  }

  //User Service

  getAllUser(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/user')

  }

  deactivateUser(userId: number): Observable<any> {
    return this.http.put<any>('http://localhost:8080/api/user/deactivate/' + userId, null);
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

  getChartData(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/request/most-popular');
  }

  getTaxiPerformace(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/request/taxi-performance');
  }

  getEntryPerformance(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/request/entry-performance');
  }






}
