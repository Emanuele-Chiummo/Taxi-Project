package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.model.Driver;

@Service
public interface UserService {
    List<DriverDto> getAllUsers();

	List<DriverDto> getTassisti(String string);

	void deactivateDriver(Integer id);

	Driver createUser(DriverDto driverDto);

	boolean userExist(Integer id);

	void updateUser(DriverDto driverDto);
}
