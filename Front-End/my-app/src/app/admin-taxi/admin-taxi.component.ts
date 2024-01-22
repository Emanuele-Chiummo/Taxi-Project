import { Component, OnInit } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

interface User {
  name: string;
  surname: string;
  // Add other properties as needed
}



@Component({
  selector: 'app-admin-taxi',
  templateUrl: './admin-taxi.component.html',
  styleUrl: './admin-taxi.component.css'
})
export class AdminTaxiComponent implements OnInit{


  users: any[] = [];

  taxi: any[] = []

  ngOnInit(): void {

    this.getAllUser();
    this.getAlltaxi();  

  }

  constructor(private ts: TaxiServicesService, private fb: FormBuilder) { }

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

}





