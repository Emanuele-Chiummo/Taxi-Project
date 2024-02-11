package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.model.Rates;

/**
 * Interfaccia per la conversione tra oggetti DTO (RateDto) e oggetti modello (Rates).
 */
public interface RateMapper {

    /**
     * Converte un oggetto RateDto in un oggetto Rates.
     *
     * @param rateDto L'oggetto RateDto da convertire.
     * @return Un oggetto Rates convertito.
     */
    Rates dtoToModel(RateDto rateDto);

    /**
     * Converte un oggetto Rates in un oggetto RateDto.
     *
     * @param rate L'oggetto Rates da convertire.
     * @return Un oggetto RateDto convertito.
     */
    RateDto modelToDto(Rates rate);
}