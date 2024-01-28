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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private AuthMapper authMapper;

    public List<DriverDto> getAllUsers() {
        List<Driver> activeUsers = driverRepository.findByActive(1); // Filtra solo gli utenti attivi
        return activeUsers.stream()
                .map(authMapper::modelToDto)
                .collect(Collectors.toList());
    }

    
    @Override
    public List<DriverDto> getTassisti(String userType) {
        List<Driver> tassisti = driverRepository.findByUserType(userType);  

        return tassisti.stream()
                .map(authMapper::modelToDto)
                .collect(Collectors.toList());
    }
    
    @Override
    public Driver createUser(DriverDto driverDto) {
        Driver driver = authMapper.dtoToModel(driverDto);
        return driverRepository.save(driver);
    }
    
   
    
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

