package it.parthenope.taxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.mappers.AuthMapper;
import it.parthenope.taxi.model.Driver;
import it.parthenope.taxi.repository.DriverRepository;
import it.parthenope.taxi.services.AuthService;

/**
 * Implementazione di {@link AuthService} per il servizio di autenticazione degli utenti.
 *
 * @see AuthService
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private DriverRepository driverRepository;

    /**
     * Mapper per la conversione tra oggetti Driver e DriverDto.
     *
     * @see AuthMapper
     */
    @Autowired
    private AuthMapper authMapper;

    /**
     * Autentica un utente nel sistema utilizzando un nome utente e una password.
     *
     * @param username Nome utente dell'utente da autenticare.
     * @param password Password dell'utente da autenticare.
     * @return Un oggetto {@link DriverDto} rappresentante l'utente autenticato o null se l'autenticazione fallisce.
     * @see AuthService#authenticateUser(String, String)
     */
    @Override
    public DriverDto authenticateUser(String username, String password) {
        // Effettua la ricerca dell'utente nel repository in base al nome utente e alla password
        Driver driver = driverRepository.findByEmailAndPassword(username, password);

        // Verifica se l'utente è stato trovato
        if (driver == null) {
            return null; // L'autenticazione ha fallito, ritorna null
        }

        // Mappa l'oggetto Driver a un oggetto DriverDto utilizzando il mapper
        DriverDto driverDto = authMapper.modelToDto(driver);

        return driverDto; // Restituisce l'utente autenticato
    }
}
