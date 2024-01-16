package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.LocationDto;

@Service
public interface LocationService {

    LocationDto createLocation(LocationDto locationDto);

    
}
