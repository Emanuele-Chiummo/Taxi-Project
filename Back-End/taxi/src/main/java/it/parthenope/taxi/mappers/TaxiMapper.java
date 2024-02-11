package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.model.Taxi;

/**
 * Interfaccia per la conversione tra oggetti DTO (TaxiDto) e oggetti modello (Taxi).
 */
public interface TaxiMapper {

    /**
     * Converte un oggetto TaxiDto in un oggetto Taxi.
     *
     * @param taxiDto L'oggetto TaxiDto da convertire.
     * @return Un oggetto Taxi convertito.
     */
    Taxi dtoToModel(TaxiDto taxiDto);

    /**
     * Converte un oggetto Taxi in un oggetto TaxiDto.
     *
     * @param taxi L'oggetto Taxi da convertire.
     * @return Un oggetto TaxiDto convertito.
     */
    TaxiDto modelToDto(Taxi taxi);
}

