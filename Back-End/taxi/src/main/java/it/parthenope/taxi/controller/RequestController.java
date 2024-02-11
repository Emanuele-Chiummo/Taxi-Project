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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.services.RequestService;

/**
 * Controller che gestisce le operazioni relative alle richieste di taxi.
 */

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
@RestController
public class RequestController {
	
	/**
     * Servizio per la gestione delle richieste di taxi.
     */
	
	@Autowired
	RequestService requestService;
	
	/**
     * Endpoint per la creazione di una nuova richiesta di taxi.
     *
     * @param requestDto Oggetto RequestDto contenente le informazioni della nuova richiesta.
     * @return ResponseEntity contenente l'oggetto RequestDto creato e lo stato di risposta CREATED.
     */
	
	
	@PostMapping("/api/request")
	public ResponseEntity<RequestDto> createRequest(@RequestBody RequestDto requestDto) {

		requestService.createRequest(requestDto);
		return new ResponseEntity<RequestDto>(requestDto, HttpStatus.CREATED);
		
	}
	
	/**
     * Endpoint per ottenere la lista di tutte le richieste di taxi.
     *
     * @return Lista di oggetti RequestDto rappresentanti le richieste di taxi.
     */

	
	@GetMapping("/api/request")
	public List<RequestDto> getAllRequest(){
		
		return requestService.getAllRequest();
	}
	
	/**
     * Endpoint per l'aggiornamento di una richiesta di taxi esistente.
     *
     * @param id         L'ID della richiesta di taxi da aggiornare.
     * @param requestDto Oggetto RequestDto contenente le nuove informazioni della richiesta.
     * @return ResponseEntity contenente l'oggetto RequestDto aggiornato e lo stato di risposta OK, oppure NOT_FOUND se la richiesta non esiste.
     */
	
	@PutMapping("/api/request/{id}")
    public ResponseEntity<RequestDto> updateRequest(@PathVariable Integer id, @RequestBody RequestDto requestDto) {

        if (!requestService.requestExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        requestDto.setId(id);
        requestService.updateRequest(requestDto);

        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }
	
	/**
     * Endpoint per ottenere la lista di tutte le richieste di taxi in stato "Richiesta" (pending).
     *
     * @return Lista di oggetti RequestDto in stato "Richiesta".
     */
	
	 @GetMapping("/api/request/pending")
	    public List<RequestDto> getAllRequestByState() {
	        return requestService.getAllRequestByState("Richiesta");
	    }
	 
	 /**
	     * Endpoint per ottenere la lista delle richieste di taxi accettate associate a un tassista specifico.
	     *
	     * @param taxiId L'ID del tassista per il quale si vogliono ottenere le richieste accettate.
	     * @return ResponseEntity contenente la lista di oggetti RequestDto e lo stato di risposta OK.
	     */
	 
	  @GetMapping("/api/request/accepted/{taxiId}")
	    public ResponseEntity<List<RequestDto>> getMyRequests(@PathVariable Long taxiId) {
	        List<RequestDto> myRequests = requestService.getMyRequests(taxiId);
	        return new ResponseEntity<>(myRequests, HttpStatus.OK);
	    }
	  
	  /**
	     * Endpoint per ottenere la lista delle rotte più popolari basate sul numero di richieste.
	     *
	     * @return ResponseEntity contenente la lista di oggetti Object[] rappresentanti le rotte più popolari e lo stato di risposta OK.
	     */
	  
	  @GetMapping("/api/request/most-popular")
	    public ResponseEntity<List<Object[]>> getMostPopularRoutes() {
	        List<Object[]> popularRoutes = requestService.findMostPopularRoutes();
	        return new ResponseEntity<>(popularRoutes, HttpStatus.OK);
	    } 
	  
	  /**
	     * Endpoint per ottenere la lista delle prestazioni migliori dei taxi basate sul numero di corse completate.
	     *
	     * @return ResponseEntity contenente la lista di oggetti Object[] rappresentanti le prestazioni migliori dei taxi e lo stato di risposta OK.
	     */
	  
	  @GetMapping("/api/request/taxi-performance")
	    public ResponseEntity<List<Object[]>> findMostTaxiCourse() {
	        List<Object[]> popularRoutes = requestService.findMostTaxiCourse();
	        return new ResponseEntity<>(popularRoutes, HttpStatus.OK);
	    }
	  
	  /**
	     * Endpoint per ottenere la lista delle prestazioni migliori dei taxi basate sulle entrate generate.
	     *
	     * @return ResponseEntity contenente la lista di oggetti Object[] rappresentanti le prestazioni migliori dei taxi e lo stato di risposta OK.
	     */
	  
	  @GetMapping("/api/request/entry-performance")
	    public ResponseEntity<List<Object[]>> findMostTaxiAmount() {
	        List<Object[]> popularRoutes = requestService.findMostTaxiAmount();
	        return new ResponseEntity<>(popularRoutes, HttpStatus.OK);
	    } 
	




}
