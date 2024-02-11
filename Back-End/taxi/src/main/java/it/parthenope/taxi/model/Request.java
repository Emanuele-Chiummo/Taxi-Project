package it.parthenope.taxi.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Rappresenta le richieste di servizio effettuate dai clienti.
 */
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "taxi_id")
    private Taxi taxi;

    @Column
    private Date date;

    @Column
    private String state;

    /**
     * Restituisce l'identificatore univoco della richiesta.
     *
     * @return L'identificatore della richiesta.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco della richiesta.
     *
     * @param id L'identificatore della richiesta.
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
     * @param course Il corso associato alla richiesta.
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
     * @param taxi Il taxi associato alla richiesta.
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
     * @param date La data della richiesta.
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
     * @param state Lo stato della richiesta.
     */
    public void setState(String state) {
        this.state = state;
    }
}
