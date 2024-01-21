import { Component } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrl: './admin-user.component.css'
})
export class AdminUserComponent {

  showAllRequests: boolean = true;

  showTableUser: boolean = false;

  showTableCourse: boolean = false;

  user: any[] = [];

  course: any[] = [];

  

  constructor(private ts: TaxiServicesService) { }

  ngOnInit(): void {
  }

    //Admin

    getAllUser(): void {
      this.ts.getAllUser().subscribe((user) => {
        this.user = user;
  
        console.log(this.user);
  
        this.showTableUser = true;
      });
  }
  
  toggleTableUser(): void {
    this.showTableUser = !this.showTableUser;
  
    // Se la tabella viene mostrata, carica gli utenti
    if (this.showTableUser) {
      this.getAllUser();
    }
  }
  
  getAllCourse(): void {
    this.ts.getAllCourse().subscribe((course) => {
      this.course = course;
  
      console.log(this.course);
  
      this.showTableCourse = true;
    });
  
  
  }
  
  toggleTableCourse(): void {
    this.showTableCourse = !this.showTableCourse;
  
    // Se la tabella viene mostrata, carica gli utenti
    if (this.showTableCourse) {
      this.getAllCourse();
    }
  }

}
