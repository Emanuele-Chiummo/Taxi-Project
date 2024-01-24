import { ChangeDetectorRef, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { event } from 'jquery';


interface User {
  name: string;
  surname: string;
  // Add other properties as needed
}

interface TaxiFormModel {
  identifier: string;
  driver: User;
}


interface TaxiFormSubmit {
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
export class AdminTaxiComponent implements OnInit {




  taxiForm: FormGroup;

  confirmationMessage: string | null = null;


  selectedTaxi: any;

  errorMessage: string = '';

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
        active: ['']
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

  changeSelecy(event: Event): void {

    console.log('evento:', event);
  }


  saveChanges() {
    const formData = this.taxiForm.value;
    const selectedUserId = this.taxiForm.value.userPosition;

    // Ottieni l'ID direttamente dall'oggetto userPosition
    const user = formData.userPosition.id;

    // Chiamata al servizio per verificare se l'utente ha già un taxi associato
    this.ts.hasTaxi(user).subscribe(
      hasTaxi => {
        if (hasTaxi) {
          // L'utente ha già un taxi associato, gestisci l'errore come preferisci
          this.errorMessage = 'L\'utente ha già un taxi associato.';
          // Mostra un messaggio di errore o fai qualcos'altro
        } else {
          // Procedi con la creazione del taxi
          const requestBody = {
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

          // Invia la richiesta HTTP
          this.ts.postTaxi(requestBody).subscribe(
            response => {
              this.confirmationMessage = 'Taxi aggiunto Correttamente!';
              this.modalService.dismissAll();
              setTimeout(function () {
                window.location.reload();
              }, 3000);
            },
            error => {
              console.log(error);
            }
          );
        }
      },
      error => {
        console.error('Errore nella verifica del taxi:', error);
        // Gestisci l'errore come preferisci
      }
    );
  }


  closeModal() {
    // Chiudi la modale e reimposta lo stato del messaggio di successo
    this.modalService.dismissAll();
    this.taxiForm.reset();
  }

  openModalWithPrecompiledData(name: string, lastName: string) {

    console.log('Nome:', name + ' ' + lastName);

    let user = this.taxiForm.controls['userPosition'].patchValue({ name: name, lastName: lastName });

    console.log('User: ' + user);



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
        active: formData.userPosition.active

      },
      active: 1
    };


    // Invia la richiesta HTTP per aggiornare il taxi
    this.ts.updateTaxi(taxiId, updatePayload).subscribe(
      (response) => {
        this.confirmationMessage = 'Taxi aggiornato Correttamente!';

        setTimeout(function () {
          window.location.reload();
        }, 3000);
        // Puoi aggiungere ulteriori logica o azioni dopo l'aggiornamento del taxi
      },
      (error) => {
        console.error('Errore durante l\'aggiornamento del taxi:', error);
        // Gestisci eventuali errori o aggiungi ulteriori azioni di gestione degli errori
      }
    );
  }

  deactivateTaxi(taxi: any): void {
  
    const taxiId = taxi.id;

  this.ts.deactivateTaxi(taxiId).subscribe(
    (response) => {
      
    },
    (error) => {
      console.error('Errore durante la disattivazione del taxi:', error);
      // Gestisci eventuali errori o aggiungi ulteriori azioni di gestione degli errori
    }
  );

  }





}







