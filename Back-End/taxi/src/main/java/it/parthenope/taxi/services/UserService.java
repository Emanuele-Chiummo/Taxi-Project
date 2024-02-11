package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.model.Driver;

/**
 * Servizio per la gestione degli utenti nel sistema.
 */
@Service
public interface UserService {

    /**
     * Ottiene una lista di tutti gli utenti nel sistema.
     *
     * @return Una lista di oggetti {@link DriverDto} rappresentanti gli utenti nel sistema.
     */
    List<DriverDto> getAllUsers();

    /**
     * Ottiene una lista di tassisti nel sistema in base a uno stato specificato.
     *
     * @param string Lo stato specificato per i tassisti da recuperare.
     * @return Una lista di oggetti {@link DriverDto} rappresentanti i tassisti nel sistema.
     */
    List<DriverDto> getTassisti(String string);

    /**
     * Disattiva un autista nel sistema.
     *
     * @param id L'ID dell'autista da disattivare.
     */
    void deactivateDriver(Integer id);

    /**
     * Crea un nuovo utente (autista) nel sistema.
     *
     * @param driverDto Oggetto {@link DriverDto} che rappresenta l'utente (autista) da creare.
     * @return L'oggetto {@link Driver} rappresentante l'utente (autista) appena creato.
     */
    Driver createUser(DriverDto driverDto);

    /**
     * Verifica se un utente con l'ID specificato esiste nel sistema.
     *
     * @param id L'ID dell'utente da verificare.
     * @return True se l'utente esiste, false altrimenti.
     */
    boolean userExist(Integer id);

    /**
     * Aggiorna i dettagli di un utente nel sistema.
     *
     * @param driverDto Oggetto {@link DriverDto} che rappresenta l'utente con i dettagli aggiornati.
     */
    void updateUser(DriverDto driverDto);
}
