package com.market.buyer;

import com.market.seller.ServicesBySellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/mobilePayment")
public class MobilePaymentController {

    private final BuyerRepository buyerRepository;
    private final ServicesBySellerRepository servicesBySellerRepository;

    @Autowired
    public MobilePaymentController(BuyerRepository buyerRepository, ServicesBySellerRepository servicesBySellerRepository) {
        this.buyerRepository = buyerRepository;
        this.servicesBySellerRepository = servicesBySellerRepository;
    }

    @PostMapping
    public String makeMobilePayment(long phone, int pin, double amount) {

        return "Payment Successful!";

    }


}
