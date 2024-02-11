package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.TaxiDto;

/**
 * Servizio per la gestione dei taxi nel sistema.
 */
@Service
public interface TaxiService {

    /**
     * Crea un nuovo taxi nel sistema.
     *
     * @param taxiDto Oggetto {@link TaxiDto} che rappresenta il taxi da creare.
     * @return L'oggetto {@link TaxiDto} rappresentante il taxi appena creato.
     */
    TaxiDto createTaxi(TaxiDto taxiDto);

    /**
     * Restituisce una lista di tutti i taxi nel sistema.
     *
     * @return Una lista di oggetti {@link TaxiDto} rappresentanti i taxi nel sistema.
     */
    List<TaxiDto> getAllTaxi();

    /**
     * Ottiene l'ID del taxi associato a un determinato autista.
     *
     * @param driverId L'ID dell'autista.
     * @return L'ID del taxi associato all'autista specificato.
     */
    Integer getTaxiIdByDriverId(Integer driverId);

    /**
     * Ottiene i dettagli di un taxi specifico.
     *
     * @param taxiId L'ID del taxi.
     * @return L'oggetto {@link TaxiDto} rappresentante il taxi con l'ID specificato.
     */
    TaxiDto getTaxiById(Integer taxiId);

    /**
     * Verifica se un taxi con l'ID specificato esiste nel sistema.
     *
     * @param id L'ID del taxi da verificare.
     * @return True se il taxi esiste, false altrimenti.
     */
    boolean taxiExists(Integer id);

    /**
     * Aggiorna i dettagli di un taxi nel sistema.
     *
     * @param taxiDto Oggetto {@link TaxiDto} che rappresenta il taxi con i dettagli aggiornati.
     */
    void updateTaxi(TaxiDto taxiDto);

    /**
     * Verifica se un utente specificato ha già un taxi associato nel sistema.
     *
     * @param driverId L'ID dell'autista/utente.
     * @return True se l'utente ha già un taxi associato, false altrimenti.
     */
    boolean checkIfUserHasTaxi(Integer driverId);

    /**
     * Disattiva un taxi nel sistema.
     *
     * @param id L'ID del taxi da disattivare.
     */
    void deactivateTaxi(Integer id);
}

