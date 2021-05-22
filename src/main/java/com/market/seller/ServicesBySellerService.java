package com.market.seller;

import com.market.buyer.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesBySellerService {

    private final ServicesBySellerRepository servicesBySellerRepository;

    @Autowired
    public ServicesBySellerService(ServicesBySellerRepository servicesBySellerRepository) {
        this.servicesBySellerRepository = servicesBySellerRepository;
    }

    public List<ServicesBySeller> getService(){
        return servicesBySellerRepository.findAll();
    }
}
