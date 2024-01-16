package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.TaxiDto;

@Service
public interface TaxiService {

	TaxiDto createTaxi(TaxiDto taxiDto);

	List<TaxiDto> getAllTaxi();

}
