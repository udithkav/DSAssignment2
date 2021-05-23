package com.market.buyer;

import com.market.seller.ServicesBySellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public String makePayment(long creditCardNum, double amount, long cvcNumber, String cardHolderName) {

        return  "Payment successful!";
    }
}
