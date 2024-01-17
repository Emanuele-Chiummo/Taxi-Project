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

  admin: any = false
  cliente: any = false
  tassista: any = false
  $: any;
  taxi: any[] = []
  combinedOptions: { value: number, label: string }[] = [];
  destinations: any[] = []


  detTaxi: any[] = []
  clienteNome: any;
  taxiService: any;
  constructor(private authService: AuthService, private router: Router, private ts: TaxiServicesService, private fb: FormBuilder,) {
    this.richiesteForm = this.fb.group({
      partenza_destinazione: ['', [Validators.required]],
      data: ['', [Validators.required]],
      ora: ['', [Validators.required]],
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
      console.log('yes', this.cliente);
    } else if (localStorage.getItem('role') === 'tasista') {
      this.admin = false
      this.cliente = false
      this.tassista = true
    }
  }

  ngAfterContentChecked() {
    if (typeof localStorage !== 'undefined' && localStorage.getItem('logged') && localStorage.getItem('Nome') && localStorage.getItem('role')) {

      this.clienteNome = localStorage.getItem('Nome')
    }

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

  prenota() {
    // Implementa la logica di prenotazione qui
    // Esempio: Puoi emettere un evento, chiamare un servizio, ecc.
    // console.log('Dettagli della prenotazione:', this.richiesteForm.value);
  }

  CourseMethod() {
    this.ts.getAllDestinations().subscribe(
      response => {
        response.forEach((element: any) => {
          this.destinations.push(element.startLocation.name + ' - ' + element.endLocation.name)
        });

      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );
  }
}


