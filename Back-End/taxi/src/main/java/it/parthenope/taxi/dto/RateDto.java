package it.parthenope.taxi.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) che rappresenta una tariffa.
 */
public class RateDto {

    /**
     * ID della tariffa.
     */
    private Integer id;

    /**
     * Tipo di tariffa.
     */
    private String ratesType;

    /**
     * Importo della tariffa.
     */
    private BigDecimal amount;

    /**
     * Restituisce l'ID della tariffa.
     *
     * @return L'ID della tariffa.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'ID della tariffa.
     *
     * @param id L'ID della tariffa da impostare.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Restituisce il tipo di tariffa.
     *
     * @return Il tipo di tariffa.
     */
    public String getRatesType() {
        return ratesType;
    }

    /**
     * Imposta il tipo di tariffa.
     *
     * @param ratesType Il tipo di tariffa da impostare.
     */
    public void setRatesType(String ratesType) {
        this.ratesType = ratesType;
    }

    /**
     * Restituisce l'importo della tariffa.
     *
     * @return L'importo della tariffa.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Imposta l'importo della tariffa.
     *
     * @param amount L'importo della tariffa da impostare.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

