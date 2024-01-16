package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.model.Taxi;

public interface TaxiMapper {
	
	Taxi dtoToModel(TaxiDto taxiDto);

	TaxiDto modelToDto(Taxi taxi);
	
}
