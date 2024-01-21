import { Component } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

export interface Root {
  id: number
  identifier: string
  driver: Driver
}

export interface Driver {
  id: number
  name: string
  lastName: string
  fiscalCode: string
  email: string
  mobilePhone: string
  userType: string
  password: string
}

@Component({
  selector: 'app-tassista-my-request',
  templateUrl: './tassista-my-request.component.html',
  styleUrl: './tassista-my-request.component.css'
})
export class TassistaMyRequestComponent {

  cliente: any;
  request: any;
  richiesteForm: FormGroup;

  constructor(private ts: TaxiServicesService, private fb: FormBuilder) {
    this.richiesteForm = this.fb.group({
      partenza_destinazione: ['', [Validators.required]],
      data: ['', [Validators.required]],
      ora: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {

    const taxiId = localStorage.getItem('taxiId');

    if (!taxiId) {
      console.error('taxiId non presente in localStorage');
      return;
    }

    this.getMyRequests(Number(taxiId));


  }


  getAllRequestsByState(state: string): void {
    this.ts.getAllRequestByState(state).subscribe(
      data => {
        this.request = data;
      },
      error => {
        console.error('An error occurred:', error);
      }
    );
  }

  getMyRequests(taxiId: number): void {
    this.ts.getMyRequests(taxiId).subscribe(
      data => {
        this.request = data;
      },
      error => {
        console.error('An error occurred:', error);
      }
    );
  }


  /*
  getAllRequest() {
    console.log(this.cliente);
    this.ts.getAllRequest().subscribe(
      x => {
        this.request = x.filter((r: any) => r.state === 'Richiesta');
      },
      error => {
      }
    );
  } */

  /*
  getMyRequests() {
    const taxiId = localStorage.getItem('taxiId');
  
    if (!taxiId) {
      console.error('taxiId non presente in localStorage');
      return;
    }
  
    this.ts.getAllRequest().subscribe(
      x => {
        // Filtra solo le richieste in stato "Richiesta" e con taxi definito
        this.request = x.filter((r: any) => r.state === 'Accettata' && r.taxi && r.taxi.id === Number(taxiId));
      },
      error => {
        // Gestisci gli errori
      }
    );
  } */

  updateRequest(requestId: number, updatedRequest: any): void {
    this.ts.updateRequest(requestId, updatedRequest).subscribe(
      (response) => {
        // Puoi aggiornare la tua tabella o eseguire altre azioni dopo l'aggiornamento
      },
      (error) => {
        // Gestisci l'errore come preferisci
      }
    );
  }


  acceptRequest(requestId: number): void {
    const updatedRequest = this.request.find((r: { id: number; }) => r.id === requestId);

    // Leggi taxiId dal localStorage
    const taxiId = localStorage.getItem('taxiId');

    if (!taxiId) {
      console.error('taxiId non presente in localStorage');
      return;
    }

    // Chiamata al servizio per ottenere le informazioni sul taxi
    this.ts.getTaxiById(Number(taxiId)).subscribe(
      (taxiInfo) => {
        // Aggiornamento delle informazioni nel request
        updatedRequest.taxi = {
          id: taxiInfo.id,
          identifier: taxiInfo.identifier,
          driver: taxiInfo.driver
        };
        updatedRequest.state = 'Accettata';

        // Chiamata al servizio per aggiornare la richiesta sul server
        this.updateRequest(updatedRequest.id, updatedRequest);
      },
      (error) => {
        console.error('Errore durante la chiamata a getTaxiById', error);
      }
    );
  }

  rejectRequest(requestId: number): void {

    const updatedRequest = this.request.find((r: { id: number; }) => r.id === requestId);
    updatedRequest.state = 'Rifiutata';

    this.updateRequest(requestId, updatedRequest);
  }




}
