package it.parthenope.taxi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.mappers.AuthMapper;
import it.parthenope.taxi.model.Driver;
import it.parthenope.taxi.repository.DriverRepository;
import it.parthenope.taxi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<DriverDto> getAllUsers() {
        List<Driver> drivers = driverRepository.findAll();

        return drivers.stream()
                .map(authMapper::modelToDto)
                .collect(Collectors.toList());
    }
}

