import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service.service';
import { FormControl, FormGroup, FormsModule, FormBuilder, Validators } from '@angular/forms';
import { TaxiServicesService } from '../services/taxi-services.service';
import { log } from 'console';

interface Course {
  id: number;
  startLocation: {
    id: number;
    name: string;
    gps: string;
  };
  endLocation: {
    id: number;
    name: string;
    gps: string;
  };
  km: number;
  ratesType: {
    id: number;
    ratesType: string;
    amount: number;
  };
}

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

  partenzaOptions: { value: number, label: string }[] = [];
  destinazioneOptions: { value: number, label: string }[] = [];
  
  // Combina le opzioni di partenzaOptions e destinazioneOptions
  combinedOptions: { value: number, label: string }[] = [];
  

  

  


  detTaxi: any[] = []
  clienteNome: any;
  taxiService: any;
  constructor(private authService: AuthService, private router: Router, private ts: TaxiServicesService, private fb: FormBuilder,) {
    this.richiesteForm = this.fb.group({
      partenza: ['', [Validators.required]],
      destinazione: ['', [Validators.required]],
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
      this.tassista = true    }
  }

  ngAfterContentChecked() {
    if (typeof localStorage !== 'undefined' && localStorage.getItem('logged') && localStorage.getItem('Nome') && localStorage.getItem('role')) {

      //this.logged = localStorage.getItem('logged')
      this.clienteNome = localStorage.getItem('Nome')
      //this.role = localStorage.getItem('role')
    }

  }


  getAlltaxi() {
    this.ts.getAllTaxi().subscribe(x => {
      this.taxi = x
    })
  }


  dettaglioTaxi(taxi: any) {
    this.detTaxi.push(taxi)
    console.log('dt', this.detTaxi);
  }

  closeDettaglio() {
    this.detTaxi = []
  }

  prenota() {
    // Implementa la logica di prenotazione qui
    // Esempio: Puoi emettere un evento, chiamare un servizio, ecc.
    console.log('Dettagli della prenotazione:', this.richiesteForm.value);
  }

  CourseMethod() {
    this.ts.getAllDestinations().subscribe(
      response => {
        const courses = response as Course[]; 
        console.log('Lista destinazioni:', courses);
        
        
        this.partenzaOptions = courses.map(course => ({
          value: course.startLocation.id,
          label: course.startLocation.name
        }));
  
       
        this.destinazioneOptions = courses.map(course => ({
          value: course.endLocation.id,
          label: course.endLocation.name
        }));

// Combina le opzioni di partenzaOptions e destinazioneOptions
this.combinedOptions = [];

// Aggiungi l'opzione con la concatenazione come primo elemento
this.combinedOptions.push({ value: -1, label: `${this.partenzaOptions[0].label} - ${this.destinazioneOptions[0].label}` });


      },
      error => {
        console.error('Errore nella chiamata API:', error);
      }
    );
  }
  }
  

