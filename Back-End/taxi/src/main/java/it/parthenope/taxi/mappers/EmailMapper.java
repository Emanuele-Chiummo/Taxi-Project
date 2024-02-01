package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.model.Email;

public interface EmailMapper {
	
	Email dtoToModel(EmailDto emailDto);

	EmailDto modelToDto(Email email);

}
