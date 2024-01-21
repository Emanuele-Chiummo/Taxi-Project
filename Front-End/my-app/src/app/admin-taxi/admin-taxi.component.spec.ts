import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTaxiComponent } from './admin-taxi.component';

describe('AdminTaxiComponent', () => {
  let component: AdminTaxiComponent;
  let fixture: ComponentFixture<AdminTaxiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminTaxiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminTaxiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
