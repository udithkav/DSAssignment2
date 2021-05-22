package com.market.seller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Objects;

public class ServicesBySellerService {

    private final ServicesBySellerRepository servicesBySellerRepository;

    @Autowired
    public ServicesBySellerService(ServicesBySellerRepository servicesBySellerRepository) {
        this.servicesBySellerRepository = servicesBySellerRepository;
    }

    @Transactional
    public void updateServiceBySeller(Long servicebysellerId,
                                      Seller seller,
                                      String serviceName,
                                      String serviceType,
                                      String serviceDescription,
                                      Double servicePrice) {
        ServicesBySeller servicesBySeller = servicesBySellerRepository.findById(servicebysellerId)
                .orElseThrow(() -> new IllegalStateException(
                        "serviceByseller with id" +servicebysellerId+ " does not exist"
                ));

        if (seller != null
                &&
                !Objects.equals(servicesBySeller.getSeller(), seller)) {
            servicesBySeller.setSeller(seller);
        }

        if (serviceName != null
                && serviceName.length() > 0 &&
                !Objects.equals(servicesBySeller.getServiceName(), serviceName)) {
            servicesBySeller.setServiceName(serviceName);
        }

        if (serviceType != null
                && serviceType.length() > 0 &&
                !Objects.equals(servicesBySeller.getServiceType(), serviceType)) {
            servicesBySeller.setServiceType(serviceType);
        }

        if (serviceDescription != null
                && serviceDescription.length() > 0 &&
                !Objects.equals(servicesBySeller.getServiceDescription(), serviceDescription)) {
            servicesBySeller.setServiceDescription(serviceDescription);
        }

        if (servicePrice != null
                &&
                !Objects.equals(servicesBySeller.getServicePrice(), servicePrice)) {
            servicesBySeller.setServicePrice(servicePrice);
        }



    }
}
