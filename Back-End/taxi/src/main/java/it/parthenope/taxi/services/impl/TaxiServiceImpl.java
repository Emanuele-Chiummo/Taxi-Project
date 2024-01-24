package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.TaxiMapper;
import it.parthenope.taxi.model.Driver;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;
import it.parthenope.taxi.repository.DriverRepository;
import it.parthenope.taxi.repository.RequestRepository;
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
	
	@Autowired
	
	RequestRepository requestRepository;
	
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
	public List<TaxiDto> getAllTaxi() {
	    List<Taxi> activeTaxis = taxiRepository.findByActive(1); // Filtra solo i taxi attivi
	    return activeTaxis.stream()
	            .map(taxiMapper::modelToDto)
	            .collect(Collectors.toList());
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
    public boolean checkIfUserHasTaxi(Integer driverId) {
        Optional<Taxi> existingTaxi = taxiRepository.findByDriverId(driverId);
        return existingTaxi.isPresent();
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
    
    @Override
    
    public void deactivateTaxi(Integer id) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(id);
        if (taxiOptional.isPresent()) {
            Taxi taxi = taxiOptional.get();
            taxi.setActive(0);
            taxiRepository.save(taxi);
        } else {
            throw new RuntimeException("Taxi not found with id: " + id);
        }
    }
    
    @Override
    public void deleteTaxi(Integer id) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(id);

        if (taxiOptional.isPresent()) {
            Taxi taxi = taxiOptional.get();

           
            /*List<Request> requests = requestRepository.findByTaxi(taxi);
            for (Request request : requests) {
              request.setTaxi(null);
              requestRepository.save(request);
            }*/
            
            List<Request> requests = requestRepository.findByTaxi(taxi);

            if (!requests.isEmpty()) {
                // Se ci sono richieste correlate, restituisci un messaggio di errore
                throw new RuntimeException("Impossibile eliminare il taxi. È associato a una o più richieste.");
            }

            // Dissocia l'utente dal taxi
            taxi.setDriver(null);
            taxiRepository.save(taxi);

            // Elimina il taxi
            taxiRepository.deleteById(id);
        } else {
            throw new RuntimeException("Impossibile trovare il taxi con ID: " + id);
        }
    }


}
