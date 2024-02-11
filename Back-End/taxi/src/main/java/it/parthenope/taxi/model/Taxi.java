package it.parthenope.taxi.model;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Rappresenta le informazioni relative ai taxi.
 */
@Entity
@Table(name = "taxi")
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String identifier;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "active")
    private Integer active;

    /**
     * Restituisce l'identificatore univoco del taxi.
     *
     * @return L'identificatore del taxi.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco del taxi.
     *
     * @param id L'identificatore del taxi.
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
     * @param identifier L'identificatore del taxi.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Restituisce il conducente associato al taxi.
     *
     * @return Il conducente associato al taxi.
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Imposta il conducente associato al taxi.
     *
     * @param driver Il conducente associato al taxi.
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Restituisce lo stato di attivazione del taxi.
     *
     * @return Lo stato di attivazione del taxi.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Imposta lo stato di attivazione del taxi.
     *
     * @param active Lo stato di attivazione del taxi.
     */
    public void setActive(Integer active) {
        this.active = active;
    }
}