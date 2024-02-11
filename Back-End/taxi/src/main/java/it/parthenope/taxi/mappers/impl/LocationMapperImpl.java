package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.mappers.LocationMapper;
import it.parthenope.taxi.model.Location;

/**
 * Implementazione di {@link LocationMapper} che gestisce la conversione tra oggetti DTO (LocationDto) e oggetti modello (Location).
 */
@Component
public class LocationMapperImpl implements LocationMapper {

    /**
     * Converte un oggetto LocationDto in un oggetto Location.
     *
     * @param locationDto L'oggetto LocationDto da convertire.
     * @return Un oggetto Location convertito.
     */
    @Override
    public Location dtoToModel(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setGps(locationDto.getGps());

        return location;
    }

    /**
     * Converte un oggetto Location in un oggetto LocationDto.
     *
     * @param location L'oggetto Location da convertire.
     * @return Un oggetto LocationDto convertito.
     */
    @Override
    public LocationDto modelToDto(Location location) {
        LocationDto locationDto = new LocationDto();

        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setGps(location.getGps());

        return locationDto;
    }
}