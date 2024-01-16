import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Credential {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  authenticate(username: string, password: string): Observable<any> {
    const credentials = { username: username, password: password };
    const url = `${this.baseUrl}/login`;
    return this.http.post<any>(url, credentials);
  }
  

  isLogged = () : boolean => (typeof localStorage !== 'undefined' && localStorage.getItem("logged")) ? true : false;


}
