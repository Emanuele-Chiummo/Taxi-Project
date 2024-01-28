import { Component, OnInit } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { forkJoin } from 'rxjs';
import { end } from '@popperjs/core';

@Component({
  selector: 'app-admin-course',
  templateUrl: './admin-course.component.html',
  styleUrl: './admin-course.component.css'
})
export class AdminCourseComponent implements OnInit{

  updateForm: FormGroup; 

  createForm: FormGroup;

  createLocationForm: FormGroup;

  courseId: number = 0;

  confirmationMessage: string | null = null;

  errorMessage: string | null = null;


  course: any[] = [];
  route: any;
  selectedCourse: any; 
  location: any;

  ngOnInit(): void {
    this.getAllCourse();
    this.initUpdateForm();
    this.getAllLocation();
  }

  constructor(private ts: TaxiServicesService, private formBuilder: FormBuilder) {
    this.updateForm = this.formBuilder.group({
      tratta: ['', Validators.required],
      km: ['', Validators.required],
      tariffa: ['', Validators.required],
      // ... other form controls
    });

    this.createForm = this.formBuilder.group({
      partenza: ['', Validators.required],
      destinazione: ['', Validators.required],
      km: ['', Validators.required],
      tipo_corsa: ['', Validators.required],
      tariffa: ['', Validators.required],
  });

  this.createLocationForm = this.formBuilder.group({
    name: ['', Validators.required],
    gps: ['', Validators.required],
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

  initCreateForm(): void {
    this.createForm = this.formBuilder.group({
      partenza: ['', Validators.required],
      destinazione: ['', Validators.required],
      km: ['', Validators.required],
      tipo_corsa: ['', Validators.required],
      tariffa: ['', Validators.required],
    });
  }

  initCreateLocationForm(): void {
    this.createLocationForm = this.formBuilder.group({
      name: ['', Validators.required],
      gps: ['', Validators.required],
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

          console.log('Course updated successfully:', response);

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

  showErrorMessage(message: string, timeout: number): void {
    this.errorMessage = message;
  
    setTimeout(() => {
      this.errorMessage = null;
    }, timeout);
  }

  getAllLocation(): void {

    this.ts.getAllLocation().subscribe(
      (data) => {
        this.location = data;
        console.log('Location:', this.location);
      },
      (error) => {
        console.error('Error fetching locations:', error);
      }
  
    );
  }

  calculatePrice(): void {
    const formData = this.createForm.value;
    const km = parseFloat(formData.km); // Converte la stringa in un numero
  
    // Imposta il prezzo in base al tipo di corsa
    const pricePerKm = formData.tipo_corsa === 'urbana' ? 0.70 : 0.90;
  
    // Calcola il prezzo totale
    const totalPrice = km * pricePerKm;
  
    // Aggiorna il valore del campo tariffa nel form
    const tariffaControl = this.createForm.get('tariffa');
    if (tariffaControl) {
      tariffaControl.patchValue(totalPrice.toFixed(2)); // Arrotonda a due decimali
    }
  }
  

  createCourse(): void {
    if (this.createForm.valid) {
      const formData = this.createForm.value;
      const startLocation = formData.partenza;
      const endLocation = formData.destinazione;

      console.log('Start location:', startLocation);
      console.log('End location:', endLocation);

      
  
      const createBody = {
        startLocation: {
          id: startLocation.id,
          name: startLocation.name,
          gps: endLocation.gps
        },
        endLocation: {
          id: endLocation.id,
          name: endLocation.name,
          gps: endLocation.gps
        },
        km: formData.km,
        ratesType: {
          ratesType: formData.tipo_corsa,
          amount: formData.tariffa
        },
        active: 1
      };
  
      this.ts.checkcourseExistsWithLocations(startLocation, endLocation).subscribe(
        (courseExists) => {
          console.log('Course exists:', courseExists);
  
          if (courseExists) {
            //console.log('Course with the same locations already exists.');
            this.showErrorMessage('La tratta esiste già', 3000);
          } else {
            this.ts.createCourse(createBody).subscribe(
              (response) => {
                this.confirmationMessage = 'Corsa creata correttamente!';
                //console.log('Course created successfully:', response);
                setTimeout(function() {
                  window.location.reload();
              }, 3000);
              },
              (error) => {
                console.error('Error creating course:', error);
                // Gestisci l'errore durante la creazione della corsa
              }
            );
          }
        },
        (error) => {
          console.error('Error checking course existence:', error);
          // Handle the error durante il controllo dell'esistenza della corsa
        }
      );
    } else {
      console.log('Form is invalid. Please check your inputs.');
    }
  }
  
  
  deactivateCourse(course: any): void {
  
    const courseId = course.id;

  this.ts.deactivateCourse(courseId).subscribe(
    (response) => {

      setTimeout(function() {
        window.location.reload();
    }, 2000);
      
    },
    (error) => {
      console.error('Errore durante la disattivazione del course:', error);
      // Gestisci eventuali errori o aggiungi ulteriori azioni di gestione degli errori
    }
  );

  }

  createLocation(): void {

    const formData = this.createLocationForm.value;
    const createBody = {
      name: formData.name,
      gps: formData.gps
    };

    this.ts.createLocation(createBody).subscribe(
      (response) => {
        this.confirmationMessage = 'Location creata correttamente!';
        console.log('Location created successfully:', response);
        setTimeout(function() {
          window.location.reload();
      }, 3000);
        this.createLocationForm.reset();
      },
      (error) => {
        console.error('Error creating location:', error);
        // Gestisci l'errore durante la creazione della corsa
      }
    );
  }

  
  


}
