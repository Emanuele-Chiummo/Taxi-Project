import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TassistaMyRequestComponent } from './tassista-my-request.component';

describe('TassistaMyRequestComponent', () => {
  let component: TassistaMyRequestComponent;
  let fixture: ComponentFixture<TassistaMyRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TassistaMyRequestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TassistaMyRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
