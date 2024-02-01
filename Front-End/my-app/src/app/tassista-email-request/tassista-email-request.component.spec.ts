import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TassistaEmailRequestComponent } from './tassista-email-request.component';

describe('TassistaEmailRequestComponent', () => {
  let component: TassistaEmailRequestComponent;
  let fixture: ComponentFixture<TassistaEmailRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TassistaEmailRequestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TassistaEmailRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
