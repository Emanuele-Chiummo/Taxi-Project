package it.parthenope.taxi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.mappers.AuthMapper;
import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Driver;
import it.parthenope.taxi.repository.DriverRepository;
import it.parthenope.taxi.services.UserService;

/**
 * Implementazione {@link UserService} per la gestione degli utenti.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private AuthMapper authMapper;

    /**
     * Restituisce tutti gli utenti attivi nel sistema.
     *
     * @return Una lista di oggetti {@link DriverDto} rappresentanti tutti gli utenti attivi nel sistema.
     * @see UserService#getAllUsers()
     */
    @Override
    public List<DriverDto> getAllUsers() {
        List<Driver> activeUsers = driverRepository.findByActive(1); // Filtra solo gli utenti attivi
        return activeUsers.stream()
                .map(authMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Restituisce tutti i tassisti nel sistema in base al tipo di utente specificato.
     *
     * @param userType Il tipo di utente per il quale recuperare i tassisti.
     * @return Una lista di oggetti {@link DriverDto} rappresentanti i tassisti nel sistema.
     * @see UserService#getTassisti(String)
     */
    @Override
    public List<DriverDto> getTassisti(String userType) {
        List<Driver> tassisti = driverRepository.findByUserType(userType);

        return tassisti.stream()
                .map(authMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Crea un nuovo utente nel sistema.
     *
     * @param driverDto L'oggetto {@link DriverDto} che contiene i dati dell'utente.
     * @return Un oggetto {@link Driver} rappresentante l'utente appena creato.
     * @see UserService#createUser(DriverDto)
     */
    @Override
    public Driver createUser(DriverDto driverDto) {
        Driver driver = authMapper.dtoToModel(driverDto);
        return driverRepository.save(driver);
    }

    /**
     * Verifica se esiste un utente con l'ID specificato.
     *
     * @param id L'ID dell'utente da verificare.
     * @return `true` se esiste un utente con l'ID specificato, altrimenti `false`.
     * @see UserService#userExist(Integer)
     */
    @Override
    public boolean userExist(Integer id) {
        return driverRepository.existsById(id);
    }

    /**
     * Aggiorna i dettagli di un utente esistente nel sistema.
     *
     * @param driverDto L'oggetto {@link DriverDto} contenente i nuovi dettagli dell'utente.
     * @see UserService#updateUser(DriverDto)
     */
    @Override
    public void updateUser(DriverDto driverDto) {
        Driver user = authMapper.dtoToModel(driverDto);
        driverRepository.save(user);
    }

    /**
     * Disattiva un utente nel sistema.
     *
     * @param id L'ID dell'utente da disattivare.
     * @see UserService#deactivateDriver(Integer)
     */
    @Override
    public void deactivateDriver(Integer id) {
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isPresent()) {
            Driver driver = driverOptional.get();
            driver.setActive(0);
            driverRepository.save(driver);
        } else {
            throw new RuntimeException("Driver not found with id: " + id);
        }
    }
}


