package it.parthenope.taxi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.services.EmailService;

/**
 * Controller che gestisce le operazioni relative alle email.
 */


@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController
public class EmailController {
	
	/**
     * Servizio per la gestione delle email.
     */
	
	@Autowired
	EmailService emailService;
	
	/**
     * Endpoint per ottenere la lista di tutte le email relative alle richieste.
     *
     * @return Lista di oggetti EmailDto relative alle richieste.
     */
	
	@GetMapping("/api/email")
	public List<EmailDto> getAllEmail(){
		
		return emailService.getAllEmail("Richiesta");
	}
	
	/**
     * Endpoint per ottenere la lista delle email accettate associate a un tassista specifico.
     *
     * @param taxiId L'ID del tassista per il quale si vogliono ottenere le email accettate.
     * @return ResponseEntity contenente la lista di oggetti EmailDto e lo stato di risposta OK.
     */
	
	 @GetMapping("/api/email/accepted/{taxiId}")
	    public ResponseEntity<List<EmailDto>> getMyRequests(@PathVariable Long taxiId) {
	        List<EmailDto> myRequests = emailService.getMyRequests(taxiId);
	        return new ResponseEntity<>(myRequests, HttpStatus.OK);
	    }
	 
	 /**
	     * Endpoint per l'aggiornamento di una email esistente.
	     *
	     * @param id       L'ID della email da aggiornare.
	     * @param emailDto Oggetto EmailDto contenente le nuove informazioni della email.
	     * @return ResponseEntity contenente l'oggetto EmailDto aggiornato e lo stato di risposta OK.
	     */
	
	@PutMapping("/api/email/{id}")
    public ResponseEntity<EmailDto> updateRequest(@PathVariable Integer id, @RequestBody EmailDto emailDto) {


        emailDto.setId(id);
        emailService.updateEmail(emailDto);

        return new ResponseEntity<>(emailDto, HttpStatus.OK);
    }

}
