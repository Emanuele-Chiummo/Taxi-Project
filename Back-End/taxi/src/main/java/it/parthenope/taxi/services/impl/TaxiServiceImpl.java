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

/**
 * Implementazione {@link TaxiService} per la gestione dei taxi.
 */
@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiMapper taxiMapper;

    @Autowired
    private TaxiRepository taxiRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RequestRepository requestRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Crea un nuovo taxi nel sistema.
     *
     * @param taxiDto L'oggetto {@link TaxiDto} che contiene i dati del taxi.
     * @return Un oggetto {@link TaxiDto} rappresentante il taxi appena creato.
     * @see TaxiService#createTaxi(TaxiDto)
     */
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

    /**
     * Restituisce tutti i taxi attivi nel sistema.
     *
     * @return Una lista di oggetti {@link TaxiDto} rappresentanti tutti i taxi attivi nel sistema.
     * @see TaxiService#getAllTaxi()
     */
    @Override
    public List<TaxiDto> getAllTaxi() {
        List<Taxi> activeTaxis = taxiRepository.findByActive(1); // Filtra solo i taxi attivi
        return activeTaxis.stream()
                .map(taxiMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Restituisce l'ID del taxi associato a un guidatore.
     *
     * @param driverId L'ID del guidatore per il quale recuperare l'ID del taxi.
     * @return L'ID del taxi associato al guidatore.
     * @see TaxiService#getTaxiIdByDriverId(Integer)
     */
    @Override
    public Integer getTaxiIdByDriverId(Integer driverId) {
        Optional<Taxi> taxiOptional = taxiRepository.findByDriverId(driverId);

        if (taxiOptional.isPresent()) {
            return taxiOptional.get().getId();
        } else {
            return null;
        }
    }

    /**
     * Verifica se un guidatore possiede già un taxi nel sistema.
     *
     * @param driverId L'ID del guidatore da verificare.
     * @return `true` se il guidatore possiede un taxi, altrimenti `false`.
     * @see TaxiService#checkIfUserHasTaxi(Integer)
     */
    @Override
    public boolean checkIfUserHasTaxi(Integer driverId) {
        Optional<Taxi> existingTaxi = taxiRepository.findByDriverId(driverId);
        return existingTaxi.isPresent();
    }

    /**
     * Restituisce le informazioni del taxi con l'ID specificato.
     *
     * @param taxiId L'ID del taxi da recuperare.
     * @return Un oggetto {@link TaxiDto} rappresentante le informazioni del taxi.
     * @see TaxiService#getTaxiById(Integer)
     */
    @Override
    public TaxiDto getTaxiById(Integer taxiId) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
        return taxiOptional.map(taxiMapper::modelToDto).orElse(null);
    }

    /**
     * Verifica se esiste un taxi con l'ID specificato.
     *
     * @param id L'ID del taxi da verificare.
     * @return `true` se esiste un taxi con l'ID specificato, altrimenti `false`.
     * @see TaxiService#taxiExists(Integer)
     */
    @Override
    public boolean taxiExists(Integer id) {
        return taxiRepository.existsById(id);
    }

    /**
     * Aggiorna i dettagli di un taxi esistente nel sistema.
     *
     * @param taxiDto L'oggetto {@link TaxiDto} contenente i nuovi dettagli del taxi.
     * @see TaxiService#updateTaxi(TaxiDto)
     */
    @Override
    public void updateTaxi(TaxiDto taxiDto) {
        Taxi taxi = taxiMapper.dtoToModel(taxiDto);
        taxiRepository.save(taxi);
    }

    /**
     * Disattiva un taxi nel sistema.
     *
     * @param id L'ID del taxi da disattivare.
     * @see TaxiService#deactivateTaxi(Integer)
     */
    @Override
    public void deactivateTaxi(Integer id) {
        try {
            taxiRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Taxi not found with id: " + id);
        }
    }
}

