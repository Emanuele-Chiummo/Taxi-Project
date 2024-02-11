package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.mappers.RateMapper;
import it.parthenope.taxi.model.Rates;

/**
 * Implementazione di {@link RateMapper} che gestisce la conversione tra oggetti DTO (RateDto) e oggetti modello (Rates).
 */
@Component
public class RateMapperImpl implements RateMapper {

    /**
     * Converte un oggetto RateDto in un oggetto Rates.
     *
     * @param rateDto L'oggetto RateDto da convertire.
     * @return Un oggetto Rates convertito.
     */
    @Override
    public Rates dtoToModel(RateDto rateDto) {
        Rates rates = new Rates();
        rates.setId(rateDto.getId());
        rates.setRatesType(rateDto.getRatesType());
        rates.setAmount(rateDto.getAmount());

        return rates;
    }

    /**
     * Converte un oggetto Rates in un oggetto RateDto.
     *
     * @param rates L'oggetto Rates da convertire.
     * @return Un oggetto RateDto convertito.
     */
    @Override
    public RateDto modelToDto(Rates rates) {
        RateDto rateDto = new RateDto();

        rateDto.setId(rates.getId());
        rateDto.setAmount(rates.getAmount());
        rateDto.setRatesType(rates.getRatesType());

        return rateDto;
    }
}

