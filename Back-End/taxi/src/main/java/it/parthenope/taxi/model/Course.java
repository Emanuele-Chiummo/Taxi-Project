package it.parthenope.taxi.model;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Rappresenta un corso nel sistema, con informazioni come la posizione di partenza e arrivo, la distanza in chilometri
 * e il tipo di tariffe applicate.
 */
@Entity
@Table(name = "courses")
public class Course {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "start_location_id")
    private Location startLocation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "end_location_id")
    private Location endLocation;

    @Column
    private BigDecimal km;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "rates_id")
    private Rates ratesType;

    @Column(name = "active")
    private Integer active;

    /**
     * Restituisce l'identificatore univoco del corso.
     *
     * @return L'identificatore del corso.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco del corso.
     *
     * @param id L'identificatore del corso.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce la posizione di partenza del corso.
     *
     * @return La posizione di partenza del corso.
     */
    public Location getStartLocation() {
        return startLocation;
    }

    /**
     * Imposta la posizione di partenza del corso.
     *
     * @param startLocation La posizione di partenza del corso.
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Restituisce la posizione di arrivo del corso.
     *
     * @return La posizione di arrivo del corso.
     */
    public Location getEndLocation() {
        return endLocation;
    }

    /**
     * Imposta la posizione di arrivo del corso.
     *
     * @param endLocation La posizione di arrivo del corso.
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Restituisce la distanza in chilometri del corso.
     *
     * @return La distanza in chilometri del corso.
     */
    public BigDecimal getKm() {
        return km;
    }

    /**
     * Imposta la distanza in chilometri del corso.
     *
     * @param km La distanza in chilometri del corso.
     */
    public void setKm(BigDecimal km) {
        this.km = km;
    }

    /**
     * Restituisce il tipo di tariffe applicate al corso.
     *
     * @return Il tipo di tariffe applicate al corso.
     */
    public Rates getRatesType() {
        return ratesType;
    }

    /**
     * Imposta il tipo di tariffe applicate al corso.
     *
     * @param ratesType Il tipo di tariffe applicate al corso.
     */
    public void setRatesType(Rates ratesType) {
        this.ratesType = ratesType;
    }

    /**
     * Restituisce lo stato di attivazione del corso.
     *
     * @return Lo stato di attivazione del corso.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Imposta lo stato di attivazione del corso.
     *
     * @param active Lo stato di attivazione del corso.
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    /**
     * Restituisce la versione seriale della classe.
     *
     * @return La versione seriale della classe.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}