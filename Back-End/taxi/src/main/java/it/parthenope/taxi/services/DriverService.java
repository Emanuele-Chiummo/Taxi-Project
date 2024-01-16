package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;
import it.parthenope.taxi.dto.DriverDto;

@Service
public interface DriverService {

    DriverDto createDriver(DriverDto driverDto);

}
