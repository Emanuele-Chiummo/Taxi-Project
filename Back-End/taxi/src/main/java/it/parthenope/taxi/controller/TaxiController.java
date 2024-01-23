package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.services.TaxiService;

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
@RestController
public class TaxiController {
	@Autowired
	TaxiService taxiService;

	@PostMapping("/api/taxi")
	public ResponseEntity<TaxiDto> createTaxi(@RequestBody TaxiDto taxiDto) {

		taxiService.createTaxi(taxiDto);
		return new ResponseEntity<TaxiDto>(taxiDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/taxi")
	public List<TaxiDto> getAllTaxi(){
		
		return taxiService.getAllTaxi();
	}
	
	
	@GetMapping("/api/taxi/{driverId}")
    public ResponseEntity<Integer> getTaxiIdByDriverId(@PathVariable Integer driverId) {

		Integer taxiId = taxiService.getTaxiIdByDriverId(driverId);

        if (taxiId != null) {
            return new ResponseEntity<>(taxiId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/api/taxi/id/{taxiId}")
	public ResponseEntity<TaxiDto> getTaxiById(@PathVariable Integer taxiId) {
	    TaxiDto taxiDto = taxiService.getTaxiById(taxiId);

	    if (taxiDto != null) {
	        return new ResponseEntity<>(taxiDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/api/taxi/{id}")
    public ResponseEntity<TaxiDto> updateTaxi(@PathVariable Integer id, @RequestBody TaxiDto taxiDto) {

        if (!taxiService.taxiExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taxiDto.setId(id);
        taxiService.updateTaxi(taxiDto);

        return new ResponseEntity<>(taxiDto, HttpStatus.OK);
    }
	
	


}
