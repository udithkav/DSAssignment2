package com.market.buyer;

import javax.persistence.*;

@Entity
@Table(name = "mobile_payment_gateway_table")
public class MobilePayment {
    @Id
    @SequenceGenerator(
            name = "mobile_gateway_sequence",
            sequenceName = "mobile_gateway_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mobile_gateway_sequence"
    )

    private Long id;
    private long phone;
    private int pin;
    private double amount;

    public MobilePayment() {
    }

    public MobilePayment(long phone, int pin, double amount) {
        this.phone = phone;
        this.pin = pin;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MobilePayment{" +
                "id=" + id +
                ", phone=" + phone +
                ", pin=" + pin +
                ", amount=" + amount +
                '}';
    }
}
