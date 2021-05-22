package com.market.buyer;


import com.market.seller.ServicesBySeller;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Order {

    @Id
    @SequenceGenerator(
            name="order_sequence",
            sequenceName="order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Long id;
    private Long buyerId;
    private Long serviceId;
    private LocalDate orderDate;
    private LocalDate deliveryDate;

    public Order(){

    }

    public Order(Long id, Long buyerId, Long serviceId, LocalDate orderDate, LocalDate deliveryDate) {
        this.id = id;
        this.buyerId = buyerId;
        this.serviceId = serviceId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public Order(Long buyerId, Long serviceId, LocalDate orderDate, LocalDate deliveryDate) {
        this.buyerId = buyerId;
        this.serviceId = serviceId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", serviceId=" + serviceId +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
