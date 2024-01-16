package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.model.Driver;


public interface AuthMapper {
	
	Driver dtoToModel(DriverDto driverDto);

	DriverDto modelToDto(Driver driver);

}
