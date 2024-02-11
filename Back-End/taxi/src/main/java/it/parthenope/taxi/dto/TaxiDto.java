package it.parthenope.taxi.dto;

import it.parthenope.taxi.model.Driver;

/**
 * Data Transfer Object (DTO) che rappresenta un taxi.
 */
public class TaxiDto {

    /**
     * ID del taxi.
     */
    private Integer id;

    /**
     * Identificatore del taxi.
     */
    private String identifier;

    /**
     * Autista associato al taxi.
     */
    private Driver driver;

    /**
     * Stato attivo/inattivo del taxi.
     */
    private Integer active;

    /**
     * Restituisce l'ID del taxi.
     *
     * @return L'ID del taxi.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID del taxi.
     *
     * @param id L'ID del taxi da impostare.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce l'identificatore del taxi.
     *
     * @return L'identificatore del taxi.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Imposta l'identificatore del taxi.
     *
     * @param identifier L'identificatore del taxi da impostare.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Restituisce l'autista associato al taxi.
     *
     * @return L'autista associato al taxi.
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Imposta l'autista associato al taxi.
     *
     * @param driver L'autista da associare al taxi.
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Restituisce lo stato attivo/inattivo del taxi.
     *
     * @return Lo stato attivo/inattivo del taxi.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Imposta lo stato attivo/inattivo del taxi.
     *
     * @param active Lo stato attivo/inattivo del taxi da impostare.
     */
    public void setActive(Integer active) {
        this.active = active;
    }
}
