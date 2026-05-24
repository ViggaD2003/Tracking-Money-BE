package com.viggad.trackingmoney.repository;

import com.viggad.trackingmoney.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseRepository extends JpaRepository<Purchase, Long> {


}
