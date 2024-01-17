package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RateDto;

import it.parthenope.taxi.mappers.RateMapper;

import it.parthenope.taxi.model.Rates;

import it.parthenope.taxi.repository.RateRepository;

import it.parthenope.taxi.services.RateService;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	RateMapper rateMapper;

	@Autowired
	RateRepository rateRepository;



	@Override
	public List<RateDto> getAllRates(){
		// TODO Auto-generated method stub
		
		List<Rates> allRate = rateRepository.findAll();
		List<RateDto> allRateDto = new ArrayList<RateDto>();
		for(Rates myRate : allRate) {
			allRateDto.add(rateMapper.modelToDto(myRate));
		}
		
		return allRateDto;
	}



	/* @Override
	public RateDto putRates(RateDto rateDto) {
		Rates rate = rateRepository.getId(rateDto.getId());
		if(rate.getId() != null) {
			return rateMapper.modelToDto(rateRepository.save(rateMapper.dtoToModel(rateDto)));
		}
		return null;
	} */
	
	
	

}
