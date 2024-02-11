package it.parthenope.taxi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Rappresenta un utente (tassista o altro) nel sistema.
 */
@Entity
@Table(name = "users")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fiscal_code")
    private String fiscalCode;

    @Column
    private String email;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Integer active;

    /**
     * Restituisce l'identificatore univoco dell'utente.
     *
     * @return L'identificatore dell'utente.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco dell'utente.
     *
     * @param id L'identificatore dell'utente.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dell'utente.
     *
     * @return Il nome dell'utente.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome dell'utente.
     *
     * @param name Il nome dell'utente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il cognome dell'utente.
     *
     * @return Il cognome dell'utente.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Imposta il cognome dell'utente.
     *
     * @param lastName Il cognome dell'utente.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Restituisce il codice fiscale dell'utente.
     *
     * @return Il codice fiscale dell'utente.
     */
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Imposta il codice fiscale dell'utente.
     *
     * @param fiscalCode Il codice fiscale dell'utente.
     */
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * Restituisce l'indirizzo email dell'utente.
     *
     * @return L'indirizzo email dell'utente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'indirizzo email dell'utente.
     *
     * @param email L'indirizzo email dell'utente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce il numero di telefono mobile dell'utente.
     *
     * @return Il numero di telefono mobile dell'utente.
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Imposta il numero di telefono mobile dell'utente.
     *
     * @param mobilePhone Il numero di telefono mobile dell'utente.
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Restituisce il tipo di utente associato all'utente.
     *
     * @return Il tipo di utente dell'utente.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Imposta il tipo di utente dell'utente.
     *
     * @param userType Il tipo di utente dell'utente.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Restituisce la password dell'utente.
     *
     * @return La password dell'utente.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password dell'utente.
     *
     * @param password La password dell'utente.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce lo stato di attivazione dell'utente.
     *
     * @return Lo stato di attivazione dell'utente.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Imposta lo stato di attivazione dell'utente.
     *
     * @param active Lo stato di attivazione dell'utente.
     */
    public void setActive(Integer active) {
        this.active = active;
    }
}