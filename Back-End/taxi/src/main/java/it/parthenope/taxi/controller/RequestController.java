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

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.services.RequestService;

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	
	
	@PostMapping("/api/request")
	public ResponseEntity<RequestDto> createRequest(@RequestBody RequestDto requestDto) {

		requestService.createRequest(requestDto);
		return new ResponseEntity<RequestDto>(requestDto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/request")
	public List<RequestDto> getAllRequest(){
		
		return requestService.getAllRequest();
	}
	
	@PutMapping("/api/request/{id}")
    public ResponseEntity<RequestDto> updateRequest(@PathVariable Integer id, @RequestBody RequestDto requestDto) {

        if (!requestService.requestExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        requestDto.setId(id);
        requestService.updateRequest(requestDto);

        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

}
