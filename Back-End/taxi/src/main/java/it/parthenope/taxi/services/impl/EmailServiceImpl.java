package it.parthenope.taxi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.EmailMapper;
import it.parthenope.taxi.model.Email;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.repository.EmailRepository;
import it.parthenope.taxi.services.EmailService;

@Service
@Order(0)
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	EmailMapper emailMapper;
	
	
	@Autowired
    EmailRepository emailRepository; 

	@Override
	public void saveEmail(EmailDto emailDto) {
	    Email email = new Email();
	    email.setSender(emailDto.getSender());
	    email.setSubject(emailDto.getSubject());
	    email.setBody(emailDto.getBody());
	    email.setState(emailDto.getState());
        // Set other properties as needed

        // Save the email to the database
        emailRepository.save(email); 
        
        System.out.println("Email saved in EmailService: " + emailDto);
    }
	
	@Override
    public List<EmailDto> getAllEmail(String state) {
        List<Email> allEmails = emailRepository.findByState(state);
        return allEmails.stream()
                .map(emailMapper::modelToDto)
                .collect(Collectors.toList());
    }
	
	 @Override
	    public List<EmailDto> getMyRequests(Long taxiId) {
	        List<Email> acceptedRequestsForTaxi = emailRepository.findByStateAndTaxiId("Accettata", taxiId);
	        return acceptedRequestsForTaxi.stream()
	                .map(emailMapper::modelToDto)
	                .collect(Collectors.toList());
	    }
	
	 @Override
	    public void updateEmail(EmailDto emailDto) {
	        Email email = emailMapper.dtoToModel(emailDto);
	        emailRepository.save(email);
	    }
}