import { Component, OnInit } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';

@Component({
  selector: 'app-tassista-email-request',
  templateUrl: './tassista-email-request.component.html',
  styleUrl: './tassista-email-request.component.css'
})
export class TassistaEmailRequestComponent implements OnInit{
  email: any;

  constructor(private ts: TaxiServicesService,) {}
  
  ngOnInit(): void {

    this.getAllEmail('Richiesta');
    
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

