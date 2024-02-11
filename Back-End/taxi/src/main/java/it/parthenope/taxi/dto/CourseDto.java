package it.parthenope.taxi.dto;

import java.math.BigDecimal;

import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.model.Rates;

/**
 * Data Transfer Object (DTO) che rappresenta un corso taxi.
 */
public class CourseDto {

    /**
     * ID del corso taxi.
     */
    private Integer id;

    /**
     * Posizione di partenza del corso taxi.
     */
    private Location startLocation;

    /**
     * Posizione di destinazione del corso taxi.
     */
    private Location endLocation;

    /**
     * Distanza in chilometri del corso taxi.
     */
    private BigDecimal km;

    /**
     * Tipo di tariffe associate al corso taxi.
     */
    private Rates ratesType;

    /**
     * Stato di attivazione del corso taxi (1 se attivo, 0 se disattivo).
     */
    private Integer active;

    /**
     * Restituisce l'ID del corso taxi.
     *
     * @return L'ID del corso taxi.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID del corso taxi.
     *
     * @param id L'ID del corso taxi da impostare.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce la posizione di partenza del corso taxi.
     *
     * @return La posizione di partenza del corso taxi.
     */
    public Location getStartLocation() {
        return startLocation;
    }

    /**
     * Imposta la posizione di partenza del corso taxi.
     *
     * @param startLocation La posizione di partenza del corso taxi da impostare.
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Restituisce la posizione di destinazione del corso taxi.
     *
     * @return La posizione di destinazione del corso taxi.
     */
    public Location getEndLocation() {
        return endLocation;
    }

    /**
     * Imposta la posizione di destinazione del corso taxi.
     *
     * @param endLocation La posizione di destinazione del corso taxi da impostare.
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Restituisce la distanza in chilometri del corso taxi.
     *
     * @return La distanza in chilometri del corso taxi.
     */
    public BigDecimal getKm() {
        return km;
    }

    /**
     * Imposta la distanza in chilometri del corso taxi.
     *
     * @param km La distanza in chilometri del corso taxi da impostare.
     */
    public void setKm(BigDecimal km) {
        this.km = km;
    }

    /**
     * Restituisce il tipo di tariffe associate al corso taxi.
     *
     * @return Il tipo di tariffe associate al corso taxi.
     */
    public Rates getRatesType() {
        return ratesType;
    }

    /**
     * Imposta il tipo di tariffe associate al corso taxi.
     *
     * @param ratesType Il tipo di tariffe associate al corso taxi da impostare.
     */
    public void setRatesType(Rates ratesType) {
        this.ratesType = ratesType;
    }

    /**
     * Restituisce lo stato di attivazione del corso taxi (1 se attivo, 0 se disattivo).
     *
     * @return Lo stato di attivazione del corso taxi.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Imposta lo stato di attivazione del corso taxi (1 se attivo, 0 se disattivo).
     *
     * @param active Lo stato di attivazione del corso taxi da impostare.
     */
    public void setActive(Integer active) {
        this.active = active;
    }
}
