package com.market.seller;

import com.market.buyer.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {

}
