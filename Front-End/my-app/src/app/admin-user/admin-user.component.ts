import { Component } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrl: './admin-user.component.css'
})
export class AdminUserComponent {

  showAllRequests: boolean = true;

  showTableUser: boolean = false;

  showTableCourse: boolean = false;

  createUserForm: FormGroup;

  UpdateUserForm: FormGroup;

  confirmationMessage: string | null = null;

  user: any[] = [];

  course: any[] = [];
  selectedUser: any;
  userId: any;

  

  constructor(private ts: TaxiServicesService, private formBuilder: FormBuilder) {
    this.createUserForm = this.formBuilder.group({
      nome: ['', Validators.required],
      cognome: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      telefono: ['', Validators.required],
      tipo: ['', Validators.required],
  });

  this.UpdateUserForm = this.formBuilder.group({
    nome: ['', Validators.required],
    cognome: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', Validators.required],
    telefono: ['', Validators.required],
    tipo: ['', Validators.required],
});
   }

  ngOnInit(): void {

    this.getAllUser();
  }

  initCreateUserForm(): void {
    this.createUserForm = this.formBuilder.group({
      nome: ['', Validators.required],
      cognome: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      telefono: ['', Validators.required],
      tipo: ['', Validators.required],
    });
  }

  selectCourse(user: any): void {
    this.selectedUser = user;
    this.userId = user.id;

    console.log('Id Corsa: ' + this.userId);

    // Populate the update form with course details
    this.populateUpdateForm(user);
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

  createUser(): void {
    // Verifica se il form è valido prima di procedere
    if (this.createUserForm.valid) {
      const formData = this.createUserForm.value;
      // Costruisci il corpo della richiesta utilizzando i valori del form
      const body = {
        name: formData.nome,
        lastName: formData.cognome,
        email: formData.email,
        mobilePhone: formData.telefono,
        password: formData.password,
        userType: formData.tipo,
        active: 1,
        // Altri campi se necessario
      };

      // Chiamata al servizio createuser con il corpo della richiesta
      this.ts.createuser(body).subscribe(
        response => {
          setTimeout(function() {
            window.location.reload();
        }, 3000);
          this.confirmationMessage = 'Utente creato con successo!';
        },
        error => {
          // Gestisci gli errori
          console.error('Errore durante la creazione dell\'utente', error);
        }
      );
    }
  }

  populateUpdateForm(user: any): void {

    this.UpdateUserForm.patchValue({
      nome: user.name,
      cognome: user.lastName,
      email: user.email,
      telefono: user.mobilePhone,
      password: user.password,
      tipo: user.userType,
    });
  }

  // Update the course when the "Aggiorna" button is clicked
  updateUser(userId: number): void {
    const formData = this.UpdateUserForm.value;

    if (this.UpdateUserForm.valid) {
      const updatePayload = {
        id: userId,
        name: formData.nome,
        lastName: formData.cognome,
        email: formData.email,
        mobilePhone: formData.telefono,
        password: formData.password,
        userType: formData.tipo,
        active: 1,
      };
    

      this.ts.updateUser(userId, updatePayload).subscribe(
        (response) => {
          // Handle success, e.g., show a success message

          console.log('User updated successfully:', response);

          this.confirmationMessage = 'Utente aggiornato Correttamente!';
          
          setTimeout(function() {
            window.location.reload();
        }, 3000);
          this.getAllUser();

        },
        (error) => {
          // Handle error, e.g., show an error message
          console.error('Error updating course:', error);
        }
      );
    }
  }

  


  deactivateUser(User: any): void {
  
    const userId = User.id;

  this.ts.deactivateUser(userId).subscribe(
    (response) => {

      setTimeout(function() {
        window.location.reload();
    }, 2000);
      
    },
    (error) => {
      console.error('Errore durante la disattivazione del taxi:', error);
      // Gestisci eventuali errori o aggiungi ulteriori azioni di gestione degli errori
    }
  );

  }
  
  
  
  }
  


