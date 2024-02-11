package it.parthenope.taxi.dto;

/**
 * Data Transfer Object (DTO) che rappresenta un autista.
 */
public class DriverDto {

    /**
     * ID dell'autista.
     */
    private Integer id;

    /**
     * Nome dell'autista.
     */
    private String name;

    /**
     * Cognome dell'autista.
     */
    private String lastName;

    /**
     * Codice fiscale dell'autista.
     */
    private String fiscalCode;

    /**
     * Indirizzo email dell'autista.
     */
    private String email;

    /**
     * Numero di telefono mobile dell'autista.
     */
    private String mobilePhone;

    /**
     * Tipo di utente (es. tassista) associato all'autista.
     */
    private String userType;

    /**
     * Password dell'autista.
     */
    private String password;

    /**
     * Stato di attivazione dell'autista (1 se attivo, 0 se disattivo).
     */
    private Integer active;

    /**
     * Restituisce l'ID dell'autista.
     *
     * @return L'ID dell'autista.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'autista.
     *
     * @param id L'ID dell'autista da impostare.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dell'autista.
     *
     * @return Il nome dell'autista.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome dell'autista.
     *
     * @param name Il nome dell'autista da impostare.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il cognome dell'autista.
     *
     * @return Il cognome dell'autista.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Imposta il cognome dell'autista.
     *
     * @param lastName Il cognome dell'autista da impostare.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Restituisce il codice fiscale dell'autista.
     *
     * @return Il codice fiscale dell'autista.
     */
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Imposta il codice fiscale dell'autista.
     *
     * @param fiscalCode Il codice fiscale dell'autista da impostare.
     */
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * Restituisce l'indirizzo email dell'autista.
     *
     * @return L'indirizzo email dell'autista.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'indirizzo email dell'autista.
     *
     * @param email L'indirizzo email dell'autista da impostare.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce il numero di telefono mobile dell'autista.
     *
     * @return Il numero di telefono mobile dell'autista.
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Imposta il numero di telefono mobile dell'autista.
     *
     * @param mobilePhone Il numero di telefono mobile dell'autista da impostare.
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Restituisce il tipo di utente associato all'autista (es. tassista).
     *
     * @return Il tipo di utente associato all'autista.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Imposta il tipo di utente associato all'autista.
     *
     * @param userType Il tipo di utente associato all'autista da impostare.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Restituisce la password dell'autista.
     *
     * @return La password dell'autista.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password dell'autista.
     *
     * @param password La password dell'autista da impostare.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce lo stato di attivazione dell'autista (1 se attivo, 0 se disattivo).
     *
     * @return Lo stato di attivazione dell'autista.
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Imposta lo stato di attivazione dell'autista (1 se attivo, 0 se disattivo).
     *
     * @param active Lo stato di attivazione dell'autista da impostare.
     */
    public void setActive(Integer active) {
        this.active = active;
    }
}
