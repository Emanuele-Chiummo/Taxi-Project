package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.mappers.RateMapper;
import it.parthenope.taxi.model.Rates;

@Component
public class RateMapperImpl implements RateMapper{
	
	@Override
	public Rates dtoToModel(RateDto rateDto) {

		Rates rates = new Rates();
		rates.setId(rateDto.getId());
		rates.setRatesType(rateDto.getRatesType());
		rates.setAmount(rateDto.getAmount());

		return rates;
	}

	@Override
	public RateDto modelToDto(Rates rates) {

		RateDto rateDto = new RateDto();
		
		rateDto.setId(rates.getId());
		rateDto.setAmount(rates.getAmount());
		rateDto.setRatesType(rates.getRatesType());
		return rateDto;
	}

}
