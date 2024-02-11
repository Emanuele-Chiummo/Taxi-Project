package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RateDto;
import it.parthenope.taxi.dto.TaxiDto;

/**
 * Servizio per la gestione delle tariffe nel sistema.
 */
@Service
public interface RateService {

    /**
     * Restituisce una lista di tutte le tariffe nel sistema.
     *
     * @return Una lista di oggetti {@link RateDto} rappresentanti le tariffe nel sistema.
     */
    List<RateDto> getAllRates();
}

