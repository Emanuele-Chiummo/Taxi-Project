package it.parthenope.taxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.RequestMapper;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.repository.RequestRepository;
import it.parthenope.taxi.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	RequestMapper requestMapper;

	@Autowired
	RequestRepository requestRepository;

	@Override
	public RequestDto createRequest(RequestDto requestDto) {
		
		Request request = requestMapper.dtoToModel(requestDto);
		requestRepository.save(request);

		return requestMapper.modelToDto(request);
		
		
	}

}
