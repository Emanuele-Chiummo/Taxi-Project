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
  activeTab: string = 'web';
  richiesteForm: FormGroup;
  email: any;

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

    this.getMyEmail(Number(taxiId));


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

  changeTab(tab: string): void {
    this.activeTab = tab;
  }

  getAllEmail(state: string): void {
    this.ts.getAllEmail(state).subscribe(
      data => {
        this.email = data;

        //console.log(this.email);
      },
      error => {
        console.error('An error occurred:', error);
      }
    );
  }


  getMyEmail(taxiId: number): void {
    this.ts.getMyEmail(taxiId).subscribe(
      data => {
        this.email = data;
      },
      error => {
        console.error('An error occurred:', error);
      }
    );
  }

  updateEmail(EmailId: number, updateEmail: any): void {
    this.ts.updateEmail(EmailId, updateEmail).subscribe(
      (response) => {
        // Puoi aggiornare la tua tabella o eseguire altre azioni dopo l'aggiornamento
      },
      (error) => {
        // Gestisci l'errore come preferisci
      }
    );
  }

  acceptEmail(emailId: number): void {
    const updateEmail = this.email.find((r: { id: number; }) => r.id === emailId);
  
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
        updateEmail.taxi = {
          id: taxiInfo.id,  
          identifier: taxiInfo.identifier,
          driver: taxiInfo.driver,
          active: 1
        };
        updateEmail.state = 'Accettata';
  
        // Chiamata al servizio per aggiornare la richiesta sul server
        this.updateEmail(updateEmail.id, updateEmail);
      },
      (error) => {
        console.error('Errore durante la chiamata a getTaxiById', error);
      }
    );
  }

  

  rejectEmail(emailId: number): void {

    const updateEmail = this.email.find((r: { id: number; }) => r.id === emailId);
    updateEmail.state = 'Rifiutata';

    this.updateEmail(emailId, updateEmail);
  }

}







