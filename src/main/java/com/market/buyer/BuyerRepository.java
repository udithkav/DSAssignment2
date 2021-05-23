package com.market.buyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    @Query("SELECT b FROM Buyer b WHERE b.email=?1 ")
    Optional<Buyer> findCustomerByEmail(String email);

}
