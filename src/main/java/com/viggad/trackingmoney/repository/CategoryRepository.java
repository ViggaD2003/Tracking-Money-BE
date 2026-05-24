package com.viggad.trackingmoney.repository;

import com.viggad.trackingmoney.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByAccountId(Long accountId);
}
