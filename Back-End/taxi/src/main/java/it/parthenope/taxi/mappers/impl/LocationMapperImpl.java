package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.LocationDto;
import it.parthenope.taxi.mappers.LocationMapper;
import it.parthenope.taxi.model.Location;

@Component
public class LocationMapperImpl implements LocationMapper{

	@Override
	public Location dtoToModel(LocationDto locationDto) {
		
		Location location = new Location();
		location.setId(locationDto.getId());
		location.setName(locationDto.getName());
		location.setGps(locationDto.getGps());

		return location;
	}

	@Override
	public LocationDto modelToDto(Location location) {
		LocationDto locationDto = new LocationDto();
		
		locationDto.setId(location.getId());
		locationDto.setName(location.getName());
		locationDto.setGps(location.getGps());

		return locationDto;
	}
	
	

}
