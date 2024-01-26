package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    
    @Override
    public List<RequestDto> getAllRequestByState(String state) {
        List<Request> requestsByState = requestRepository.findByState(state);
        return requestsByState.stream()
            .map(requestMapper::modelToDto)
            .collect(Collectors.toList());
    }
    
    @Override
    public List<RequestDto> getMyRequests(Long taxiId) {
        List<Request> acceptedRequestsForTaxi = requestRepository.findByStateAndTaxiId("Accettata", taxiId);
        return acceptedRequestsForTaxi.stream()
                .map(requestMapper::modelToDto)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Object[]> findMostPopularRoutes() {
        return requestRepository.findMostPopularRoutes();
    }
    
    @Override
    public List<Object[]> findMostTaxiCourse() {
        return requestRepository.findMostTaxiCourse();
    }
    
    @Override
    public List<Object[]> findMostTaxiAmount() {
        return requestRepository.findMostTaxiAmount();
    }
    
    

    

}
