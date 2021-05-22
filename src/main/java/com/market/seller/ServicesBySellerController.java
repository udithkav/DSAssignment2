package com.market.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/service")
public class ServicesBySellerController {

    private final ServicesBySellerService servicesBySellerService;

    @Autowired
    public ServicesBySellerController(ServicesBySellerService servicesBySellerService) {
        this.servicesBySellerService = servicesBySellerService;
    }

    @PutMapping(path="{servicebysellerId}")
    public void updateserviceBySeller(
            @PathVariable("servicebysellerId")Long servicebysellerId,
            @RequestParam(required = false) Seller seller,
            @RequestParam(required = false) String serviceName,
            @RequestParam(required = false) String serviceType,
            @RequestParam(required = false) String serviceDescription,
            @RequestParam(required = false) Double servicePrice) {
        servicesBySellerService.updateServiceBySeller(servicebysellerId, seller, serviceName, serviceType, serviceDescription, servicePrice);
    }

}
