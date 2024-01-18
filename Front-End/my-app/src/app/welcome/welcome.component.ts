import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service.service';
import { FormControl, FormGroup, FormsModule, FormBuilder, Validators } from '@angular/forms';
import { TaxiServicesService } from '../services/taxi-services.service';
import { log } from 'console';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  @ViewChild('richiesteModal') richiesteModal!: ElementRef;
  richiesteForm: FormGroup;
  paymentForm: FormGroup;

  admin: any = false
  cliente: any = false
  tassista: any = false
  $: any;
  request: any[] = []
  taxi: any[] = []
  combinedOptions: { value: number, label: string }[] = [];
  destinations: { destination: any, rate: number }[] = []

  detTaxi: any[] = []
  detRequest: any[] = []
  clienteNome: any;
  taxiService: any;
  rate: any;
  constructor(private authService: AuthService, private router: Router, private ts: TaxiServicesService, private fb: FormBuilder,) {
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

formsReset(){
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

  prenota(rate: number) {

  }

  CourseMethod() {
    this.ts.getAllDestinations().subscribe(
      response => {
        response.forEach((element: any) => {
          console.log(element);

          this.destinations.push({ destination: element.startLocation.name + ' - ' + element.endLocation.name, rate: element.ratesType.amount })
        });

      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );
  }

  getAllRequest() {
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
    updatedRequest.state = 'Accettata';


    this.updateRequest(requestId, updatedRequest);
  }

  rejectRequest(requestId: number): void {

    const updatedRequest = this.request.find(r => r.id === requestId);
    updatedRequest.state = 'Rifiutata';

    this.updateRequest(requestId, updatedRequest);
  }


  onChangeSelect(event: Event) {
    this.rate = this.richiesteForm.controls['partenza_destinazione'].value
  }


  dettaglioRequest(request: any) {
    this.detTaxi.push(request)
  }


  paga(){
    this.formsReset()
  }









}


