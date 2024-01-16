package it.parthenope.taxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.mappers.AuthMapper;
import it.parthenope.taxi.model.Driver;
import it.parthenope.taxi.repository.DriverRepository;
import it.parthenope.taxi.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private AuthMapper authMapper;  // Assumi che tu abbia un mapper per convertire Driver in DriverDto

    public DriverDto authenticateUser(String username, String password) {
        Driver driver = driverRepository.findByEmailAndPassword(username, password);

        if (driver == null) {
            return null;  // Se l'utente non è trovato, restituisci null
        }

        // Usa un mapper per convertire l'entità Driver in un DTO DriverDto
        DriverDto driverDto = authMapper.modelToDto(driver);

        return driverDto;
    }
}
