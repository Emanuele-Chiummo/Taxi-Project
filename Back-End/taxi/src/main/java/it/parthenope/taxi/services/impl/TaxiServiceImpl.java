package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.TaxiMapper;
import it.parthenope.taxi.model.Taxi;
import it.parthenope.taxi.repository.TaxiRepository;
import it.parthenope.taxi.services.TaxiService;

@Service
public class TaxiServiceImpl implements TaxiService {

	@Autowired
	TaxiMapper taxiMapper;

	@Autowired
	TaxiRepository taxiRepository;

	@Override
	public TaxiDto createTaxi(TaxiDto taxiDto) {
		// TODO Auto-generated method stub

		Taxi taxi = taxiMapper.dtoToModel(taxiDto);
		taxiRepository.save(taxi);

		return taxiMapper.modelToDto(taxi);
	}

	@Override
	public List<TaxiDto> getAllTaxi() {
		// TODO Auto-generated method stub
		
		List<Taxi> allTaxi = taxiRepository.findAll();
		List<TaxiDto> allTaxiDto = new ArrayList<TaxiDto>();
		for(Taxi myTaxy : allTaxi) {
			allTaxiDto.add(taxiMapper.modelToDto(myTaxy));
		}
		
		return allTaxiDto;
	}
	
	@Override
    public Integer getTaxiIdByDriverId(Integer driverId) {
        Optional<Taxi> taxiOptional = taxiRepository.findByDriverId(driverId);

        if (taxiOptional.isPresent()) {
            return taxiOptional.get().getId();
        } else {
           
            return null;
        }
    }
	
    @Override
    public TaxiDto getTaxiById(Integer taxiId) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
        return taxiOptional.map(taxiMapper::modelToDto).orElse(null);
    }

}
