package com.market.buyer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> getBuyer(){
       return buyerRepository.findAll();
    }

    public void addNewOrder(Buyer buyer) {
        Optional<Buyer> customerOptional=buyerRepository.findCustomerByEmail(buyer.getEmail());
        if(customerOptional.isPresent()){
            throw new IllegalStateException("Please provide a valid email");
        }
        buyerRepository.save(buyer);
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
