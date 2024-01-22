import { Component } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';

@Component({
  selector: 'app-admin-course',
  templateUrl: './admin-course.component.html',
  styleUrl: './admin-course.component.css'
})
export class AdminCourseComponent {

  course: any[] = [];

  ngOnInit(): void {

    this.getAllCourse();

  }

  constructor(private ts: TaxiServicesService) { }

  getAllCourse(): void {
    this.ts.getAllCourse().subscribe((course) => {
      this.course = course;
  
      console.log(this.course);
  
    });

  }

}
