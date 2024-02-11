package it.parthenope.taxi.dto;

import it.parthenope.taxi.model.Taxi;

/**
 * Data Transfer Object (DTO) che rappresenta un'email.
 */
public class EmailDto {

    /**
     * ID dell'email.
     */
    private Integer id;

    /**
     * Mittente dell'email.
     */
    private String sender;

    /**
     * Oggetto dell'email.
     */
    private String subject;

    /**
     * Corpo dell'email.
     */
    private String body;

    /**
     * Stato dell'email.
     */
    private String state;

    /**
     * Taxi associato all'email.
     */
    private Taxi taxi;

    /**
     * Restituisce l'ID dell'email.
     *
     * @return L'ID dell'email.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'email.
     *
     * @param id L'ID dell'email da impostare.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il mittente dell'email.
     *
     * @return Il mittente dell'email.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Imposta il mittente dell'email.
     *
     * @param sender Il mittente dell'email da impostare.
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
     * @param subject L'oggetto dell'email da impostare.
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
     * @param body Il corpo dell'email da impostare.
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
     * @param state Lo stato dell'email da impostare.
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
     * @param taxi Il taxi associato all'email da impostare.
     */
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    /**
     * Restituisce una rappresentazione testuale dell'oggetto EmailDto.
     *
     * @return Una stringa rappresentante l'oggetto EmailDto.
     */
    @Override
    public String toString() {
        return "EmailDto{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", state='" + state + '\'' +
                ", taxi=" + taxi +
                '}';
    }
}
