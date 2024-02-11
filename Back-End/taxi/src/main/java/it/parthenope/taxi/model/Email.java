package it.parthenope.taxi.model;

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
 * Rappresenta un'email associata a un taxi nel sistema.
 */
@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "taxi_id")
    private Taxi taxi;

    /**
     * Restituisce l'identificatore univoco dell'email.
     *
     * @return L'identificatore dell'email.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco dell'email.
     *
     * @param id L'identificatore dell'email.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce l'indirizzo email del mittente.
     *
     * @return L'indirizzo email del mittente.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Imposta l'indirizzo email del mittente.
     *
     * @param sender L'indirizzo email del mittente.
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Restituisce l'oggetto dell'email.
     *
     * @return L'oggetto dell'email.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Imposta l'oggetto dell'email.
     *
     * @param subject L'oggetto dell'email.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Restituisce il corpo dell'email.
     *
     * @return Il corpo dell'email.
     */
    public String getBody() {
        return body;
    }

    /**
     * Imposta il corpo dell'email.
     *
     * @param body Il corpo dell'email.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Restituisce lo stato dell'email.
     *
     * @return Lo stato dell'email.
     */
    public String getState() {
        return state;
    }

    /**
     * Imposta lo stato dell'email.
     *
     * @param state Lo stato dell'email.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Restituisce il taxi associato all'email.
     *
     * @return Il taxi associato all'email.
     */
    public Taxi getTaxi() {
        return taxi;
    }

    /**
     * Imposta il taxi associato all'email.
     *
     * @param taxi Il taxi associato all'email.
     */
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}
