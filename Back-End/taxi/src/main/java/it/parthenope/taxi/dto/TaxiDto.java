package it.parthenope.taxi.dto;

import it.parthenope.taxi.model.Driver;

public class TaxiDto {

	private Integer id;

	private String identifier;

	private Driver driver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
