package it.parthenope.taxi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rates")
public class Rates {

    public enum RatesType {
        U("u"),
        E("e");

        private final String type;

        RatesType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rates_type", nullable = false)
    private RatesType ratesType;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RatesType getRatesType() {
		return ratesType;
	}

	public void setRatesType(RatesType ratesType) {
		this.ratesType = ratesType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    
    
}

