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
    private AuthMapper authMapper;  

    public DriverDto authenticateUser(String username, String password) {
        Driver driver = driverRepository.findByEmailAndPassword(username, password);

        if (driver == null) {
            return null; 
        }

       
        DriverDto driverDto = authMapper.modelToDto(driver);

        return driverDto;
    }
}
