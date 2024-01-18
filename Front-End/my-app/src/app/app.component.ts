import { AfterViewInit, ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { TaxiServicesService } from './services/taxi-services.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from './services/auth-service.service';
import { log } from 'console';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit {
  @ViewChild('signupModal') signupModal!: ElementRef;
  @ViewChild('loginModal') loginModal!: ElementRef;
  title = 'my-app';
  logged: any = '';
  $: any;
  loginForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl(),
  });
  role!: any
  name!: any
  error: boolean = false
  errorMsg!: string
  signUpForm = new FormGroup({
    nome: new FormControl(),
    cognome: new FormControl(),
    email: new FormControl(),
    codiceFiscale: new FormControl(),
    password: new FormControl(),
    telefono: new FormControl()
  });
  isNavbarOpen = false;




  constructor(private taxiService: TaxiServicesService,
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthService,
    private el: ElementRef) { }

  ngOnInit(): void {
    
    
    if (typeof localStorage !== 'undefined' && localStorage.getItem('logged') !== null) {
      this.logged = localStorage.getItem('logged');
    } else {
      this.logged = '';
    }
    this.signUpFormInit()
    this.loginFormInit()
  }

  ngAfterContentChecked() {
    if (typeof localStorage !== 'undefined' && localStorage.getItem('logged') && localStorage.getItem('Nome') && localStorage.getItem('role')) {

      this.logged = localStorage.getItem('logged')
      this.name = localStorage.getItem('Nome')
      this.role = localStorage.getItem('role')
    }

  }


  signUpFormInit() {
    this.signUpForm = this.fb.group({
      nome: ['', [Validators.required]],
      cognome: ['', [Validators.required]],
      email: ['', [Validators.required]],
      password: ['', [Validators.required]],
      telefono: ['', [Validators.required, Validators.pattern(/^\+?39?[0-9]+$/)]],
      codiceFiscale: ['', [Validators.required, Validators.pattern(/^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/)]],
    });
  }

  loginFormInit() {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  TaxiMethod() {
    this.taxiService.getAllTaxi().subscribe(taxi => { })
  }


  signUp() {
    if (typeof localStorage !== 'undefined') {
      localStorage.setItem('logged', 'logged');
      window.location.reload();
    } else {
      console.error('localStorage is not available');
    }
  }

  login() {
    this.authService.authenticate(this.loginForm.value.username, this.loginForm.value.password).subscribe(
      data => {
        if (typeof localStorage !== 'undefined') {
          localStorage.setItem('Nome', data.name + ' ' + data.lastName);
          localStorage.setItem('logged', 'logged');
          localStorage.setItem('role', data.userType);
        }
        this.router.navigate(['welcome']);
      },
      error => {
        this.error = true
        this.errorMsg = error.error;
        setTimeout(() => {
          this.error = false
          this.errorMsg = error.error;
        }, 3000);
      }
    );
  }


  logout() {
    if (typeof localStorage !== 'undefined') {
      localStorage.clear();
      window.location.reload();
    } else {
      console.error('localStorage is not available');
    }

  }

  chiudiModale(): void {
    this.$('#login').modal('hide');

  }

  toggleNavbar() {
    this.isNavbarOpen = !this.isNavbarOpen;
    if (!this.isNavbarOpen) {
      this.rimuoviClasseShow()
    }
  }

  rimuoviClasseShow() {
    const elemento = this.el.nativeElement;
    elemento.classList.remove('show');
  }

  

}




