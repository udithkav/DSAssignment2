package com.market.seller;

import javax.persistence.*;

@Entity
@Table(name = "service_table")
public class ServicesBySeller {
    @Id
    @SequenceGenerator(name = "service_sequence", sequenceName = "service_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private Seller seller;
    private String serviceName;
    private String serviceType;
    private String serviceDescription;
    private Double servicePrice;


    public ServicesBySeller() {
    }

    public ServicesBySeller(Long id, Seller seller, String serviceName, String serviceType, String serviceDescription, Double servicePrice) {
        this.id = id;
        this.seller = seller;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

    public ServicesBySeller(Seller seller, String serviceName, String serviceType, String serviceDescription, Double servicePrice) {
        this.seller = seller;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public String toString() {
        return "ServicesBySeller{" +
                "id=" + id +
                ", seller=" + seller +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }

}
