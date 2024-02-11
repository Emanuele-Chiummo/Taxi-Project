package it.parthenope.taxi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Rappresenta una posizione nel sistema.
 */
@Entity
@Table(name = "locations")
public class Location {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String gps;

    /**
     * Restituisce l'identificatore univoco della posizione.
     *
     * @return L'identificatore della posizione.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco della posizione.
     *
     * @param id L'identificatore della posizione.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il nome della posizione.
     *
     * @return Il nome della posizione.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome della posizione.
     *
     * @param name Il nome della posizione.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce le coordinate GPS della posizione.
     *
     * @return Le coordinate GPS della posizione.
     */
    public String getGps() {
        return gps;
    }

    /**
     * Imposta le coordinate GPS della posizione.
     *
     * @param gps Le coordinate GPS della posizione.
     */
    public void setGps(String gps) {
        this.gps = gps;
    }
}