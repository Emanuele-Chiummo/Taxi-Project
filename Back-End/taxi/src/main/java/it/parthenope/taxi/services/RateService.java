package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RateDto;

@Service
public interface RateService {

    RateDto createRates(RateDto rateDto);

   
}
