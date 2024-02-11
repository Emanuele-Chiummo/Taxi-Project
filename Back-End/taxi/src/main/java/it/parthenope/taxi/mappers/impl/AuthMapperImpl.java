package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.mappers.AuthMapper;
import it.parthenope.taxi.model.Driver;

/**
 * Implementazione di {@link AuthMapper} che gestisce la conversione tra oggetti DTO (DriverDto) e oggetti modello (Driver).
 */
@Component
public class AuthMapperImpl implements AuthMapper {

    /**
     * Converte un oggetto DriverDto in un oggetto Driver.
     *
     * @param driverDto L'oggetto DriverDto da convertire.
     * @return Un oggetto Driver convertito.
     */
    public Driver dtoToModel(DriverDto driverDto) {
        if (driverDto == null) {
            return null;
        }

        Driver driver = new Driver();
        driver.setId(driverDto.getId());
        driver.setName(driverDto.getName());
        driver.setLastName(driverDto.getLastName());
        driver.setFiscalCode(driverDto.getFiscalCode());
        driver.setEmail(driverDto.getEmail());
        driver.setMobilePhone(driverDto.getMobilePhone());
        driver.setUserType(driverDto.getUserType());
        driver.setPassword(driverDto.getPassword());
        driver.setActive(driverDto.getActive());

        return driver;
    }

    /**
     * Converte un oggetto Driver in un oggetto DriverDto.
     *
     * @param driver L'oggetto Driver da convertire.
     * @return Un oggetto DriverDto convertito.
     */
    public DriverDto modelToDto(Driver driver) {
        if (driver == null) {
            return null;
        }

        DriverDto driverDto = new DriverDto();
        driverDto.setId(driver.getId());
        driverDto.setName(driver.getName());
        driverDto.setLastName(driver.getLastName());
        driverDto.setFiscalCode(driver.getFiscalCode());
        driverDto.setEmail(driver.getEmail());
        driverDto.setMobilePhone(driver.getMobilePhone());
        driverDto.setUserType(driver.getUserType());
        driverDto.setPassword(driver.getPassword());
        driverDto.setActive(driver.getActive());

        return driverDto;
    }
}
