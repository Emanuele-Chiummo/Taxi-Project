package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.RequestMapper;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;
import it.parthenope.taxi.repository.RequestRepository;
import it.parthenope.taxi.services.RequestService;

/**
 * Implementazione di {@link RequestService} per la gestione delle richieste.
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private RequestRepository requestRepository;

    /**
     * Crea una nuova richiesta nel sistema.
     *
     * @param requestDto L'oggetto {@link RequestDto} che contiene i dati della richiesta.
     * @return Un oggetto {@link RequestDto} rappresentante la richiesta appena creata.
     * @see RequestService#createRequest(RequestDto)
     */
    @Override
    public RequestDto createRequest(RequestDto requestDto) {
        Request request = requestMapper.dtoToModel(requestDto);
        requestRepository.save(request);
        return requestMapper.modelToDto(request);
    }

    /**
     * Restituisce tutte le richieste nel sistema.
     *
     * @return Una lista di oggetti {@link RequestDto} rappresentanti tutte le richieste nel sistema.
     * @see RequestService#getAllRequest()
     */
    @Override
    public List<RequestDto> getAllRequest() {
        List<Request> allRequest = requestRepository.findAll();
        return allRequest.stream()
                .map(requestMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Verifica se esiste una richiesta con l'ID specificato.
     *
     * @param id L'ID della richiesta da verificare.
     * @return `true` se esiste una richiesta con l'ID specificato, altrimenti `false`.
     * @see RequestService#requestExists(Integer)
     */
    @Override
    public boolean requestExists(Integer id) {
        return requestRepository.existsById(id);
    }

    /**
     * Aggiorna i dettagli di una richiesta esistente nel sistema.
     *
     * @param requestDto L'oggetto {@link RequestDto} contenente i nuovi dettagli della richiesta.
     * @see RequestService#updateRequest(RequestDto)
     */
    @Override
    public void updateRequest(RequestDto requestDto) {
        Request request = requestMapper.dtoToModel(requestDto);
        requestRepository.save(request);
    }

    /**
     * Restituisce tutte le richieste nel sistema con lo stato specificato.
     *
     * @param state Lo stato delle richieste da recuperare.
     * @return Una lista di oggetti {@link RequestDto} rappresentanti le richieste con lo stato specificato.
     * @see RequestService#getAllRequestByState(String)
     */
    @Override
    public List<RequestDto> getAllRequestByState(String state) {
        List<Request> requestsByState = requestRepository.findByState(state);
        return requestsByState.stream()
                .map(requestMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Restituisce tutte le richieste accettate da un determinato taxi.
     *
     * @param taxiId L'ID del taxi per il quale recuperare le richieste accettate.
     * @return Una lista di oggetti {@link RequestDto} rappresentanti le richieste accettate dal taxi.
     * @see RequestService#getMyRequests(Long)
     */
    @Override
    public List<RequestDto> getMyRequests(Long taxiId) {
        List<Request> acceptedRequestsForTaxi = requestRepository.findByStateAndTaxiId("Accettata", taxiId);
        return acceptedRequestsForTaxi.stream()
                .map(requestMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Restituisce le rotte più popolari nel sistema.
     *
     * @return Una lista di array di oggetti rappresentanti le rotte più popolari.
     * @see RequestService#findMostPopularRoutes()
     */
    @Override
    public List<Object[]> findMostPopularRoutes() {
        return requestRepository.findMostPopularRoutes();
    }

    /**
     * Restituisce le informazioni sulle richieste più frequenti per ogni taxi.
     *
     * @return Una lista di array di oggetti rappresentanti le informazioni sulle richieste più frequenti per ogni taxi.
     * @see RequestService#findMostTaxiCourse()
     */
    @Override
    public List<Object[]> findMostTaxiCourse() {
        return requestRepository.findMostTaxiCourse();
    }

    /**
     * Restituisce le informazioni sulle richieste con l'importo più elevato per ogni taxi.
     *
     * @return Una lista di array di oggetti rappresentanti le informazioni sulle richieste con l'importo più elevato per ogni taxi.
     * @see RequestService#findMostTaxiAmount()
     */
    @Override
    public List<Object[]> findMostTaxiAmount() {
        return requestRepository.findMostTaxiAmount();
    }
}
