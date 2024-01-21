import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TassistaPendingRequestComponent } from './tassista-pending-request.component';

describe('TassistaPendingRequestComponent', () => {
  let component: TassistaPendingRequestComponent;
  let fixture: ComponentFixture<TassistaPendingRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TassistaPendingRequestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TassistaPendingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
