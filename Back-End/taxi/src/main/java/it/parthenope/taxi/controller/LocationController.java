package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.services.LocationService;

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
@RestController
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/api/location/{locationName}")
    public ResponseEntity<Integer> getLocationIdByName(@PathVariable String locationName) {
        Integer locationId = locationService.getLocationIdByName(locationName);
        return ResponseEntity.ok(locationId);
    }
	
	@GetMapping("/api/location")
	public List<LocationDto> getAllLocation(){
		
		return locationService.getAllLocation();
	}
	
	@PostMapping("/api/location")
	public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {

		locationService.createLocation(locationDto);
		return new ResponseEntity<LocationDto>(locationDto, HttpStatus.CREATED);
		
	}
	


}
