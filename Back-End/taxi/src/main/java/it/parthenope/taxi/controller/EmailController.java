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

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/api/email")
	public List<EmailDto> getAllEmail(){
		
		return emailService.getAllEmail("Richiesta");
	}
	
	 @GetMapping("/api/email/accepted/{taxiId}")
	    public ResponseEntity<List<EmailDto>> getMyRequests(@PathVariable Long taxiId) {
	        List<EmailDto> myRequests = emailService.getMyRequests(taxiId);
	        return new ResponseEntity<>(myRequests, HttpStatus.OK);
	    }
	
	@PutMapping("/api/email/{id}")
    public ResponseEntity<EmailDto> updateRequest(@PathVariable Integer id, @RequestBody EmailDto emailDto) {


        emailDto.setId(id);
        emailService.updateEmail(emailDto);

        return new ResponseEntity<>(emailDto, HttpStatus.OK);
    }

}
