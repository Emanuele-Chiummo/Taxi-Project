import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service.service';
import { FormControl, FormGroup, FormsModule, FormBuilder, Validators } from '@angular/forms';
import { TaxiServicesService } from '../services/taxi-services.service';
import { log } from 'console';
import { UserServiceService } from '../services/user-service.service';

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
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  @ViewChild('richiesteModal') richiesteModal!: ElementRef;
  richiesteForm: FormGroup;
  paymentForm: FormGroup;
  data: any
  ora: any
  admin: any = false
  cliente: any = false
  tassista: any = false

  currentUser: any ;
  
  $: any;
  request: any[] = []
  taxi: any[] = []
  combinedOptions: { value: number, label: string }[] = [];
  destinations: { destination: any, rate: number }[] = []

  selectedCourse: any; // Sostituisci 'any' con il tipo appropriato della tua corsa

  idUser: any[] = []

  detTaxi: any[] = []
  detRequest: any[] = []
  clienteNome: any;
  taxiService: any;
  rate: any;
  payment: boolean = false;
  course: any;
  taxi_id: any;
  constructor(private authService: AuthService, private router: Router, private ts: TaxiServicesService, private fb: FormBuilder,private userService: UserServiceService) {
    this.richiesteForm = this.fb.group({
      partenza_destinazione: ['', [Validators.required]],
      data: ['', [Validators.required]],
      ora: ['', [Validators.required]],
    });
    this.paymentForm = this.fb.group({
      cardNumber: ['', [Validators.required, Validators.pattern(/^\d{16}$/)]],
      expiryDate: [''],
      cvv: ['', [Validators.required, Validators.pattern(/^\d{3}$/)]],
      saveCardData: [false]
    });
  }



  ngOnInit(): void {

    
    const currentUserValue = localStorage.getItem('currentUser');
    this.currentUser = currentUserValue !== null ? parseInt(currentUserValue, 10) : 0;

    if (!this.authService.isLogged()) {
      this.router.navigate(['/home']);
    }

    if (localStorage.getItem('role') === 'admin') {
      this.admin = true
      this.cliente = false
      this.tassista = false

      this.getAlltaxi()
    } else if (localStorage.getItem('role') === 'cliente') {

      this.admin = false
      this.cliente = true
      this.tassista = false
    } else if (localStorage.getItem('role') === 'tassista') {
      this.admin = false
      this.cliente = false
      this.tassista = true
      this.getAllRequest()
    }
  }

  ngAfterContentChecked() {
    if (typeof localStorage !== 'undefined' && localStorage.getItem('logged') && localStorage.getItem('Nome') && localStorage.getItem('role')) {

      this.clienteNome = localStorage.getItem('Nome')
    }
  }

  formsReset() {
    this.destinations = []
    this.richiesteForm.reset()
    this.paymentForm.reset()
  }



  getAlltaxi() {
    this.ts.getAllTaxi().subscribe(x => {
      this.taxi = x
    })
  }


  dettaglioTaxi(taxi: any) {
    this.detTaxi.push(taxi)
  }

  closeDettaglio() {
    this.detTaxi = []
  }



  /* CourseMethod() {
    this.ts.getAllDestinations().subscribe(
      response => {
        response.forEach((element: any) => {
          this.destinations.push({ destination: element.startLocation.name + ' - ' + element.endLocation.name, rate: element.ratesType.amount })
        });

      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );
  } */

  CourseMethod() {
    this.ts.getAllDestinations().subscribe(
      response => {
        response.forEach((element: any) => {
          this.destinations.push({ destination: element.startLocation.name + ' - ' + element.endLocation.name, rate: element.ratesType.amount })
        });
  
        // Memorizza la corsa selezionata (usando la prima corsa come esempio)
        this.selectedCourse = response[0];
      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );
  }

  getTaxiIdByDriverId(): void {
    const driverId = localStorage.getItem('currentUser');
  
    if (driverId && !isNaN(Number(driverId))) {
      // Verifica che driverId sia presente nel localStorage e sia un numero valido
      const numericDriverId = Number(driverId);

      console.log('Driver ID:', numericDriverId);
  
      this.ts.getTaxiIdByDriverId(numericDriverId).subscribe(
        (response) => {
          console.log('Taxi ID response:', response);
          localStorage.setItem('taxiId', response.toString());
  
          if (response !== null && response !== undefined) {
            // Aggiungi ulteriori operazioni se necessario
            this.taxi_id = response;
          } else {
            console.error('Taxi ID is null or undefined');
          }
        },
        (error) => {
          console.error('Error retrieving Taxi ID:', error);
        }
      );
    } else {
      console.log('Driver ID not found or invalid in local storage');
    }
  }
  

  getAllRequest() {
    console.log(this.cliente);
    this.ts.getAllRequest().subscribe(
      x => {
        this.request = x;
      },
      error => {
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
    const updatedRequest = this.request.find(r => r.id === requestId);
  
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
          id: taxiInfo.id,  // Assicurati che taxiInfo contenga l'id del taxi
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

    const updatedRequest = this.request.find(r => r.id === requestId);
    updatedRequest.state = 'Rifiutata';

    this.updateRequest(requestId, updatedRequest);
  }

    onChangeSelect(event: Event) {
    const selectedValue = this.richiesteForm.controls['partenza_destinazione'].value.split('_');
    this.course = selectedValue[1];
    this.rate = selectedValue[0]
  }

  onChangeSelectD(event: Event) {
    event = this.richiesteForm.controls['data'].value
    this.data = event
  }

  onChangeSelectH(event: Event) {
    event = this.richiesteForm.controls['ora'].value
    this.ora = event
  }


  dettaglioRequest(request: any) {
    this.detTaxi.push(request)
  }


  paga() {
    this.formsReset()
  }


  paymentSuccess() {

    if (!this.selectedCourse) {
      console.error('Errore: Nessuna corsa selezionata.');
      return;
    }
  
    let formattedDate = `${this.data}T${this.ora}:00`;
    let body = {
      id: 0,
      course: {
        id: this.selectedCourse.id,
        startLocation: {
          id: this.selectedCourse.startLocation.id,
          name: this.selectedCourse.startLocation.name,
          gps: this.selectedCourse.startLocation.gps
        },
        endLocation: {
          id: this.selectedCourse.endLocation.id,
          name: this.selectedCourse.endLocation.name,
          gps: this.selectedCourse.startLocation.gps
        },
        km: this.selectedCourse.km,
        ratesType: {
          id: 0,
          ratesType: this.selectedCourse.ratesType.ratesType,
          amount: this.selectedCourse.ratesType.amount
        }
      },
      date: formattedDate,
      state: 'Richiesta'
    };
  
    this.ts.createRequest(body).subscribe(
      x => {
        console.log(x);
        this.formsReset();
        this.payment = true;
        setTimeout(() => {
          this.payment = false;
        }, 3000);
      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );
  }
  
  
  

  










}


