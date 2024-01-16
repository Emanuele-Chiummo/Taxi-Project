package it.parthenope.taxi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRatesType() {
        return ratesType;
    }

    public void setRatesType(String ratesType) {
        this.ratesType = ratesType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}