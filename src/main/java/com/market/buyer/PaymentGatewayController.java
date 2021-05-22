package com.market.buyer;

import com.market.seller.ServicesBySellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/paymentGateway")
public class PaymentGatewayController {

    private final BuyerRepository buyerRepository;
    private final ServicesBySellerRepository servicesBySellerRepository;

    @Autowired
    public PaymentGatewayController(BuyerRepository buyerRepository, ServicesBySellerRepository servicesBySellerRepository) {
        this.buyerRepository = buyerRepository;
        this.servicesBySellerRepository = servicesBySellerRepository;
    }

    @GetMapping
    public String getPayment(long buyerId, long serviceId, double amount) {

        boolean buyerExists = buyerRepository.existsById(buyerId);
        boolean serviceExists = servicesBySellerRepository.existsById(serviceId);

        if (!buyerExists || !serviceExists) {
            throw new IllegalStateException("Payment was unsuccessful!");
        }

        String email = buyerRepository.findCustomerEmailById(buyerId);
        return  "Payment of Rs." + amount + "made by the buyer " + email + " is successful!";
    }
}
