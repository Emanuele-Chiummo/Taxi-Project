package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.services.RateService;
import it.parthenope.taxi.services.TaxiService;

@RestController

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
public class RatesController {
	
	@Autowired
	RateService ratesService;
	
	@GetMapping("/api/rate")
	public List<RateDto> getAllRates(){
		
		return ratesService.getAllRates();
	}
	
	

}
