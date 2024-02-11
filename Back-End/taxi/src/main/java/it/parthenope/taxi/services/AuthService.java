package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;

/**
 * Servizio per l'autenticazione degli utenti del sistema.
 * Fornisce un metodo per autenticare un utente e restituire le informazioni del conducente.
 */
@Service
public interface AuthService {

    /**
     * Autentica un utente nel sistema utilizzando le credenziali fornite.
     *
     * @param username Il nome utente dell'utente.
     * @param password La password dell'utente.
     * @return Un oggetto {@link DriverDto} contenente le informazioni del conducente se l'autenticazione ha successo,
     *         altrimenti null.
     */
    DriverDto authenticateUser(String username, String password);
}