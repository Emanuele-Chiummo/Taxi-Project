package it.parthenope.taxi.dto;

import java.math.BigDecimal;

public class CourseDto {

    private Integer id;
    private LocationDto startLocation;
    private LocationDto endLocation;
    private BigDecimal km;
    private String ratesType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocationDto getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationDto startLocation) {
        this.startLocation = startLocation;
    }

    public LocationDto getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationDto endLocation) {
        this.endLocation = endLocation;
    }

    public BigDecimal getKm() {
        return km;
    }

    public void setKm(BigDecimal km) {
        this.km = km;
    }

    public String getRatesType() {
        return ratesType;
    }

    public void setRatesType(String ratesType) {
        this.ratesType = ratesType;
    }
}
