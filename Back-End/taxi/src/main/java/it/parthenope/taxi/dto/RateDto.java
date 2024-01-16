package it.parthenope.taxi.dto;

import java.math.BigDecimal;

public class RateDto {

    private Integer id;
    private String ratesType;
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
