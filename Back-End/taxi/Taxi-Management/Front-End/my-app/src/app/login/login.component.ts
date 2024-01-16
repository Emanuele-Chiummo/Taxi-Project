import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { log } from 'node:console';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  logged: any;
  myForm!: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    if (typeof localStorage !== 'undefined') {
      this.logged = localStorage.getItem('logged')
    }
    this.formInit()
  }

  login() {
    localStorage.setItem('logged', 'logged')
    this.router.navigate(['home'])
  }



  formInit() {
    this.myForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  
}
