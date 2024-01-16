import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service.service';
import { FormControl, FormGroup, FormsModule,FormBuilder, Validators } from '@angular/forms';
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
  detTaxi: any[] = []
  constructor(private authService: AuthService, private router: Router, private ts: TaxiServicesService , private fb: FormBuilder,) {
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
      this.getAlltaxi()
    } else if (localStorage.getItem('role') === 'cliente') {
      this.cliente = true
    } else if (localStorage.getItem('role') === 'tassista') {
      this.tassista = true
    }
  }

  ngAfterContentChecked() {
    if (typeof localStorage !== 'undefined' && localStorage.getItem('logged') && localStorage.getItem('Nome') && localStorage.getItem('role')) {

      //this.logged = localStorage.getItem('logged')
      this.cliente = localStorage.getItem('Nome')
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

closeDettaglio(){
  this.detTaxi = []
}

prenota() {
  // Implementa la logica di prenotazione qui
  // Esempio: Puoi emettere un evento, chiamare un servizio, ecc.
  console.log('Dettagli della prenotazione:', this.richiesteForm.value);
}









}
