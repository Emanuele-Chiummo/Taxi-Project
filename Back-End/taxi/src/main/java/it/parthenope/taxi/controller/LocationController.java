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

/**
 * Controller che gestisce le operazioni relative alle posizioni (locations).
 */

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
@RestController
public class LocationController {
	
	/**
     * Servizio per la gestione delle posizioni.
     */

	
	@Autowired
	LocationService locationService;
	
	/**
     * Endpoint per ottenere l'ID di una posizione dato il suo nome.
     *
     * @param locationName Il nome della posizione di cui si vuole ottenere l'ID.
     * @return ResponseEntity contenente l'ID della posizione e lo stato di risposta OK.
     */
	
	@GetMapping("/api/location/{locationName}")
    public ResponseEntity<Integer> getLocationIdByName(@PathVariable String locationName) {
        Integer locationId = locationService.getLocationIdByName(locationName);
        return ResponseEntity.ok(locationId);
    }
	
	/**
     * Endpoint per ottenere la lista di tutte le posizioni.
     *
     * @return Lista di oggetti LocationDto rappresentanti le posizioni.
     */
	
	@GetMapping("/api/location")
	public List<LocationDto> getAllLocation(){
		
		return locationService.getAllLocation();
	}
	
	/**
     * Endpoint per la creazione di una nuova posizione.
     *
     * @param locationDto Oggetto LocationDto contenente le informazioni della nuova posizione.
     * @return ResponseEntity contenente l'oggetto LocationDto creato e lo stato di risposta CREATED.
     */
	
	@PostMapping("/api/location")
	public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {

		locationService.createLocation(locationDto);
		return new ResponseEntity<LocationDto>(locationDto, HttpStatus.CREATED);
		
	}
	


}
