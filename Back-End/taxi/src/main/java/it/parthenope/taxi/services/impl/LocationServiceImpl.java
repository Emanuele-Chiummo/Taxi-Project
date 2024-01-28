package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.LocationMapper;
import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.repository.LocationRepository;
import it.parthenope.taxi.services.LocationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationMapper locationMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = locationMapper.dtoToModel(locationDto);
        Location savedLocation = locationRepository.save(location);
        return locationMapper.modelToDto(savedLocation);
    }

    @Override
    public Integer getLocationIdByName(String locationName) {
        Long locationId = locationRepository.findIdByName(locationName);

        if (locationId != null) {
            return locationId.intValue(); // Convert Long to Integer
        } else {
            // Return an appropriate value or handle the absence of the location as needed
            return null;
        }
    }
    
    @Override
	public List<LocationDto> getAllLocation() {
		// TODO Auto-generated method stub
		
		List<Location> allLocation = locationRepository.findAll();
		List<LocationDto> allLocationDto = new ArrayList<LocationDto>();
		for(Location myRequest : allLocation) {
			allLocationDto.add(locationMapper.modelToDto(myRequest));
		}
		
		return allLocationDto;
	}


	
	

}
