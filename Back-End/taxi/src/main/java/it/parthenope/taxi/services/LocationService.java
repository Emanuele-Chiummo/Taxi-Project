package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.model.Location;

@Service
public interface LocationService {

    LocationDto createLocation(LocationDto locationDto);

    Integer getLocationIdByName(String locationName);

	List<LocationDto> getAllLocation();
	
    


    
}
