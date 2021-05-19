package com.market.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){

        this.buyerService = buyerService;
    }
    @GetMapping
    public List<Buyer> getBuyer(){

        return buyerService.getBuyer();
    }

    @PostMapping
    public void registerNewOrder(@RequestBody Buyer buyer){

        buyerService.addNewOrder(buyer);
    }

    @DeleteMapping(path="{buyerId}")
    public void deleteOrder(
            @PathVariable("buyerId")Long buyerId){
        buyerService.deleteOrder(buyerId);
    }
}
