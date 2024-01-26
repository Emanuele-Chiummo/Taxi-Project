package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;

@Service
public interface RequestService {

    RequestDto createRequest(RequestDto requestDto);

	List<RequestDto> getAllRequest();

	boolean requestExists(Integer id);

	void updateRequest(RequestDto requestDto);

	List<RequestDto> getAllRequestByState(String string);


	List<RequestDto> getMyRequests(Long taxiId);

	List<Object[]> findMostPopularRoutes();

	List<Object[]> findMostTaxiCourse();

	List<Object[]> findMostTaxiAmount();



    
    
}