package com.market.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicesBySellerRepository extends JpaRepository<ServicesBySeller,Long> {

    @Query("SELECT ss FROM service_table ss WHERE ss.serviceName LIKE %?1%")
    public List<ServicesBySeller> search(String keyword);
}
