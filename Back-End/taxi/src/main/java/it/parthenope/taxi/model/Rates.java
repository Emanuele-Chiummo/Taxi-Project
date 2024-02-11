package it.parthenope.taxi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Rappresenta i tipi di tariffe disponibili nel sistema.
 */
@Entity
@Table(name = "rates")
public class Rates {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rates_type", nullable = false)
    private String ratesType; 

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal amount;

    /**
     * Restituisce l'identificatore univoco della tariffa.
     *
     * @return L'identificatore della tariffa.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta l'identificatore univoco della tariffa.
     *
     * @param id L'identificatore della tariffa.
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
     * @param ratesType Il tipo di tariffa.
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
     * @param amount L'importo della tariffa.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}