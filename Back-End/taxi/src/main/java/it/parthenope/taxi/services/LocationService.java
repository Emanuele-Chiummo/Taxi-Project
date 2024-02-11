package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.model.Location;

/**
 * Servizio per la gestione delle posizioni nel sistema.
 */
@Service
public interface LocationService {

    /**
     * Crea una nuova posizione nel sistema.
     *
     * @param locationDto Un oggetto {@link LocationDto} contenente le informazioni della posizione da creare.
     * @return Un oggetto {@link LocationDto} rappresentante la posizione appena creata.
     */
    LocationDto createLocation(LocationDto locationDto);

    /**
     * Restituisce l'ID di una posizione dato il suo nome.
     *
     * @param locationName Il nome della posizione per la quale recuperare l'ID.
     * @return L'ID della posizione corrispondente al nome specificato.
     */
    Integer getLocationIdByName(String locationName);

    /**
     * Restituisce una lista di tutte le posizioni nel sistema.
     *
     * @return Una lista di oggetti {@link LocationDto} rappresentanti le posizioni nel sistema.
     */
    List<LocationDto> getAllLocation();
}

