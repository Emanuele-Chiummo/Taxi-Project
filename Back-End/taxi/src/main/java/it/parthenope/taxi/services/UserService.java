package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;

@Service
public interface UserService {
    List<DriverDto> getAllUsers();

	List<DriverDto> getTassisti(String string);
}
