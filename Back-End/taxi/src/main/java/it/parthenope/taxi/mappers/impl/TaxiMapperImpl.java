package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.TaxiMapper;
import it.parthenope.taxi.model.Taxi;

/**
 * Implementazione di {@link TaxiMapper} che gestisce la conversione tra oggetti DTO (TaxiDto) e oggetti modello (Taxi).
 */
@Component
public class TaxiMapperImpl implements TaxiMapper {

    /**
     * Converte un oggetto TaxiDto in un oggetto Taxi.
     *
     * @param taxiDto L'oggetto TaxiDto da convertire.
     * @return Un oggetto Taxi convertito.
     */
    @Override
    public Taxi dtoToModel(TaxiDto taxiDto) {
        Taxi taxi = new Taxi();
        taxi.setId(taxiDto.getId());
        taxi.setIdentifier(taxiDto.getIdentifier());
        taxi.setDriver(taxiDto.getDriver());
        taxi.setActive(taxiDto.getActive());
        return taxi;
    }

    /**
     * Converte un oggetto Taxi in un oggetto TaxiDto.
     *
     * @param taxi L'oggetto Taxi da convertire.
     * @return Un oggetto TaxiDto convertito.
     */
    @Override
    public TaxiDto modelToDto(Taxi taxi) {
        TaxiDto taxiDto = new TaxiDto();
        taxiDto.setId(taxi.getId());
        taxiDto.setIdentifier(taxi.getIdentifier());
        taxiDto.setDriver(taxi.getDriver());
        taxiDto.setActive(taxi.getActive());
        return taxiDto;
    }
}
