package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.services.RateService;
import it.parthenope.taxi.services.TaxiService;

/**
 * Controller che gestisce le operazioni relative alle tariffe.
 */

@RestController

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
public class RatesController {
	
	/**
     * Servizio per la gestione delle tariffe.
     */
	
	@Autowired
	RateService ratesService;
	
	/**
     * Endpoint per ottenere la lista di tutte le tariffe disponibili.
     *
     * @return Lista di oggetti RateDto rappresentanti le tariffe.
     */
	
	@GetMapping("/api/rate")
	public List<RateDto> getAllRates(){
		
		return ratesService.getAllRates();
	}
	
	

}
