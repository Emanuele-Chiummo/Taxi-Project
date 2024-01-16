import { TestBed } from '@angular/core/testing';

import { TaxiServicesService } from './taxi-services.service';

describe('TaxiServicesService', () => {
  let service: TaxiServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TaxiServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
