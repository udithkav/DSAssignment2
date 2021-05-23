package com.market.buyer;

import javax.persistence.*;


@Entity
@Table(name = "payment_gateway_table")
public class PaymentGateway {
    @Id
    @SequenceGenerator(
            name="gateway_sequence",
            sequenceName="gateway_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gateway_sequence"
    )

    private Long id;
    private long creditCardNum;
    private double amount;
    private long cvcNumber;
    private String cardHolderName;

    public PaymentGateway() {

    }

    public PaymentGateway(long creditCardNum, double amount, long cvcNumber, String cardHolderName) {
        this.creditCardNum = creditCardNum;
        this.amount = amount;
        this.cvcNumber = cvcNumber;
        this.cardHolderName = cardHolderName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getCvcNumber() {
        return cvcNumber;
    }

    public void setCvcNumber(long cvcNumber) {
        this.cvcNumber = cvcNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public String toString() {
        return "PaymentGateway{" +
                "id=" + id +
                ", creditCardNum=" + creditCardNum +
                ", amount=" + amount +
                ", cvcNumber=" + cvcNumber +
                ", cardHolderName='" + cardHolderName + '\'' +
                '}';
    }
}
