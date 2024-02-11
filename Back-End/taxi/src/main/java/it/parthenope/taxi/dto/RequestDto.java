package it.parthenope.taxi.dto;

import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Taxi;

import java.sql.Date;

/**
 * Data Transfer Object (DTO) che rappresenta una richiesta di taxi.
 */
public class RequestDto {

    /**
     * ID della richiesta.
     */
    private Integer id;

    /**
     * Corso associato alla richiesta.
     */
    private Course course;

    /**
     * Taxi associato alla richiesta.
     */
    private Taxi taxi;

    /**
     * Data della richiesta.
     */
    private Date date;

    /**
     * Stato della richiesta.
     */
    private String state;

    /**
     * Restituisce l'ID della richiesta.
     *
     * @return L'ID della richiesta.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID della richiesta.
     *
     * @param id L'ID della richiesta da impostare.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il corso associato alla richiesta.
     *
     * @return Il corso associato alla richiesta.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Imposta il corso associato alla richiesta.
     *
     * @param course Il corso da associare alla richiesta.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Restituisce il taxi associato alla richiesta.
     *
     * @return Il taxi associato alla richiesta.
     */
    public Taxi getTaxi() {
        return taxi;
    }

    /**
     * Imposta il taxi associato alla richiesta.
     *
     * @param taxi Il taxi da associare alla richiesta.
     */
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    /**
     * Restituisce la data della richiesta.
     *
     * @return La data della richiesta.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Imposta la data della richiesta.
     *
     * @param date La data della richiesta da impostare.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Restituisce lo stato della richiesta.
     *
     * @return Lo stato della richiesta.
     */
    public String getState() {
        return state;
    }

    /**
     * Imposta lo stato della richiesta.
     *
     * @param state Lo stato della richiesta da impostare.
     */
    public void setState(String state) {
        this.state = state;
    }
}
