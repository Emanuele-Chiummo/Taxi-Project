package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.TaxiMapper;
import it.parthenope.taxi.model.Taxi;

@Component
public class TaxiMapperImpl implements TaxiMapper {

	@Override
	public Taxi dtoToModel(TaxiDto taxiDto) {

		Taxi taxi = new Taxi();
		taxi.setId(taxiDto.getId());
		taxi.setIdentifier(taxiDto.getIdentifier());
		taxi.setDriver(taxiDto.getDriver());

		return taxi;
	}

	@Override
	public TaxiDto modelToDto(Taxi taxi) {

		TaxiDto taxiDto = new TaxiDto();
		taxiDto.setId(taxi.getId());
		taxiDto.setIdentifier(taxi.getIdentifier());
		taxiDto.setDriver(taxi.getDriver());
		return taxiDto;
	}

}
