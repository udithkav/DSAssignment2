package com.market.buyer;



import com.market.seller.ServicesBySeller;
import com.market.seller.ServicesBySellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final ServicesBySellerRepository servicesBySellerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository, ServicesBySellerRepository servicesBySellerRepository){
        this.buyerRepository = buyerRepository;
        this.servicesBySellerRepository = servicesBySellerRepository;
    }

    public List<Buyer> getBuyer(){
       return buyerRepository.findAll();
    }

    public void addNewOrder(Buyer buyer, ServicesBySeller servicesBySeller) {

        Optional<Buyer> customerOptional=buyerRepository.findCustomerByEmail(buyer.getEmail());
       Optional<ServicesBySeller> sellerOptional=servicesBySellerRepository.findServiceBySeller(servicesBySeller.getServiceName());

        if(customerOptional.isPresent() && sellerOptional.isPresent()){
            throw new IllegalStateException("Please provide a valid email");
        }
        buyerRepository.save(buyer);
        servicesBySellerRepository.save(servicesBySeller);
        //System.out.println(buyer);
    }

    public void deleteOrder(Long buyerId) {

        boolean exists= buyerRepository.existsById(buyerId);
        if(!exists){
            throw  new IllegalStateException("Order with id "+buyerId+" does not exists");
        }

        buyerRepository.deleteById(buyerId);
    }
}
