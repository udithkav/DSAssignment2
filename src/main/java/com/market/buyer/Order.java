package com.market.buyer;

import com.market.seller.Seller;

import javax.persistence.*;
import java.util.Date;

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
    private Buyer buyer;
    private Seller seller;
    private Date orderDate;
    private Date deliveryDate;

    public Order(){

    }

    public Order(Long id, Buyer buyer, Seller seller, Date orderDate) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
