package com.market.seller;

import com.market.buyer.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicesBySellerRepository extends JpaRepository<ServicesBySeller,Long> {

    //@Query("SELECT ss FROM ServicesBySeller ss WHERE ss.seller=?1 ")
    Optional<ServicesBySeller> findServiceBySeller(String serviceName);

}
