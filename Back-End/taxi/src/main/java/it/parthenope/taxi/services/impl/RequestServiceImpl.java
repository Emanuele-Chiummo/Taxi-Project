package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.RequestMapper;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;
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
	
	@Override
	public List<RequestDto> getAllRequest() {
		// TODO Auto-generated method stub
		
		List<Request> allRequest = requestRepository.findAll();
		List<RequestDto> allRequestDto = new ArrayList<RequestDto>();
		for(Request myRequest : allRequest) {
			allRequestDto.add(requestMapper.modelToDto(myRequest));
		}
		
		return allRequestDto;
	}
	
	@Override
    public boolean requestExists(Integer id) {
        return requestRepository.existsById(id);
    }

    @Override
    public void updateRequest(RequestDto requestDto) {
        Request request = requestMapper.dtoToModel(requestDto);
        requestRepository.save(request);
    }
    

}
