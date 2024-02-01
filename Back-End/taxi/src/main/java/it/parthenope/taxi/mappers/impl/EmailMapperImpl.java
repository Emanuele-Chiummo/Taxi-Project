package it.parthenope.taxi.mappers.impl;



import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.mappers.EmailMapper;
import it.parthenope.taxi.model.Email;

@Component
public class EmailMapperImpl implements EmailMapper{

	@Override
	public Email dtoToModel(EmailDto emailDto) {
		// TODO Auto-generated method stub
		
		Email email = new Email();
		
		email.setId(emailDto.getId());
		email.setSender(emailDto.getSender());
		email.setSubject(emailDto.getSubject());
		email.setBody(emailDto.getBody());
		email.setState(emailDto.getState());
		email.setTaxi(emailDto.getTaxi());

		
		return email;
	}

	@Override
	public EmailDto modelToDto(Email email) {
		
		// TODO Auto-generated method stub
		
		EmailDto emailDto = new EmailDto();
		
		emailDto.setId(email.getId());
		emailDto.setSender(email.getSender());
		emailDto.setSubject(email.getSubject());
		emailDto.setBody(email.getBody());
		emailDto.setState(email.getState());
		emailDto.setTaxi(email.getTaxi());
		

		
		return emailDto;
	}
	
	

}
