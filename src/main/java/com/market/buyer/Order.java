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
    private Buyer email;
    private ServicesBySeller serviceName;
    private LocalDate orderDate;
    private LocalDate deliveryDate;

    public Order(){

    }

    public Order(Long id, Buyer email, ServicesBySeller serviceName, LocalDate orderDate, LocalDate deliveryDate) {
        this.id = id;
        this.email = email;
        this.serviceName = serviceName;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public Order(Buyer email, ServicesBySeller serviceName, LocalDate orderDate, LocalDate deliveryDate) {
        this.email = email;
        this.serviceName = serviceName;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getEmail() {
        return email;
    }

    public void setEmail(Buyer email) {
        this.email = email;
    }

    public ServicesBySeller getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServicesBySeller serviceName) {
        this.serviceName = serviceName;
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
                ", email=" + email +
                ", serviceName=" + serviceName +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
