package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;

/**
 * Servizio per la gestione delle richieste nel sistema.
 */
@Service
public interface RequestService {

    /**
     * Crea una nuova richiesta nel sistema.
     *
     * @param requestDto Oggetto {@link RequestDto} che rappresenta la richiesta da creare.
     * @return L'oggetto {@link RequestDto} rappresentante la richiesta appena creata.
     */
    RequestDto createRequest(RequestDto requestDto);

    /**
     * Restituisce una lista di tutte le richieste nel sistema.
     *
     * @return Una lista di oggetti {@link RequestDto} rappresentanti le richieste nel sistema.
     */
    List<RequestDto> getAllRequest();

    /**
     * Verifica se una richiesta con l'ID specificato esiste nel sistema.
     *
     * @param id L'ID della richiesta da verificare.
     * @return True se la richiesta esiste, false altrimenti.
     */
    boolean requestExists(Integer id);

    /**
     * Aggiorna i dettagli di una richiesta nel sistema.
     *
     * @param requestDto Oggetto {@link RequestDto} che rappresenta la richiesta con i dettagli aggiornati.
     */
    void updateRequest(RequestDto requestDto);

    /**
     * Restituisce una lista di tutte le richieste nel sistema con lo stato specificato.
     *
     * @param state Lo stato delle richieste da restituire.
     * @return Una lista di oggetti {@link RequestDto} rappresentanti le richieste con lo stato specificato.
     */
    List<RequestDto> getAllRequestByState(String state);

    /**
     * Restituisce una lista di tutte le richieste associate a un taxi specifico.
     *
     * @param taxiId L'ID del taxi associato alle richieste.
     * @return Una lista di oggetti {@link RequestDto} rappresentanti le richieste associate al taxi specificato.
     */
    List<RequestDto> getMyRequests(Long taxiId);

    /**
     * Restituisce una lista delle rotte più popolari nel sistema.
     *
     * @return Una lista di array di oggetti rappresentanti le rotte più popolari nel sistema.
     */
    List<Object[]> findMostPopularRoutes();

    /**
     * Restituisce una lista dei taxi con il maggior numero di richieste completate.
     *
     * @return Una lista di array di oggetti rappresentanti i taxi con il maggior numero di richieste completate.
     */
    List<Object[]> findMostTaxiCourse();

    /**
     * Restituisce una lista dei taxi con il maggior importo guadagnato dalle richieste completate.
     *
     * @return Una lista di array di oggetti rappresentanti i taxi con il maggior importo guadagnato.
     */
    List<Object[]> findMostTaxiAmount();
}
