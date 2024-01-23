import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

interface User {
  name: string;
  surname: string;
  // Add other properties as needed
}

interface TaxiFormModel {
  identifier: string;
  driver: {
    id: number;
  }; 
}



@Component({
  selector: 'app-admin-taxi',
  templateUrl: './admin-taxi.component.html',
  styleUrl: './admin-taxi.component.css'
})
export class AdminTaxiComponent implements OnInit{


  taxiForm: FormGroup; 

  showConfirmationMessage: boolean = false;


  users: any[] = [];

  taxi: any[] = []
  tassisti: any[] = [];

  ngOnInit(): void {

    this.getAllUser();
    this.getAlltaxi();  

    this.loadTassisti();

  }

  constructor(private ts: TaxiServicesService, private fb: FormBuilder, private modalService: NgbModal) {
    this.taxiForm = this.fb.group({
      identifier: ['', Validators.required],
      userPosition: ['', Validators.required]
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
}




}

