import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
@Injectable({
  providedIn: 'root',
})
export class UserServiceService {

  private utenteLoggatoSubject = new BehaviorSubject<any>(null);
  utenteLoggato$: Observable<any> = this.utenteLoggatoSubject.asObservable();

  private loginDateSubject = new BehaviorSubject<Date | null>(null);
  loginDate$: Observable<Date | null> = this.loginDateSubject.asObservable();

  setUtenteLoggato(utente: any) {
    this.utenteLoggatoSubject.next(utente);
  }

  setLoginDate(date: Date | null) {
    this.loginDateSubject.next(date);
  }

  constructor() { }
}
