package it.parthenope.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.services.RequestService;
import it.parthenope.taxi.services.TaxiService;

@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	
	
	@PostMapping("/api/request")
	public ResponseEntity<RequestDto> createRequest(@RequestBody RequestDto requestDto) {

		requestService.createRequest(requestDto);
		return new ResponseEntity<RequestDto>(requestDto, HttpStatus.CREATED);
		
	}

}
