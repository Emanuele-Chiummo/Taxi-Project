package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.model.Location;

public interface LocationMapper {
	
	Location dtoToModel(LocationDto locationDto);

	LocationDto modelToDto(Location location);


}
