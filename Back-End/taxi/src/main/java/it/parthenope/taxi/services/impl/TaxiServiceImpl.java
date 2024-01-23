package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.TaxiMapper;
import it.parthenope.taxi.model.Driver;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;
import it.parthenope.taxi.repository.DriverRepository;
import it.parthenope.taxi.repository.TaxiRepository;
import it.parthenope.taxi.services.TaxiService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TaxiServiceImpl implements TaxiService {

	@Autowired
	TaxiMapper taxiMapper;

	@Autowired
	TaxiRepository taxiRepository;
	
	@Autowired
	DriverRepository driverRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public TaxiDto createTaxi(TaxiDto taxiDto) {
	    Taxi taxi = taxiMapper.dtoToModel(taxiDto);

	    
	    if (entityManager.contains(taxi.getDriver())) {
	        taxi.setDriver(taxi.getDriver());
	    } else {
	        
	        Driver existingDriver = driverRepository.findById(taxi.getDriver().getId()).orElse(null);
	        taxi.setDriver(existingDriver);
	    }

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
    
    @Override
    public boolean taxiExists(Integer id) {
        return taxiRepository.existsById(id);
    }

    @Override
    public void updateTaxi(TaxiDto taxiDto) {
        Taxi taxi = taxiMapper.dtoToModel(taxiDto);
        taxiRepository.save(taxi);
    }

}
