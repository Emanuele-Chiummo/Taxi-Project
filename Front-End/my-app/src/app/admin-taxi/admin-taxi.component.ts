import { Component } from '@angular/core';
import { TaxiServicesService } from '../services/taxi-services.service';

@Component({
  selector: 'app-admin-taxi',
  templateUrl: './admin-taxi.component.html',
  styleUrl: './admin-taxi.component.css'
})
export class AdminTaxiComponent {

  taxi: any[] = []

  ngOnInit(): void {

    this.getAlltaxi();  

  }

  constructor(private ts: TaxiServicesService) { }

  getAlltaxi() {
    this.ts.getAllTaxi().subscribe(x => {
      this.taxi = x
    })
  }

}
