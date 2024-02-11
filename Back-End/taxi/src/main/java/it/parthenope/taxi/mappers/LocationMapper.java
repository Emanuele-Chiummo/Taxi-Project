package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.model.Location;

/**
 * Interfaccia per la conversione tra oggetti DTO (LocationDto) e oggetti modello (Location).
 */
public interface LocationMapper {

    /**
     * Converte un oggetto LocationDto in un oggetto Location.
     *
     * @param locationDto L'oggetto LocationDto da convertire.
     * @return Un oggetto Location convertito.
     */
    Location dtoToModel(LocationDto locationDto);

    /**
     * Converte un oggetto Location in un oggetto LocationDto.
     *
     * @param location L'oggetto Location da convertire.
     * @return Un oggetto LocationDto convertito.
     */
    LocationDto modelToDto(Location location);
}
