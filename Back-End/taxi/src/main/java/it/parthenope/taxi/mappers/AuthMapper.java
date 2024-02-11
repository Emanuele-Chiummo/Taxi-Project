package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.model.Driver;


/**
 * Interfaccia per la conversione tra oggetti DTO (DriverDto) e oggetti modello (Driver).
 */
public interface AuthMapper {

    /**
     * Converte un oggetto DriverDto in un oggetto Driver.
     *
     * @param driverDto L'oggetto DriverDto da convertire.
     * @return Un oggetto Driver convertito.
     */
    Driver dtoToModel(DriverDto driverDto);

    /**
     * Converte un oggetto Driver in un oggetto DriverDto.
     *
     * @param driver L'oggetto Driver da convertire.
     * @return Un oggetto DriverDto convertito.
     */
    DriverDto modelToDto(Driver driver);
}
