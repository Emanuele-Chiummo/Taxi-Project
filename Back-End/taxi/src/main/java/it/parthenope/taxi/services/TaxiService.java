package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.TaxiDto;

@Service
public interface TaxiService {

	TaxiDto createTaxi(TaxiDto taxiDto);

	List<TaxiDto> getAllTaxi();
	
	 Integer getTaxiIdByDriverId(Integer driverId);
	 
	 TaxiDto getTaxiById(Integer taxiId);

	boolean taxiExists(Integer id);

	void updateTaxi(TaxiDto taxiDto);


	boolean checkIfUserHasTaxi(Integer driverId);

	void deactivateTaxi(Integer id);
	 

}
