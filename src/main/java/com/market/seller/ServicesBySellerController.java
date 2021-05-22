package com.market.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/service")
public class ServicesBySellerController {

    private final ServicesBySellerService servicesBySellerService;
    //private Object listServices;


    @Autowired
    public ServicesBySellerController(ServicesBySellerService servicesBySellerService) {
        this.servicesBySellerService = servicesBySellerService;
    }



    @DeleteMapping(path="{servicesBySellerId}")
    public void deleteService(
            @PathVariable("servicesBySellerId")Long servicesBySellerId){
        servicesBySellerService.deleteService(servicesBySellerId);
    }

    @RequestMapping("/")
   public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<ServicesBySeller> listServices = servicesBySellerService.listAll(keyword);
       model.addAttribute("listServices", listServices);
        model.addAttribute("keyword", keyword);

        return "index";
    }
}
