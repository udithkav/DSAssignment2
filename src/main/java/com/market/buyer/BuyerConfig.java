package com.market.buyer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BuyerConfig {

    @Bean
    CommandLineRunner commandLineRunner(BuyerRepository repository){
        return args -> {
           Buyer tharu= new Buyer(
                    "tharushi@exmaple.com",
                    "Tharu",
                    "Rach",
                    "Ja ela",
                    "1544846545"
            );

            Buyer alex= new Buyer(
                    "alex@exmaple.com",
                    "Alex",
                    "Fernando",
                    "Colombo 2",
                    "54648456452"
            );

            repository.saveAll(
                    List.of(tharu,alex)
            );
        };
    }
}
