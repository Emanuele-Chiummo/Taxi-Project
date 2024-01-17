package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.dto.TaxiDto;

@Service
public interface RateService {
    
    List<RateDto> getAllRates();

	//RateDto putRates(RateDto rateDto);


   
}
