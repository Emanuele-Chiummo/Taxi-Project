package it.parthenope.taxi.dto;


/**
 * Data Transfer Object (DTO) che rappresenta una posizione.
 */
public class LocationDto {

    /**
     * ID della posizione.
     */
    private Integer id;

    /**
     * Nome della posizione.
     */
    private String name;

    /**
     * Coordinate GPS della posizione.
     */
    private String gps;

    /**
     * Restituisce l'ID della posizione.
     *
     * @return L'ID della posizione.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID della posizione.
     *
     * @param id L'ID della posizione da impostare.
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
     * @param name Il nome della posizione da impostare.
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
     * @param gps Le coordinate GPS della posizione da impostare.
     */
    public void setGps(String gps) {
        this.gps = gps;
    }
}
