package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.EmailDto;


public interface EmailService {

	void saveEmail(EmailDto emailDto);


	List<EmailDto> getAllEmail(String state);


	void updateEmail(EmailDto emailDto);


	List<EmailDto> getMyRequests(Long taxiId);
	
	
}
