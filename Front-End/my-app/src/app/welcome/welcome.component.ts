import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service.service';
import { FormControl, FormGroup, FormsModule, FormBuilder, Validators } from '@angular/forms';
import { TaxiServicesService } from '../services/taxi-services.service';
import { error, log } from 'console';
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

  currentUser: any;

  $: any;
  request: any[] = []
  taxi: any[] = []
  combinedOptions: { value: number, label: string }[] = [];
  destination: any[] = []

  selectedCourse: any; // Sostituisci 'any' con il tipo appropriato della tua corsa

  selectedDestination: any;

  idUser: any[] = []

  showAllRequests: boolean = true;

  showTableUser: boolean = false;

  showTableCourse: boolean = false;

  detTaxi: any[] = []
  detRequest: any[] = []
  clienteNome: any;
  taxiService: any;
  rate: any;
  payment: boolean = false;
  course: any;
  taxi_id: any;
  user: any;
  constructor(private authService: AuthService, private router: Router, private ts: TaxiServicesService, private fb: FormBuilder, private userService: UserServiceService) {
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

    this.selectedDestination = null;


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
    //this.destination = []
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

  getAllRequest() {
    console.log(this.cliente);
    this.ts.getAllRequest().subscribe(
      x => {
        this.request = x.filter((r: any) => r.state === 'Richiesta');
      },
      error => {
      }
    );
  }


  getAllDestinations() {

    this.ts.getAllDestinations().subscribe(
      response => {
        this.destination = response;
        console.log('Destinazioni:', this.destination);
      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );

  }

  onDestinationChange() {
    

    if (this.selectedDestination) {
      
      this.selectedCourse = this.selectedDestination;

      //console.log('Corsa selezionata:', this.selectedCourse);
    } else {
      console.error('Opzione non valida.');
    }

  }

  onChangeSelectD(event: Event) {
    event = this.richiesteForm.controls['data'].value
    this.data = event
  }

  onChangeSelectH(event: Event) {
    event = this.richiesteForm.controls['ora'].value
    this.ora = event
  }

  createRequest() {
    const formValue = this.richiesteForm.value;
    const selectedOption = this.selectedCourse;
    let formattedDate = `${this.data}T${this.ora}:00`;
  
    if (selectedOption) {
      const requestBody = {
        id: 0,
        course: {
          id: selectedOption.id,
          startLocation: {
            id: selectedOption.startLocation.id,
            name: selectedOption.startLocation.name,
            gps: selectedOption.startLocation.gps
          },
          endLocation: {
            id: selectedOption.endLocation.id,
            name: selectedOption.endLocation.name,
            gps: selectedOption.endLocation.gps
          },
          km: selectedOption.km,
          ratesType: {
            id: selectedOption.ratesType.id,
            ratesType: selectedOption.ratesType.ratesType,
            amount: selectedOption.ratesType.amount
          },
          active: selectedOption.active
        },
        taxi: null,
        date: formattedDate,
        state: "Richiesta"
      };
  
      
      //console.log('Corpo della richiesta:', requestBody);
  
      this.ts.createRequest(requestBody).subscribe(
        response => {
          //console.log('Richiesta creata con successo:', response);

        },
        error => {
          console.error('Errore durante la creazione della richiesta:', error);
        }
      );
    } else {
      console.error('Opzione non valida.');
    }
  }
  






  navigateToUserPage() {
    this.router.navigate(['/user']);
  }

  navigateToCoursePage() {
    this.router.navigate(['/course']);
  }

  navigateToTaxiPage() {
    this.router.navigate(['/taxi']);
  }

  navigateToAnalyticsPage() {
    this.router.navigate(['/analytics']);
  }

  navigateToPendingRequestPage() {
    this.router.navigate(['/pending-request']);
  }

  navigateToMyRequestPage() {
    this.router.navigate(['/my-request']);
  }

  navigateToEmailRequest() {
    this.router.navigate(['/email-request']);
  }



}


