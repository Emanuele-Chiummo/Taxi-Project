package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;

@Service
public interface AuthService {
    DriverDto authenticateUser(String username, String password);
}