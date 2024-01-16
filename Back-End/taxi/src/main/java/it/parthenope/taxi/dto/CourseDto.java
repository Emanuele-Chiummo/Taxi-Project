package it.parthenope.taxi.dto;

import java.math.BigDecimal;

import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.model.Rates;

public class CourseDto {

    private Integer id;
    private Location startLocation;
    private Location endLocation;
    private BigDecimal km;
    private Rates ratesType;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Location getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}
	public Location getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	public BigDecimal getKm() {
		return km;
	}
	public void setKm(BigDecimal km) {
		this.km = km;
	}
	public Rates getRatesType() {
		return ratesType;
	}
	public void setRatesType(Rates ratesType) {
		this.ratesType = ratesType;
	}
	
    

    
}