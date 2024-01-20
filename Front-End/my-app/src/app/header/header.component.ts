import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service.service';
import { TaxiServicesService } from '../services/taxi-services.service';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  isNavbarExpanded = false;
  @ViewChild('navbar') navbar: ElementRef | undefined;


  role!: any
  name!: any
  logged: any = '';
  loginForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl(),
  });
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


  constructor(private taxiService: TaxiServicesService,
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthService,
    private el: ElementRef,
    private userService: UserServiceService) { }

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

  toggleNavbar() {
    this.isNavbarExpanded = !this.isNavbarExpanded;
  }

  closeNavbar() {
    this.isNavbarExpanded = false;
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
          localStorage.setItem('currentUser', JSON.stringify(data));
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

}
