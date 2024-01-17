package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.model.Rates;

public interface RateMapper {
	
	Rates dtoToModel(RateDto rateDto);

	RateDto modelToDto(Rates rate);

}
