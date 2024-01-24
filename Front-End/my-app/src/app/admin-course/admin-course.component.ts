import { Component, OnInit } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-course',
  templateUrl: './admin-course.component.html',
  styleUrl: './admin-course.component.css'
})
export class AdminCourseComponent implements OnInit{

  updateForm: FormGroup; 

  courseId: number = 0;

  confirmationMessage: string | null = null;


  course: any[] = [];
  route: any;
  selectedCourse: any; 

  ngOnInit(): void {
    this.getAllCourse();
    this.initUpdateForm();
  }

  constructor(private ts: TaxiServicesService, private formBuilder: FormBuilder) {
    this.updateForm = this.formBuilder.group({
      tratta: ['', Validators.required],
      km: ['', Validators.required],
      tariffa: ['', Validators.required],
      // ... other form controls
    });
   }

  getAllCourse(): void {
    this.ts.getAllCourse().subscribe((course) => {
      this.course = course;
  
    });

  }

  selectCourse(course: any): void {
    this.selectedCourse = course;
    this.courseId = course.id;

    console.log('Id Corsa: ' + this.courseId);

    // Populate the update form with course details
    this.populateUpdateForm(course);
  }

  initUpdateForm(): void {
    this.updateForm = this.formBuilder.group({
      tratta: ['', Validators.required],
      km: ['', Validators.required],
      tariffa: ['', Validators.required],
      // ... other form controls
    });
  }

  // Populate the update form with course details
  populateUpdateForm(course: any): void {

    this.updateForm.patchValue({
      

      tratta: course.startLocation.name + '-' + course.endLocation.name,
      km: course.km,
      tariffa: course.ratesType.amount + '€',
      // ... other form controls
    });
  }

  // Update the course when the "Aggiorna" button is clicked
  updateCourse(courseId: number): void {
    const formData = this.updateForm.value;

    if (this.updateForm.valid) {
      const tariffaWithoutEuro = formData.tariffa.replace('€', '');
      const updatePayload = {
        id: this.courseId,
        startLocation: {
          id: this.selectedCourse.startLocation.id,
          name: this.selectedCourse.startLocation.name,
          gps: this.selectedCourse.startLocation.gps
        },
        endLocation: {
          id: this.selectedCourse.endLocation.id,
          name: this.selectedCourse.endLocation.name,
          gps: this.selectedCourse.endLocation.gps
        },
        km: formData.km, // Use formData.km directly
        ratesType: {
          id: this.selectedCourse.ratesType.id,
          ratesType: this.selectedCourse.ratesType.ratesType,
          amount: parseFloat(tariffaWithoutEuro) // Use formData.tariffa directly
        },
        active:1,

      };

      this.ts.updateCourse(courseId, updatePayload).subscribe(
        (response) => {
          // Handle success, e.g., show a success message

          this.confirmationMessage = 'Tariffa aggiornata Correttamente!';
          
          setTimeout(function() {
            window.location.reload();
        }, 3000);
          this.getAllCourse();

        },
        (error) => {
          // Handle error, e.g., show an error message
          console.error('Error updating course:', error);
        }
      );
    }
  }


}
