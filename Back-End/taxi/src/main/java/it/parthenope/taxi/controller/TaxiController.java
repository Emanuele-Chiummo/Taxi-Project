package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
