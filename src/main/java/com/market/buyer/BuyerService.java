package com.market.buyer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateTheOrder(Long buyerId,
                               String email,
                               String firstname,
                               String lastname,
                               String address,
                               String pnone) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "order of buyer with id" +buyerId+"does not exist"
                ));

        if (email != null
                && email.length() > 0 &&
                !Objects.equals(buyer.getEmail(), email)) {
            Optional<Buyer> customerOptional = buyerRepository
                    .findCustomerByEmail(email);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            buyer.setEmail(email);
        }

        if (firstname != null
                && firstname.length() > 0 &&
                !Objects.equals(buyer.getFirstname(), firstname)) {
            buyer.setFirstname(firstname);
        }

        if (lastname != null
                && lastname.length() > 0 &&
                !Objects.equals(buyer.getLastname(), lastname)) {
            buyer.setLastname(lastname);
        }

        if (address != null
                && address.length() > 0 &&
                !Objects.equals(buyer.getAddress(), address)) {
            buyer.setAddress(address);
        }

        if (pnone != null
                && pnone.length() > 0 &&
                !Objects.equals(buyer.getPnone(), pnone)) {
            buyer.setPnone(pnone);
        }
    }
}
