package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.model.Request;

public interface RequestMapper {
	
	Request dtoToModel(RequestDto requestDto);

	RequestDto modelToDto(Request request);

}
