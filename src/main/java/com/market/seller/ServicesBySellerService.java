package com.market.seller;

import com.market.buyer.Buyer;
import com.market.buyer.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesBySellerService {

    private final ServicesBySellerRepository servicesBySellerRepository;

    @Autowired
    public ServicesBySellerService(ServicesBySellerRepository servicesBySellerRepository){
        this.servicesBySellerRepository = servicesBySellerRepository;
    }

    public void deleteService(Long servicesBySellerId) {

        boolean exists= servicesBySellerRepository.existsById(servicesBySellerId);
        if(!exists){
            throw  new IllegalStateException("Service with id "+servicesBySellerId+" does not exists");
        }

        servicesBySellerRepository.deleteById(servicesBySellerId);
    }

    public List<ServicesBySeller> listAll(String keyword) {
        if (keyword != null) {
            return servicesBySellerRepository.search(keyword);
        }

        return servicesBySellerRepository.findAll();
    }
}
