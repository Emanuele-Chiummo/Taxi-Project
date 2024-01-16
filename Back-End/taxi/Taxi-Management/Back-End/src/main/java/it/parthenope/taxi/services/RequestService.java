package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;

@Service
public interface RequestService {

    RequestDto createRequest(RequestDto requestDto);

    
    
}