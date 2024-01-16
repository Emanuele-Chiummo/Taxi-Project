package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.RequestMapper;
import it.parthenope.taxi.model.Request;

@Component
public class RequestMapperImpl implements RequestMapper {
	
	@Override
	public Request dtoToModel(RequestDto requestDto) {

		Request request = new Request();
		request.setId(requestDto.getId());
		request.setCourse(requestDto.getCourse());
		request.setDate(requestDto.getDate());
		request.setState(requestDto.getState());
		request.setTaxi(requestDto.getTaxi());


		return request;
	}

	@Override
	public RequestDto modelToDto(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
