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
    private long buyerId;
    private long serviceId;
    private double amount;

    public PaymentGateway() {

    }

    public PaymentGateway(long buyerId, long serviceId, double amount) {
        this.buyerId = buyerId;
        this.serviceId = serviceId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentGateway{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", serviceId=" + serviceId +
                ", amount=" + amount +
                '}';
    }


}
