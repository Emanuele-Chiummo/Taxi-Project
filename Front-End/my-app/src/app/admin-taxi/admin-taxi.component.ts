import { ChangeDetectorRef, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import e from 'express';

interface User {
  name: string;
  surname: string;
  // Add other properties as needed
}

interface TaxiFormModel {
  identifier: string;
  driver: User;
}



@Component({
  selector: 'app-admin-taxi',
  templateUrl: './admin-taxi.component.html',
  styleUrl: './admin-taxi.component.css'
})
export class AdminTaxiComponent implements OnInit{


  taxiForm: FormGroup; 

  showConfirmationMessage: boolean = false;

  selectedTaxi: any; 


  users: any[] = [];

  taxi: any[] = []
  tassisti: any[] = [];

  ngOnInit(): void {

    this.getAllUser();
    this.getAlltaxi();  

    this.loadTassisti();

  }

  constructor(private ts: TaxiServicesService, private fb: FormBuilder, private modalService: NgbModal, private cdr: ChangeDetectorRef) {
    this.taxiForm = this.fb.group({
      identifier: ['', Validators.required],
      userPosition: this.fb.group({
        id: [''],
        name: [''],
        lastName: [''],
        fiscalCode: [''],
        email: [''],
        mobilePhone: [''],
        userType: [''],
        password: [''],
      }),
    });
  }

  getAlltaxi() {
    this.ts.getAllTaxi().subscribe(x => {
      this.taxi = x
    })
  }

  getAllUser(): void {
    this.ts.getAllUser().subscribe((users: User[]) => {
        this.users = users;
        console.log(this.users);
    });
}

loadTassisti() {
  this.ts.getTassisti().subscribe(t => {
    this.tassisti = t;
  });
}

saveChanges() {
  // Recupera i dati dal form e invia la richiesta HTTP
  const formData = this.taxiForm.value;

  // Ottieni l'id selezionato dalla stringa 'userPosition'
  const selectedUserId = formData.userPosition.split(' ')[0];

  // Costruisci il corpo della richiesta da inviare
  const requestBody = {
    identifier: formData.identifier,
    driver: {
      id: selectedUserId,
    }
  };

  // Invia la richiesta HTTP
  this.ts.postTaxi(requestBody).subscribe(
    response => {

      this.showConfirmationMessage = true;
      this.modalService.dismissAll();

    },
    error => {
      console.log(error);
    }
  );
}

closeModal() {
  // Chiudi la modale e reimposta lo stato del messaggio di successo
  this.modalService.dismissAll();
  this.showConfirmationMessage = false;
  this.taxiForm.reset();
}

openModalWithPrecompiledData() {
  if (this.selectedTaxi) {
    const userPosition = {
      id: this.selectedTaxi.driver.id,
      name: this.selectedTaxi.driver.name,
      lastName: this.selectedTaxi.driver.lastName
    };

    console.log('tassisti:', this.tassisti);

    this.taxiForm.setValue({
      identifier: this.selectedTaxi.identifier,
      userPosition: userPosition.id,
    });

    this.cdr.detectChanges();
  } else {
    console.error('Nessun taxi selezionato');
  }
}

onSelectTaxi(taxi: any) {
  this.selectedTaxi = taxi;
  console.log('Taxi selezionato:', this.selectedTaxi);

  if (this.selectedTaxi) {
    const userPosition = {
      id: this.selectedTaxi.driver.id,
      name: this.selectedTaxi.driver.name,
      lastName: this.selectedTaxi.driver.lastName
    };

    console.log('userPosition:', userPosition);

    this.taxiForm.patchValue({
      identifier: this.selectedTaxi.identifier,
      userPosition: userPosition,
    });
  } else {
    console.error('Nessun taxi selezionato');
  }
}

updateTaxi(): void {

  // Recupera i dati dal form e ottieni l'id dell'utente selezionato
  const formData = this.taxiForm.value;
  const selectedUserId = this.taxiForm.value.userPosition;

  const taxiId = this.selectedTaxi.id;

  console.log('Valore di userPosition:', this.taxiForm.value.userPosition);

  const form = this.taxiForm.value;

  // Ottieni l'ID direttamente dall'oggetto userPosition
  const user = formData.userPosition.id;

  console.log('Valore di user:', user);

    // Costruisci il corpo della richiesta da inviare
    const updatePayload = {
      id: this.selectedTaxi.id,
      identifier: formData.identifier,
      driver: {
        id: formData.userPosition.id,
        name: formData.userPosition.name,
        lastName: formData.userPosition.lastName,
        fiscalCode: formData.userPosition.fiscalCode,
        email: formData.userPosition.email,
        mobilePhone: formData.userPosition.mobilePhone,
        userType: formData.userPosition.userType,
        password: formData.userPosition.password,
  
      }
    };
    
  
    // Invia la richiesta HTTP per aggiornare il taxi
    this.ts.updateTaxi(taxiId, updatePayload).subscribe(
      (response) => {
        console.log('Taxi aggiornato con successo:', response);
        // Puoi aggiungere ulteriori logica o azioni dopo l'aggiornamento del taxi
      },
      (error) => {
        console.error('Errore durante l\'aggiornamento del taxi:', error);
        // Gestisci eventuali errori o aggiungi ulteriori azioni di gestione degli errori
      }
    );
  }



}

/*
updateTaxi(): void {
  // Recupera i dati dal form e ottieni l'id dell'utente selezionato
  const formData = this.taxiForm.value;
  const selectedUserId = this.taxiForm.value.userPosition;

  console.log('Valore di userPosition:', this.taxiForm.value.userPosition);

  const form = this.taxiForm.value;

  // Ottieni l'ID direttamente dall'oggetto userPosition
  const user = formData.userPosition.id;

  console.log('Valore di user:', user);


  // Costruisci il corpo della richiesta da inviare
  const updatePayload = {
    id: this.selectedTaxi.id,
    identifier: formData.identifier,
    driver: {
      id: this.selectedTaxi.driver.id,

    }
  };
  

  // Ottieni l'ID del taxi da qualche fonte (potrebbe essere il tuo this.selectedTaxi.id)
  const taxiId = this.selectedTaxi.id;

  // Invia la richiesta HTTP per aggiornare il taxi
  this.ts.updateTaxi(taxiId, updatePayload).subscribe(
    (response) => {
      console.log('Taxi aggiornato con successo:', response);
      // Puoi aggiungere ulteriori logica o azioni dopo l'aggiornamento del taxi
    },
    (error) => {
      console.error('Errore durante l\'aggiornamento del taxi:', error);
      // Gestisci eventuali errori o aggiungi ulteriori azioni di gestione degli errori
    }
  );
} */






